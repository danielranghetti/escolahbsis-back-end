CREATE TABLE professor(
    id BIGINT IDENTITY(1,1) NOT NULL,
    cod_professor VARCHAR(10) NOT NULL PRIMARY KEY,
    nome_professor VARCHAR(50) NOT NULL,
    sobrenome_professor VARCHAR(100) NOT NULL,
    endereco_professor VARCHAR(250) NOT NULL,
    telefone_professor VARCHAR(14) NOT NULL,

);
CREATE UNIQUE index ix_cod_professor on professor(cod_professor asc);
