CREATE TABLE aluno_turma(
    id BIGINT IDENTITY(1,1) NOT NULL,
    aluno VARCHAR(10) NOT NULL,
    turma VARCHAR(10) NOT NULL
);
ALTER TABLE aluno_turma
 ADD CONSTRAINT FK_aluno_turma FOREIGN KEY (aluno) REFERENCES aluno(cod_aluno);
 ALTER TABLE aluno_turma
 ADD CONSTRAINT FK_turma_aluno FOREIGN KEY (turma) REFERENCES turma(cod_turma);