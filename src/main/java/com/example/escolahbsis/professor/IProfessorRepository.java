package com.example.escolahbsis.professor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProfessorRepository extends JpaRepository<Professor, Long> {
    Optional<Professor> findByCodProfessor(String codProfessor);
}
