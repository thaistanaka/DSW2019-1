create table Site (
email varchar(256) not null,
nome varchar(256) not null,
endereco varchar(256) not null,
senha varchar(256) not null,
telefone integer not null,
CONSTRAINT SITE_PK PRIMARY KEY (endereco));

create table Teatro (
email varchar(256) not null,
senha varchar(256) not null,
cnpj integer not null,
nome varchar(256) not null,
cidade varchar(256) not null,
CONSTRAINT TEATRO_PK PRIMARY KEY (cnpj)
);

create table Promocao (
endereco_site varchar(256) not null,
cnpj_teatro integer not null,
nome varchar(256) not null,
preco float not null,
dia varchar(256) not null,
hora varchar(256) not null,
CONSTRAINT PROMACAO_PK PRIMARY KEY (id),
CONSTRAINT PROMACAO_FK FOREIGN KEY (endereco_site) REFERENCES Site(endereco),
CONSTRAINT PROMACAO_FK2 FOREIGN KEY (cnpj_teatro)  REFERENCES Teatro(cnpj)
);

insert into Teatro values ('alo@alo','1234',12334,'ronaldo','brasilia');