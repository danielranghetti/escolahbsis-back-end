package com.example.escolahbsis.disciplina;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDisciplinaRepository extends JpaRepository<Disciplina, Long> {
    Optional<Disciplina> findByCodDisciplina(String codDisciplina);


}
