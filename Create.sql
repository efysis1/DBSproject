CREATE TABLE Riaditel
(
ID serial,
Meno VARCHAR(20),
Priezvisko VARCHAR (30),
email VARCHAR(60),
PRIMARY KEY(ID)
);
CREATE TABLE Spolocnost
(
ID serial,
Nazov VARCHAR(50),
Sidlo VARCHAR(100),
PRIMARY KEY(ID)
);
CREATE TABLE Riaditel_spolocnosti
(
ID serial,
Riaditel_ID integer NOT NULL,
Spolocnost_ID integer NOT NULL,
PRIMARY KEY(ID),
FOREIGN KEY(Riaditel_ID) REFERENCES Riaditel(ID),
FOREIGN KEY(Spolocnost_ID) REFERENCES Spolocnost(ID),
Pocet_rokov integer
);
CREATE TABLE Zamestnanci
(
ID serial,
PRIMARY KEY(ID),
Meno VARCHAR(20),
Priezvisko VARCHAR(20),
Vek integer
);
CREATE TABLE Zakazka
(
ID serial,
PRIMARY KEY(ID),
Priorita VARCHAR(20),
Cas_vystavenia TIMESTAMP
);
CREATE TABLE Produkt
(
ID serial,
PRIMARY KEY(ID),
Nazov VARCHAR(40),
Cena integer
);
CREATE TABLE Produkt_zakazky
(
ID serial,
PRIMARY KEY(ID),
Zakazka_ID integer NOT NULL,
Produkt_ID integer NOT NULL,
FOREIGN KEY(Zakazka_ID) REFERENCES Zakazka(ID),
FOREIGN KEY(Produkt_ID) REFERENCES Produkt(ID),
Stav_objednavky VARCHAR(20)
);