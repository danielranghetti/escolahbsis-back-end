CREATE TABLE disciplina(
    id BIGINT IDENTITY(1,1) NOT NULL,
    cod_disciplina VARCHAR(10) NOT NULL PRIMARY KEY,
    nome_disciplina VARCHAR(50) NOT NULL,
    professor VARCHAR(10) NOT NULL,

);
ALTER TABLE disciplina
 ADD CONSTRAINT FK_professor_disciplina FOREIGN KEY (professor) REFERENCES professor(cod_professor);
 create unique index ix_disciplina_cod_disciplina on disciplina (cod_disciplina asc);