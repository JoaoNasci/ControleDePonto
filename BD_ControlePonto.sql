create database ControleDePonto;
use ControleDePonto;

create table Funcionarios(
CPF bigint(11) unique not null primary key,
Nome varchar(100),
Setor varchar(50),
Cargo varchar(50)
);

insert into Funcionarios(cpf,nome,setor,cargo) values(12345678901,'Joao Pedro','Produção','Revisor');
insert into Funcionarios(cpf,nome,setor,cargo) values(23652381302,'Matheus','Produção','Tecelagem');
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
drop table Funcionarios;
insert into Registro_Ponto(Dia,Hora_entrada,Entrada_intervalo,Saida_intervalo,Hora_saida,funcionario_FK) 
values(current_date(),current_time(),'17:30:45','18:30:45','19:30:45',12345678901);
insert into Registro_Ponto(Dia,Hora_entrada,Entrada_intervalo,Saida_intervalo,Hora_saida,funcionario_FK) 
values(current_date(),current_time(),'17:30:45','18:30:45','19:30:45',23652381302);
select * from Registro_Ponto;


create table solicitacao(
Id int auto_increment not null primary key,
Funcionario bigint not null,
Ponto int not null,
Motivo varchar(150) not null,
foreign key(Funcionario) references funcionarios(CPF),
foreign key(Ponto) references registro_ponto(id)
);

select * from solicitacao;
insert into solicitacao(Funcionario,Ponto,Motivo) values(12345678901,1,"Hora errada");

DELIMITER $$

CREATE PROCEDURE listar_ponto_funcionario(IN cpf_func bigint)
BEGIN
     SELECT f.CPF as "CPF", f.Nome as "Nome", r.Dia as "Data", r.Hora_entrada as "Entrada", 
     r.Entrada_intervalo as "Entrada intervalo", r.Saida_intervalo as "Saida intervalo", r.Hora_saida as "Saida"
    FROM funcionarios f
    INNER JOIN Registro_Ponto r ON f.cpf = r.funcionario_FK
    WHERE f.CPF = cpf_func;
END $$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE listar_registros_ponto()
BEGIN
     SELECT f.CPF as "CPF", f.Nome as "Nome", r.Dia as "Data", r.Hora_entrada as "Entrada", 
     r.Entrada_intervalo as "Entrada intervalo", r.Saida_intervalo as "Saida intervalo", r.Hora_saida as "Saida"
    FROM funcionarios f
    Left JOIN Registro_Ponto r ON f.cpf = r.funcionario_FK;
END $$

DELIMITER ;


DELIMITER $$

CREATE PROCEDURE excluir_func(IN es bigint)
BEGIN
     DELETE FROM funcionarios WHERE cpf = es;
		DELETE FROM Registro_Ponto WHERE funcionario_FK = es;
END $$

DELIMITER ;

 DELIMITER $$

CREATE PROCEDURE inclusao(IN cpf_func bigint, nome_func varchar(100),
setor_func varchar(50),cargo_func varchar(50),
dia_func date, hora_entrada_fun time, hora_entrada_intervalo_fun time, hora_saida_intervalo_fun time, hora_saida_fun time )
BEGIN
    insert into Funcionarios(cpf,nome,setor,cargo) values(cpf_func,nome_func,setor_func,cargo_func);
    insert into Registro_Ponto(Dia,hora_entrada, entrada_intervalo, saida_intervalo, hora_saida, funcionario_FK) 
    values(dia_func, hora_entrada_fun, hora_entrada_intervalo_fun, hora_saida_intervalo_fun, hora_saida_fun, cpf_func);
END $$

DELIMITER ;

DELIMITER $$

CREATE PROCEDURE alterar(IN cpf_func bigint,
dia_func date, hora_entrada time, hora_entrada_intervalo time, hora_saida_intervalo time, hora_saida time 
)
BEGIN
	
    UPDATE Registro_Ponto SET hora_entrada = hora_entrada ,
	entrada_intervalo = hora_entrada_intervalo, saida_intervalo = hora_saida_intervalo,  
	hora_saida = hora_saida where dia = dia_func and funcionario_FK = cpf_func ;
    
END $$

DELIMITER ;


drop procedure if exists alterar;

call alterar();
call Excluir_Func(89452385124);
call Inclusao(89452385124,'Joao Pedro','Produção','Supervisor', '18:30:45' );
call listar_registros_ponto();
call listar_ponto_funcionario(12345678901);
call alterar(12345678901,"2025-05-25","05:00:00","09:10:00","10:10:00","13:30:00");
