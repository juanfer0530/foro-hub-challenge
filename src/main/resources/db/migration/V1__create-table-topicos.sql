create table topicos(
id bigint not null auto_increment primary key,
curso varchar(255) not null,
titulo varchar(255) not null,
mensaje text not null,
autor varchar(255) not null,
fecha datetime not null default current_timestamp,
solucionado tinyint(1) not null default 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4