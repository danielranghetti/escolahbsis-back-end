package com.example.escolahbsis.turma;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IturmaReposytory extends JpaRepository<Turma, Long> {
    Optional<Turma> findByCodTurma(String codTurma);
}
