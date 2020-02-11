package com.example.escolahbsis.instituicao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IInstituicaoRepository extends JpaRepository<Instituicao, Long> {

    Optional<Instituicao> findByCodInstituicao(String codInstituicao);
}
