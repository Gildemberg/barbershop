DROP DATABASE BARBERSHOP;

CREATE DATABASE BARBERSHOP;

USE BARBERSHOP;

CREATE TABLE BARBEARIA(
	CODBARBEARIA INT PRIMARY KEY AUTO_INCREMENT,
    NOMESOCIAL VARCHAR(100) NOT NULL,
    CNPJ VARCHAR(20) NOT NULL UNIQUE,
    EMAIL VARCHAR(30) NOT NULL UNIQUE,
    TELEFONE1 VARCHAR(15) NOT NULL UNIQUE,
    TELEFONE2 VARCHAR(15) NOT NULL UNIQUE,
    LOGIN VARCHAR(30) NOT NULL UNIQUE,
    SENHA VARCHAR(30) NOT NULL,
    DESCRICAO TEXT
);

CREATE TABLE SERVICO(
	CODSERVICO INT PRIMARY KEY AUTO_INCREMENT,
    NOME VARCHAR(50) NOT NULL,
    VALOR FLOAT(10,2) NOT NULL,
    FK_CODBARBEARIA INT
);

CREATE TABLE ENDERECO(
	CODENDERECO INT PRIMARY KEY AUTO_INCREMENT,
    RUA VARCHAR(30) NOT NULL,
    NUMERO VARCHAR(4) NOT NULL,
    BAIRRO VARCHAR(30) NOT NULL,
    CIDADE VARCHAR(30) NOT NULL,
    ESTADO VARCHAR(30) NOT NULL,
    FK_CODBARBEARIA INT,
    FK_CODCLIENTE INT
);

CREATE TABLE CLIENTE(
	CODCLIENTE INT PRIMARY KEY AUTO_INCREMENT,
    NOME VARCHAR(100) NOT NULL,
    CPF VARCHAR(20) NOT NULL UNIQUE,
    EMAIL VARCHAR(50) NOT NULL UNIQUE,
    TELEFONE VARCHAR(30) NOT NULL UNIQUE,
    LOGIN VARCHAR(30) NOT NULL UNIQUE,
    SENHA VARCHAR(30) NOT NULL
);

CREATE TABLE AGENDAMENTO(
	CODAGENDAMENTO INT PRIMARY KEY AUTO_INCREMENT,
    DATA DATE NOT NULL,
    HORARIO TIME NOT NULL,
    STATUS INT(1) NOT NULL,
    DESCRICAO VARCHAR(100) NOT NULL,
    FK_CODBARBEARIA INT NOT NULL,
    FK_CODCLIENTE INT NOT NULL,
    FK_CODSERVICO INT NOT NULL 
);

/*Status :
	0 - agendado
    1 - alterado
    2 - cancelado
    3 - concluido
    */

CREATE TABLE EXPEDIENTE(
	CODEXPEDIENTE INT PRIMARY KEY AUTO_INCREMENT,
    DATA DATE NOT NULL,
    HORAINICIO TIME NOT NULL,
    HORAFIM TIME NOT NULL,
    HORA TIME NOT NULL,
    FK_CODBARBEARIA INT NOT NULL,
    STATUS INT NOT NULL
);

CREATE TABLE EXTRATO(
	CODEXTRATO INT PRIMARY KEY AUTO_INCREMENT,
    FK_CODBARBEARIA INT NOT NULL,
    FK_CODAGENDAMENTO INT NOT NULL,
    DATA DATE NOT NULL,
    HORARIO TIME NOT NULL,
    VALOR_PAGO FLOAT(10,2) NOT NULL
);

ALTER TABLE EXTRATO ADD CONSTRAINT FK_BARBEARIA_EXTRATO
FOREIGN KEY (FK_CODBARBEARIA) REFERENCES BARBEARIA(CODBARBEARIA);

ALTER TABLE EXTRATO ADD CONSTRAINT FK_AGENDAMENTO_EXTRATO
FOREIGN KEY (FK_CODAGENDAMENTO) REFERENCES AGENDAMENTO(CODAGENDAMENTO);

ALTER TABLE SERVICO ADD CONSTRAINT FK_BARBEARIA_SERVICO
FOREIGN KEY (FK_CODBARBEARIA) REFERENCES BARBEARIA(CODBARBEARIA);

ALTER TABLE EXPEDIENTE ADD CONSTRAINT FK_BARBEARIA_EXPEDIENTE
FOREIGN KEY (FK_CODBARBEARIA) REFERENCES BARBEARIA(CODBARBEARIA);

ALTER TABLE ENDERECO ADD CONSTRAINT FK_BARBEARIA_ENDERECO
FOREIGN KEY (FK_CODBARBEARIA) REFERENCES BARBEARIA(CODBARBEARIA);

ALTER TABLE ENDERECO ADD CONSTRAINT FK_CLIENTE_ENDERECO
FOREIGN KEY (FK_CODCLIENTE) REFERENCES CLIENTE(CODCLIENTE);

ALTER TABLE AGENDAMENTO ADD CONSTRAINT FK_BARBEARIA_AGENDAMENTO
FOREIGN KEY (FK_CODBARBEARIA) REFERENCES BARBEARIA(CODBARBEARIA);

ALTER TABLE AGENDAMENTO ADD CONSTRAINT FK_CLIENTE_AGENDAMENTO
FOREIGN KEY (FK_CODCLIENTE) REFERENCES CLIENTE(CODCLIENTE);

ALTER TABLE AGENDAMENTO ADD CONSTRAINT FK_SERVICO_AGENDAMENTO
FOREIGN KEY (FK_CODSERVICO) REFERENCES SERVICO(CODSERVICO);

/* CADASTRO DE UMA EMPRESA */
INSERT INTO barbearia (NOMESOCIAL, CNPJ, EMAIL, TELEFONE1, TELEFONE2, LOGIN, SENHA, DESCRICAO) VALUES("Barbearia do Mário","01 203 080/1234-5","domario@gmail.com","(75) 98552-2541","(75) 98552-2545","mario","mario","A Barbearia do Mario é um espaço moderno e acolhedor onde estilo e tradição se encontram. Oferecemos cortes clássicos e contemporâneos, barba, tratamentos capilares e um toque especial em cada serviço. Nossa equipe experiente garante um atendimento personalizado, tornando sua visita uma experiência única. Seja para um corte rápido ou uma transformação, somos a escolha certa.");
INSERT INTO endereco (RUA, NUMERO, BAIRRO, CIDADE, ESTADO, FK_CODBARBEARIA) VALUES("Rua da Harmonia","520","Centro","Paulo Afonso","BA",1);
INSERT INTO servico (NOME, VALOR, TEMPO, FK_CODBARBEARIA) VALUES("Corte de cabelo","50","30","1");
INSERT INTO servico (NOME, VALOR, TEMPO, FK_CODBARBEARIA) VALUES("Corte de barba","30","20","1");

/* CADASTRO DE UM CLIENTE */
INSERT INTO cliente (NOME, CPF, EMAIL, TELEFONE, LOGIN, SENHA) VALUES("João da Silva Souza","082.115.657-28","joao@gmail.com","(75) 98881-0505","joao","joao");
INSERT INTO endereco (RUA, NUMERO, BAIRRO, CIDADE, ESTADO, FK_CODCLIENTE) VALUES("Rua da Harmonia","520","Centro","Paulo Afonso","BA",1);
