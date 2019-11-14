create database projEternize;

use projEternize;


create table empresa(
cnpj_empresa int not null auto_increment,
nome_empresa varchar(45) not null,
local_empresa varchar(45),
tel_empresa varchar(15),
primary key (cnpj_empresa)
)default charset = utf8;


desc empresa;


create table produto(
cod_prod int not null auto_increment,
nome_prod varchar(45) not null,
quant_prod int,
preco_prod double,
preco_compra double,
preco_venda double,
preco_total double,
primary key (cod_prod)
)default charset = utf8;


desc produto;


create table funcionario(
cod_func int not null auto_increment,
nome_func varchar(45),
tel_func varchar(15),
cpf_func varchar(15),
primary key (cod_func)
)default charset = utf8;


desc funcionario;


create table cliente(

cod_cli int not null auto_increment,
nome_cli varchar(30) not null,
cpf_cli int,
tel_cli int,
primary key(cod_cli)
)default charset = utf8;


desc cliente;


create table servico(
cod_servico int not null auto_increment,
tipo_servico varchar(30),
preco_servico decimal(5,2),
primary key(cod_servico)
)default charset = utf8;


alter table empresa
add column cod_func_empresa int;


alter table empresa
add foreign key (cod_func_empresa)
references funcionario(cod_func);


alter table empresa

add column cod_cli_empresa int;

alter table empresa
add foreign key (cod_cli_empresa)
references cliente(cod_cli);


alter table empresa
add column cod_servico_empresa int;

alter table empresa
add foreign key (cod_servico_empresa)
references servico(cod_servico);


alter table empresa
add column cod_produto_empresa int;


alter table empresa
add foreign key (cod_produto_empresa)
references produto(cod_prod);