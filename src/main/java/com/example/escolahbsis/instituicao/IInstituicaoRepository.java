package com.example.escolahbsis.instituicao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInstituicaoRepository extends JpaRepository<Instituicao, Long> {
}
