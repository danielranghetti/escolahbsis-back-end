package com.example.escolahbsis.turma;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IturmaReposytory extends JpaRepository<Turma, Long> {
}
