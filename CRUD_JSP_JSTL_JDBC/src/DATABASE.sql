drop database if exists academia;
create database academia;
use academia;

create table tb_instrutor(
	nome varchar(100),
	matricula varchar(8),
	ano_conclusao_graduacao int
);

create table tb_aluno(
	nome varchar(100),
	cpf varchar(11),
	sexo int,
	instrutor varchar(100),
	altura double,
	peso double
);
