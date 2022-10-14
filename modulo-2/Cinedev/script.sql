CREATE TABLE CINEMA(
	ID_CINEMA NUMBER NOT NULL,
	NOME VARCHAR2(200) NOT NULL,
	ESTADO VARCHAR2(200) NOT NULL,
	CIDADE VARCHAR2(200) NOT NULL,
	PRIMARY KEY(ID_CINEMA)
);

CREATE TABLE FILME(
	ID_FILME NUMBER NOT NULL,
	NOME VARCHAR2(200) NOT NULL,
	IDIOMA VARCHAR2(200) NOT NULL,
	CLASSIFICACAO NUMBER NOT NULL,
	DURACAO NUMBER NOT NULL,
	PRIMARY KEY(ID_FILME)
);

CREATE TABLE CLIENTE(
	ID_CLIENTE NUMBER NOT NULL,
	PRIMEIRO_NOME VARCHAR2(200) NOT NULL,
	ULTIMO_NOME VARCHAR2(200) NOT NULL,
	CPF VARCHAR2(11) UNIQUE NOT NULL,
	IDADE NUMBER NOT NULL,
	EMAIL VARCHAR2(200) NOT NULL,
	PRIMARY KEY(ID_CLIENTE)
);

CREATE TABLE INGRESSO(
	ID_INGRESSO NUMBER NOT NULL,
	ID_FILME NUMBER NOT NULL,
	ID_CLIENTE NUMBER NOT NULL,
	ID_CINEMA NUMBER NOT NULL,
	VALOR NUMBER NOT NULL,
	CADEIRA NUMBER NOT NULL,
	DATA_HORA TIMESTAMP NOT NULL,
	DISPONIBLIDADE CHAR NOT NULL,
	CONSTRAINT FK_INGRESSO_CLIENTE FOREIGN KEY (ID_CLIENTE) REFERENCES CLIENTE(ID_CLIENTE),
	CONSTRAINT FK_INGRESSO_FILME FOREIGN KEY (ID_FILME) REFERENCES FILME(ID_FILME),
	CONSTRAINT FK_INGRESSO_CINEMA FOREIGN KEY (ID_CINEMA) REFERENCES CINEMA(ID_CINEMA),
	PRIMARY KEY(ID_INGRESSO)
);

CREATE SEQUENCE SEQ_ID_CLIENTE
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE SEQUENCE SEQ_ID_CINEMA
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE SEQUENCE SEQ_ID_FILME
INCREMENT BY 1
NOCACHE NOCYCLE;

CREATE SEQUENCE SEQ_ID_INGRESSO
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

INSERT INTO CINEMA (ID_CINEMA, NOME, ESTADO, CIDADE)
VALUES (SEQ_ID_CINEMA.nextval, 'GNC', 'RIO GRANDE DO SUL', 'PORTO ALEGRE' );

INSERT INTO FILME (ID_FILME, NOME, IDIOMA, CLASSIFICACAO, DURACAO)
VALUES (SEQ_ID_FILME.nextval, 'HOMEM ARANHA: SEM VOLTA PRA CASA ', 'DUBLADO', 12, 157);

INSERT INTO CLIENTE (ID_CLIENTE, PRIMEIRO_NOME, ULTIMO_NOME, CPF, IDADE, EMAIL)
VALUES (SEQ_ID_CLIENTE.nextval, 'MARCO', 'VAN BASTEN', '99999999999', 45, 'MARCO@DBC.COM')

INSERT INTO INGRESSO (ID_INGRESSO,ID_CINEMA, ID_FILME, ID_CLIENTE, VALOR, CADEIRA, DATA_HORA, DISPONIBLIDADE)
VALUES (SEQ_ID_INGRESSO.nextval,1,1,1,15, 05, TO_DATE('21/10/22 21:30','dd-mm-yy hh24:mi'), 'S')

SELECT C.PRIMEIRO_NOME, C.CPF, C.EMAIL, F.NOME, F.DURACAO, CM.NOME, I.VALOR, I.CADEIRA, I.DATA_HORA, I.DISPONIBLIDADE 
FROM CLIENTE C
INNER JOIN INGRESSO I ON C.ID_CLIENTE = I.ID_CLIENTE 
INNER JOIN FILME F ON I.ID_FILME = F.ID_FILME 
INNER JOIN CINEMA CM ON I.ID_CINEMA = CM.ID_CINEMA;