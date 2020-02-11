package com.example.escolahbsis.aluno;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class AlunoConexao {
    private final IAlunoRepository iAlunoRepository;

    @Autowired
    public AlunoConexao(IAlunoRepository iAlunoRepository) {
        this.iAlunoRepository = iAlunoRepository;
    }

    public Aluno findByCodAlunoEntidade(String codAluno){
        Optional<Aluno> alunoOptional = this.iAlunoRepository.findByCodAluno(codAluno);
        if (alunoOptional.isPresent()){
            return alunoOptional.get();
        }
        throw new IllegalArgumentException(String.format("Código Aluno %s não cadastrado",codAluno));
    }
}
