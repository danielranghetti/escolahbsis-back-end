package com.example.escolahbsis.alunoTurma;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlunoTurmaRepository extends JpaRepository<AlunoTurma, Long> {
}
