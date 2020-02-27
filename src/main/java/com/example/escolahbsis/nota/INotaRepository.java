package com.example.escolahbsis.nota;

import com.example.escolahbsis.aluno.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface INotaRepository extends JpaRepository<Nota, Long> {
    Optional<Nota> findByPeriodo(String periodo);

    List<Nota> findByAlunoAndPeriodo(Aluno aluno, String periodo);

}
