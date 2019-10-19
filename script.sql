#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------

DROP DATABASE IF EXISTS Calcul_Mental;
CREATE DATABASE Calcul_Mental;
USE Calcul_Mental;
#------------------------------------------------------------
# Table: PLAYER
#------------------------------------------------------------

CREATE TABLE PLAYER(
        id       Int  Auto_increment  NOT NULL ,
        name     Varchar (50) NOT NULL ,
        login    Varchar (50) NOT NULL ,
        password Varchar (50) NOT NULL
	,CONSTRAINT PLAYER_PK PRIMARY KEY (id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: GAME
#------------------------------------------------------------

CREATE TABLE GAME(
        id_PLAYER Int NOT NULL ,
        id        Int Auto_increment NOT NULL ,
        PSEUDO    Varchar (50) NOT NULL ,
        SCORE     Int NOT NULL ,
        DATE      Varchar (50) NOT NULL
	,CONSTRAINT GAME_PK PRIMARY KEY (id)

	,CONSTRAINT GAME_PLAYER_FK FOREIGN KEY (id_PLAYER) REFERENCES PLAYER(id)
)ENGINE=InnoDB;
INSERT INTO PLAYER(name, login, password) VALUES ('REMY', 'REMS', 'POUETPOUET');
INSERT INTO PLAYER(name, login, password) VALUES ('SAMUEL', 'BAAL', 'POUETPOUET');
INSERT INTO PLAYER(name, login, password) VALUES ('SEGA', 'SYLLA', 'POUETPOUET');

INSERT INTO GAME(id_PLAYER, PSEUDO, SCORE, DATE)  VALUES ('1', 'REMS', '6', '19/10/19');
INSERT INTO GAME(id_PLAYER, PSEUDO, SCORE, DATE)  VALUES ('1', 'REMS', '8', '19/10/19');
INSERT INTO GAME(id_PLAYER, PSEUDO, SCORE, DATE)  VALUES ('1', 'REMS', '3', '19/10/19');
INSERT INTO GAME(id_PLAYER, PSEUDO, SCORE, DATE)  VALUES ('1', 'REMS', '5', '19/10/19');
INSERT INTO GAME(id_PLAYER, PSEUDO, SCORE, DATE)  VALUES ('2', 'BAAL', '9', '19/10/19');
INSERT INTO GAME(id_PLAYER, PSEUDO, SCORE, DATE)  VALUES ('2', 'BAAL', '8', '19/10/19');
INSERT INTO GAME(id_PLAYER, PSEUDO, SCORE, DATE)  VALUES ('2', 'BAAL', '6', '19/10/19');
INSERT INTO GAME(id_PLAYER, PSEUDO, SCORE, DATE)  VALUES ('2', 'BAAL', '2', '19/10/19');
INSERT INTO GAME(id_PLAYER, PSEUDO, SCORE, DATE)  VALUES ('2', 'BAAL', '6', '19/10/19');
INSERT INTO GAME(id_PLAYER, PSEUDO, SCORE, DATE)  VALUES ('3', 'SYLLA', '10', '19/10/19');
INSERT INTO GAME(id_PLAYER, PSEUDO, SCORE, DATE)  VALUES ('3', 'SYLLA', '10', '19/10/19');
INSERT INTO GAME(id_PLAYER, PSEUDO, SCORE, DATE)  VALUES ('3', 'SYLLA', '9', '19/10/19');
INSERT INTO GAME(id_PLAYER, PSEUDO, SCORE, DATE)  VALUES ('3', 'SYLLA', '2', '19/10/19');
INSERT INTO GAME(id_PLAYER, PSEUDO, SCORE, DATE)  VALUES ('3', 'SYLLA', '4', '19/10/19');
INSERT INTO GAME(id_PLAYER, PSEUDO, SCORE, DATE)  VALUES ('3', 'SYLLA', '5', '19/10/19');