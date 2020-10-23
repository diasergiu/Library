--DROP TABLE autor;
--DROP TABLE carte;
--DROP TABLE carte_autor_mapping;
--DROP TABLE editura;

CREATE TABLE IF NOT EXISTS Autor(
	id_autor INT AUTO_INCREMENT PRIMARY KEY,
	nume VARCHAR(250) NOT NULL,
	prenume VARCHAR(250) NOT NULL
);

CREATE TABLE IF NOT EXISTS Editura(
	id_editura INT AUTO_INCREMENT PRIMARY KEY,
	denumire_editura VARCHAR(250),
	UNIQUE (denumire_editura)
);

CREATE TABLE IF NOT EXISTS Carte(
	id_carte INT AUTO_INCREMENT PRIMARY KEY,
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


--
--INSERT INTO autor (nume, prenume) VALUES
--    ('Proust', 'Marcel'),
--    ('Frankopan', 'Viktor');

INSERT INTO editura(denumire_editura) VALUES
    ('Globo'),
    ('Nemira');
--
--INSERT INTO Carte (titlu, ISBN, an_publicatie, id_editura) values
--('tentoria', '973-123-1231', '2019-12-1', 1),
--('Victoria', '22334-121-231', '2018-4-1', 2);
