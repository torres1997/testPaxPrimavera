create table Estado(
    id serial,
    uf varchar(5) NOT NULL,
    nome varchar(255) NOT NULL,
    primary key (id)
);
create table FILIAL(
    id serial,
    nome varchar(255) NOT NULL,
    FK_ESTADO int,
    CONSTRAINT FK_ESTADO FOREIGN KEY (FK_ESTADO) references Estado(id),
    primary key (id)
);
create TABLE PLANO(
    id serial,
    descricao varchar(255) NOT NULL,
    VALOR_MENSALIDADE decimal,
    primary key (id)
);
create TABLE CLIENTE(
    id serial,
    numero varchar(255) NOT NULL,
    nome varchar(255) NOT NULL,
    telefone varchar(255),
    endereco varchar(255),
    data_contrato date,
    data_cadastro date,
    numero_contrato int,
    fk_plano int,
    fk_filial int,
    CONSTRAINT FK_PLANO FOREIGN KEY (FK_PLANO) references PLANO(id),
    CONSTRAINT FK_FILIAL FOREIGN KEY (FK_FILIAL) references FILIAL(id)
);
