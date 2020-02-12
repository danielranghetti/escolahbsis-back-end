package com.example.escolahbsis.nota;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface INotaRepository extends JpaRepository<Nota, Long> {
    Optional<Nota> findByCodNota(String codNota);
}
