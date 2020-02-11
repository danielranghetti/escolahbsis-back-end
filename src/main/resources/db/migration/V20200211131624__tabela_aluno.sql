CREATE TABLE aluno (

    id BIGINT IDENTITY(1,1) NOT NULL,
    cod_aluno VARCHAR(10) NOT NULL,
    nome_aluno VARCHAR(20) NOT NULL PRIMARY KEY,
    sobrenome_aluno VARCHAR(50) NOT NULL,
    responsavel VARCHAR(70) NOT NULL,
    telefone VARCHAR(14) NOT NULL,
    matricula INTEGER NOT NULL

);
create unique index ix_aluno_cod_aluno on aluno (cod_aluno asc);
create unique index ix_matricula on aluno (matricula asc);
