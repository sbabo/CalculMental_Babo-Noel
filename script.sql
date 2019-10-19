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
        id        Int NOT NULL ,
        PSEUDO    Varchar (50) NOT NULL ,
        SCORE     Int NOT NULL ,
        DATE      Date NOT NULL
	,CONSTRAINT GAME_PK PRIMARY KEY (id_PLAYER,id)

	,CONSTRAINT GAME_PLAYER_FK FOREIGN KEY (id_PLAYER) REFERENCES PLAYER(id)
)ENGINE=InnoDB;