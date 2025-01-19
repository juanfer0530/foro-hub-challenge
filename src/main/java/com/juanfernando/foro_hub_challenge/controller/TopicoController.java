package com.juanfernando.foro_hub_challenge.controller;


import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.juanfernando.foro_hub_challenge.domain.topico.Topico;
import com.juanfernando.foro_hub_challenge.domain.topico.TopicoRepository;
import com.juanfernando.foro_hub_challenge.domain.topico.dto.DatosActualizarTopico;
import com.juanfernando.foro_hub_challenge.domain.topico.dto.DatosListadoTopico;
import com.juanfernando.foro_hub_challenge.domain.topico.dto.DatosRegistroTopico;
import com.juanfernando.foro_hub_challenge.domain.topico.dto.DatosRespuestaTopico;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> agregarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uriComponentsBuilder){
        Topico topico = topicoRepository.save(new Topico(datosRegistroTopico));

        URI url = uriComponentsBuilder
            .path("/topicos/${id}")
            .buildAndExpand(topico.getId())
            .toUri();
    
            DatosRespuestaTopico respuesta = new DatosRespuestaTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFecha(),
                topico.getSolucionado(),
                topico.getAutor(),
                topico.getCurso()
            );
            
        return ResponseEntity.created(url).body(respuesta);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>>listarTopicos(@PageableDefault(size = 10, sort = {"fecha"}, direction = Sort.Direction.DESC) Pageable paginacion){
        Page<Topico> topicos = topicoRepository.findAll(paginacion);
        Page<DatosListadoTopico> listaTopicos = topicos.map(DatosListadoTopico::new);
        return ResponseEntity.ok(listaTopicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> mostrarTopicoIndividual(@PathVariable long id){

        Optional<Topico> topicoOptional = topicoRepository.findById(id);

        if(topicoOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Topico topico = topicoOptional.get();
        DatosRespuestaTopico datosTopico = new DatosRespuestaTopico(
                                                                    topico.getId(),
                                                                    topico.getTitulo(),
                                                                    topico.getMensaje(), 
                                                                    topico.getFecha(), 
                                                                    topico.getSolucionado(), 
                                                                    topico.getAutor(), 
                                                                    topico.getCurso());
        return ResponseEntity.ok(datosTopico);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Optional<Topico> topicOptional = topicoRepository.findById(datosActualizarTopico.id());

        if (topicOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Topico topico = topicOptional.get();
        topico.actualizarTopico(datosActualizarTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(),
                                                        topico.getTitulo(),
                                                        topico.getMensaje(), 
                                                        topico.getFecha(), 
                                                        topico.getSolucionado(), 
                                                        topico.getAutor(), 
                                                        topico.getCurso()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id){
        Optional<Topico> topicoOptional = topicoRepository.findById(id);

        if (topicoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
