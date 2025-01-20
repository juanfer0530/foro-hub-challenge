# ForoHub API

ForoHub API es una aplicación basada en Spring Boot que proporciona funcionalidades para gestionar un foro. Permite la autenticación de usuarios mediante tokens JWT y la gestión de tópicos (temas) dentro del foro.

## Características Principales

1. **Autenticación JWT**:
   - Los usuarios pueden autenticarse proporcionando credenciales válidas y obteniendo un token JWT.
   - El token se utiliza para autenticar las solicitudes posteriores.

2. **Gestión de tópicos**:
   - Crear nuevos tópicos.
   - Listar tópicos con soporte para paginación.
   - Consultar detalles de un tópico individual.
   - Actualizar tópicos existentes.
   - Eliminar tópicos.

## Tecnologías Utilizadas

- **Spring Boot** (Framework principal).
- **Spring Security** (Gestión de autenticación y seguridad).
- **JWT (JSON Web Tokens)** (Autenticación basada en tokens).
- **JPA con Hibernate** (Gestión de datos).
- **Flyway** (Migraciones de base de datos).
- **MySQL** (Base de datos).
- **Lombok** (Reducción de código repetitivo).

## Estructura de la API

### Endpoints de Autenticación

#### `POST /login`
- **Descripción**: Autentica al usuario y devuelve un token JWT.
- **Cuerpo de la solicitud**:
```json
{
  "login": "string",
  "clave": "string"
}
```
- **Respuesta**:
```json
{
  "JWTtoken": "string"
}
```

### Endpoints de Tópicos

#### `POST /topicos`
- **Descripción**: Crea un nuevo tópico.
- **Cuerpo de la solicitud**:
```json
{
  "titulo": "string",
  "mensaje": "string",
  "autor": "string",
  "curso": "string"
}
```
- **Respuesta**: Retorna el tópico creado con su ID.

#### `GET /topicos`
- **Descripción**: Lista los tópicos con soporte para paginación.
- **Parámetros de consulta**:
  - `size` (opcional): Tamaño de la página (por defecto 10).
  - `sort` (opcional): Campo por el cual ordenar (por defecto `fecha` en orden descendente).

#### `GET /topicos/{id}`
- **Descripción**: Devuelve los detalles de un tópico especificado por su ID.

#### `PUT /topicos`
- **Descripción**: Actualiza un tópico existente.
- **Cuerpo de la solicitud**:
```json
{
  "id": "long",
  "titulo": "string",
  "mensaje": "string",
  "autor": "string",
  "curso": "string"
}
```

#### `DELETE /topicos/{id}`
- **Descripción**: Elimina un tópico especificado por su ID.

## Configuración Inicial

1. **Clonar el repositorio**:
```bash
git clone <URL_DEL_REPOSITORIO>
```

2. **Configurar la base de datos**:
   - Asegúrese de tener un servidor MySQL en ejecución.
   - Configure las credenciales de la base de datos en `application.properties`.

3. **Ejecutar las migraciones de Flyway**:
   - Las migraciones automáticas se ejecutarán al iniciar la aplicación.

4. **Ejecutar la aplicación**:
```bash
./mvnw spring-boot:run
```

## Seguridad

- La seguridad está configurada con Spring Security.
- Las rutas protegidas requieren un token JWT válido en el encabezado `Authorization` con el formato:
```
Bearer <token>
```

## Dependencias

- `Spring Boot DevTools`
- `Spring Web`
- `Spring Security`
- `Spring Data JPA`
- `Flyway Migration`
- `MySQL Driver`
- `Validation`
- `Lombok`

## Próximos pasos

- Implementar pruebas unitarias y de integración.
- Añadir soporte para usuarios administradores con permisos adicionales.
- Mejorar la documentación con OpenAPI/Swagger.

## Licencia
Este proyecto está bajo la Licencia MIT. Puedes consultarla en el archivo `LICENSE`.

