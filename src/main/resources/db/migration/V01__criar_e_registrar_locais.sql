CREATE TABLE locais (
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO locais (nome) values ('Chacara 2 vizinhos');
INSERT INTO locais (nome) values ('Quiosque do João');
INSERT INTO locais (nome) values ('Bar da esquina');
