CREATE TABLE turma(
    id BIGINT IDENTITY(1,1) NOT NULL,
    instituicao VARCHAR(10) NOT NULL,
    cod_turma VARCHAR(10) NOT NULL PRIMARY KEY,
    periodo_turma VARCHAR(255) NOT NULL
);
ALTER TABLE turma
 ADD CONSTRAINT FK_instituicao_turma FOREIGN KEY (instituicao) REFERENCES instituicao(cod_instituicao);