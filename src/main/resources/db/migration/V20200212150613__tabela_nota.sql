CREATE TABLE nota(
    id BIGINT IDENTITY(1,1) NOT NULL,
    cod_nota VARCHAR(10) NOT NULL PRIMARY KEY,
    nota DECIMAL(2,2) NOT NULL,
    periodo VARCHAR(20) NOT NULL,
    aluno VARCHAR(10) NOT NULL,
    disciplina VARCHAR(10) NULL
);
CREATE UNIQUE  index ix_nota_cod on nota(cod_nota);

ALTER TABLE nota
 ADD CONSTRAINT FK_aluno_nota FOREIGN KEY (aluno) REFERENCES aluno(cod_aluno);
ALTER TABLE nota
 ADD CONSTRAINT FK_disciplina_nota FOREIGN KEY (disciplina) REFERENCES disciplina(cod_disciplina);