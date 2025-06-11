create database ControleDePonto;
use ControleDePonto;

create table Funcionarios(
CPF bigint(11) unique not null primary key,
Nome varchar(150) not null,
Senha varchar(16) not null,
email varchar(150) not null unique,
Setor varchar(50) not null,
Cargo varchar(50) not null,
Tipo int(1) not null
);


insert into Funcionarios(cpf,nome,email,senha,setor,cargo,Tipo) 
values(12345678901,'Joao Pedro','joao.tec@outlook.com','joao1234','Produção','Revisor', 1);
insert into Funcionarios(cpf,nome,email,senha,setor,cargo,Tipo) 
values(23652381302,'Matheus','duasToneladas@quilosMortais.kg.com','boiolade2toneladas123','Cozinha','Lixeira',0);

select * from funcionarios;


create table Registro_Ponto(
id int auto_increment primary key,
Dia date not null,
Hora_entrada time,
Entrada_intervalo time,
Saida_intervalo time,
Hora_saida time,
funcionario_FK bigint,
foreign key (Funcionario_FK) references funcionarios(cpf)
);

insert into Registro_Ponto(Dia,Hora_entrada,Entrada_intervalo,Saida_intervalo,Hora_saida,funcionario_FK) 
values(current_date(),current_time(),'17:30:45','18:30:45','19:30:45',12345678901);
insert into Registro_Ponto(Dia,Hora_entrada,Entrada_intervalo,Saida_intervalo,Hora_saida,funcionario_FK) 
values(current_date(),current_time(),'17:30:45','18:30:45','19:30:45',23652381302);
select * from Registro_Ponto;


create table Solicitacao(
Id int auto_increment not null primary key,
Funcionario_FK bigint not null,
Registro_Ponto_FK int not null,
Motivo varchar(150) not null,
foreign key(Funcionario_FK) references funcionarios(CPF),
foreign key(Registro_Ponto_FK) references registro_ponto(id)
);

select * from solicitacao;
insert into solicitacao(Funcionario_FK,Registro_Ponto_FK,Motivo) values(12345678901,1,"Hora errada");

DELIMITER $$

CREATE PROCEDURE listar_ponto_funcionario(IN Email_func varchar(100))
BEGIN

     SELECT f.Nome as "Nome", f.Email as "E-mail", r.Dia as "Data", r.Hora_entrada as "Entrada", 
     r.Entrada_intervalo as "Entrada intervalo", r.Saida_intervalo as "Saida intervalo", r.Hora_saida as "Saida"
    FROM funcionarios f
    INNER JOIN Registro_Ponto r ON f.cpf = r.funcionario_FK
    WHERE f.Email = Email_func;
END $$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE listar_Solicitacao()
BEGIN
     SELECT f.Nome as "Nome", f.Email as "E-mail",  r.Dia as "Data", r.Hora_entrada as "Entrada", 
     r.Entrada_intervalo as "Entrada intervalo", r.Saida_intervalo as "Saida intervalo", 
     r.Hora_saida as "Saida", s.Motivo as "Motivo"
    FROM Solicitacao s
    INNER JOIN funcionarios f on s.Funcionario = f.CPF
    INNER JOIN Registro_Ponto r ON s.Ponto = r.id;
END $$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE incluirSolicitacao(IN nome_fu varchar(100), data_fu date, Motivo_fun varchar(150))
BEGIN
	declare cpf_fun bigint;
    declare ponto_fun int;
    select CPF into cpf_fun from funcionarios where Nome = nome_fu limit 1;
    select id into ponto_fun from registro_ponto where funcionario_FK = cpf_fun and dia = data_fu limit 1;
	
    insert into solicitacao(Funcionario_FK,Registro_Ponto_FK,Motivo) values
    (cpf_fun, ponto_fun,Motivo_fun);
     
END $$

DELIMITER ;



DELIMITER $$

CREATE PROCEDURE excluir(IN nome_fu varchar(100), data_fu date)
BEGIN
	declare cpf_fun bigint;
    select CPF into cpf_fun from funcionarios where Nome = nome_fu limit 1;
	
     DELETE FROM solicitacao where Funcionario = cpf_fun;
     DELETE FROM registro_Ponto WHERE funcionario_FK = cpf_fun and Dia = data_fu;
     DELETE FROM funcionarios WHERE Nome = nome_fu;
END $$

DELIMITER ;

 DELIMITER $$

CREATE PROCEDURE inclusao(IN cpf_func bigint, nome_func varchar(100),email_func varchar(60),
setor_func varchar(50),cargo_func varchar(50),
dia_func date, hora_entrada_fun time, hora_entrada_intervalo_fun time, hora_saida_intervalo_fun time, hora_saida_fun time )
BEGIN
    insert into Funcionarios(cpf,nome,email,setor,cargo) values(cpf_func,nome_func, email_func, setor_func, cargo_func);
    insert into Registro_Ponto(Dia,hora_entrada, entrada_intervalo, saida_intervalo, hora_saida, funcionario_FK) 
    values(dia_func, hora_entrada_fun, hora_entrada_intervalo_fun, hora_saida_intervalo_fun, hora_saida_fun, cpf_func);
END $$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE alterar(IN Nome_fun varchar(150),
dia_func date, hora_entrada time, hora_entrada_intervalo time, hora_saida_intervalo time, hora_saida time 
)
BEGIN
	declare cpf_fun bigint;
    select CPF into cpf_fun from funcionarios where Nome = Nome_fun limit 1;
    
    UPDATE Registro_Ponto SET hora_entrada = hora_entrada ,
	entrada_intervalo = hora_entrada_intervalo, saida_intervalo = hora_saida_intervalo,  
	hora_saida = hora_saida where dia = dia_func and funcionario_FK = cpf_fun;
     
	DELETE FROM solicitacao where Funcionario = cpf_fun;
    
END $$

DELIMITER ;


-- drop procedure if exists listar_registros_ponto;


