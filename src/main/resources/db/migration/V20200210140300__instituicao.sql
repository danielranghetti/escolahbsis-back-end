CREATE TABLE instituicao(
    id BIGINT IDENTITY(1,1) NOT NULL,
    cod_instituicao  VARCHAR(10) NOT NULL PRIMARY KEY,
    nome_instituicao VARCHAR(255) NOT NULL,
    telefone_instituicao VARCHAR(14) NOT NULL,
    endereco_instituicao VARCHAR(255) NOT NULL
    );
create unique index ix_instituicao_id on instituicao (id asc);
create unique index ix_instituicao_cod_instituicao on instituicao (cod_instituicao asc);
