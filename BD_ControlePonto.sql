create database ControleDePonto;
use ControleDePonto;

create table Funcionarios(
cpf bigint(11) unique not null primary key,
nome varchar(100),
Setor varchar(50),
cargo varchar(50)
);
drop table funcionarios;
insert into Funcionarios(cpf,nome,setor,cargo) values(12345678901,'Joao Pedro','Produção','Revisor');
insert into Funcionarios(cpf,nome,setor,cargo) values(23652381302,'Matheus','Produção','Tecelagem');
select * from funcionarios;

create table Registro_Ponto(
id int auto_increment primary key,
Dia date not null,
hora_entrada time,
hora_saida time,
funcionario_FK bigint,
foreign key (Funcionario_FK) references funcionarios(cpf)
);

insert into Registro_Ponto(Dia,hora_entrada,hora_saida,funcionario_FK) values(current_date(),current_time(),'22:30:45',12345678901);
insert into Registro_Ponto(Dia,hora_entrada,hora_saida,funcionario_FK) values(current_date(),current_time(),'22:30:45',23652381302);
select * from Registro_Ponto;
DELIMITER $$

CREATE PROCEDURE listar_ponto_funcionario(IN cpf_func VARCHAR(14))
BEGIN
    SELECT f.cpf, f.nome, r.data, r.hora_entrada, r.hora_saida
    FROM funcionarios f
    INNER JOIN registros_ponto r ON f.cpf = r.cpf_funcionario
    WHERE f.cpf = cpf_func;
END $$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE listar_registros_ponto()
BEGIN
    SELECT f.cpf, f.nome, r.dia, r.hora_entrada, r.hora_saida
    FROM funcionarios f
    Left JOIN Registro_Ponto r ON f.cpf = r.funcionario_FK;
END $$

DELIMITER ;
DROP PROCEDURE IF EXISTS listar_registros_ponto;

call listar_registros_ponto();