-- enable to create full test index for carte
-- CREATE ALIAS IF NOT EXISTS FT_INIT FOR "org.h2.fulltext.FullText.init";
-- CALL FT_INIT();
create sequence CARTE_SEQ START WITH 1 INCREMENT BY 1;
create sequence AUTOR_SEQ START WITH 1 INCREMENT BY 1;
create sequence EDITURA_SEQ START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS Autor(
	id_autor INT default AUTOR_SEQ.nextval PRIMARY KEY,
	nume VARCHAR(250) NOT NULL,
	prenume VARCHAR(250) NOT NULL
);

CREATE TABLE IF NOT EXISTS Editura(
	id_editura INT default EDITURA_SEQ.nextval PRIMARY KEY,
	denumire_editura VARCHAR(250),
	UNIQUE (denumire_editura)
);

CREATE TABLE IF NOT EXISTS Carte(
	id_carte INT default CARTE_SEQ.nextval PRIMARY KEY,
	titlu VARCHAR(250) NOT NULL,
	ISBN VARCHAR(250) NOT NULL,
	an_publicatie DATE NOT NULL,
	id_editura INT,
	FOREIGN KEY (id_editura) REFERENCES editura(id_editura)
);

CREATE TABLE IF NOT EXISTS Carte_autor_mapping(
	id_carte INT NOT NULL,
	id_autor INT NOT NULL,
	PRIMARY KEY(id_carte, id_autor),
	FOREIGN KEY (id_carte) REFERENCES carte(id_carte),
	FOREIGN KEY (id_autor) REFERENCES autor(id_autor)
);

-- enable to create full test index for carte
-- CALL FT_CREATE_INDEX('PUBLIC', 'CARTE', NULL);
--

