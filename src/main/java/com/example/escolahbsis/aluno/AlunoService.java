package com.example.escolahbsis.aluno;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.*;

import java.util.Optional;

@Service
public class AlunoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AlunoService.class);

    private final IAlunoRepository iAlunoRepository;

    @Autowired
    public AlunoService(IAlunoRepository iAlunoRepository) {
        this.iAlunoRepository = iAlunoRepository;
    }

    public AlunoDTO save(AlunoDTO alunoDTO){

        this.validacao(alunoDTO);
        LOGGER.info("Salvando Aluno");
        LOGGER.debug("Aluno: {}", alunoDTO);

        Aluno aluno = new Aluno();

        aluno.setId(alunoDTO.getId());
        aluno.setCodAluno(alunoDTO.getCodAluno());
        aluno.setEnderecoAluno(alunoDTO.getEnderecoAluno());
        aluno.setMatricula(alunoDTO.getMatricula());
        aluno.setNomeAluno(alunoDTO.getNomeAluno());
        aluno.setSobrenomeAluno(alunoDTO.getSobrenomeAluno());
        aluno.setResponsavel(alunoDTO.getResponsavel());
        aluno.setTelefoneAluno(alunoDTO.getTelefoneAluno());

        aluno = this.iAlunoRepository.save(aluno);
        return AlunoDTO.of(aluno);
    }

    private void validacao(AlunoDTO alunoDTO){
        LOGGER.info("Validando Aluno");

        if (alunoDTO == null){
            throw new IllegalArgumentException("Aluno não deve ser nulo");
        }
        if (StringUtils.isEmpty(alunoDTO.getCodAluno())){
            throw new IllegalArgumentException("Código aluno não deve ser nulo");
        }
        if (StringUtils.isEmpty(alunoDTO.getEnderecoAluno())){
            throw new IllegalArgumentException("endereço do aluno não deve ser nulo");
        }
        if (StringUtils.isEmpty(alunoDTO.getMatricula())){
            throw new IllegalArgumentException("Matricula do aluno não deve ser nulo");
        }
        if (StringUtils.isEmpty(alunoDTO.getNomeAluno())){
            throw new IllegalArgumentException("Nome do aluno não deve ser nulo");
        }
        if (StringUtils.isEmpty(alunoDTO.getSobrenomeAluno())){
            throw new IllegalArgumentException("Sobrenome do aluno não deve ser nulo");
        }
        if (StringUtils.isEmpty(alunoDTO.getResponsavel())){
            throw new IllegalArgumentException("Responsavel do aluno não deve ser nulo");
        }
        if (StringUtils.isEmpty(alunoDTO.getTelefoneAluno())){
            throw new IllegalArgumentException("Telefone do aluno não deve ser nulo");
        }
    }

    public AlunoDTO update(AlunoDTO alunoDTO, long id){
        Optional<Aluno> alunoOptional = this.iAlunoRepository.findById(id);
        if (alunoOptional.isPresent()){
            Aluno alunoExistente = alunoOptional.get();

            LOGGER.info("Atualizando aluno de id: [{}]", alunoExistente.getId());
            LOGGER.debug("Payload: {}", alunoDTO);
            LOGGER.debug("Usuario Existente: {}", alunoExistente);

            alunoExistente.setNomeAluno(alunoDTO.getNomeAluno());
            alunoExistente.setSobrenomeAluno(alunoDTO.getSobrenomeAluno());
            alunoExistente.setEnderecoAluno(alunoDTO.getEnderecoAluno());
            alunoExistente.setResponsavel(alunoDTO.getResponsavel());
            alunoExistente.setTelefoneAluno(alunoDTO.getTelefoneAluno());
            alunoExistente.setMatricula(alunoDTO.getMatricula());

            alunoExistente = this.iAlunoRepository.save(alunoExistente);

            return AlunoDTO.of(alunoExistente);
        }
        throw new IllegalArgumentException(String.format("Aluno com o ID %s não esta cadastrado para ser alterado",id));
    }

    public void deleta(long id){
        LOGGER.info("Recebendo delete para aluno de ID: [{}]", id);
        this.iAlunoRepository.deleteById(id);
    }

    public AlunoDTO findById(long id){
        Optional<Aluno> alunoOptional = this.iAlunoRepository.findById(id);
        if (alunoOptional.isPresent()){
            return AlunoDTO.of(alunoOptional.get());
        }
        throw new IllegalArgumentException(String.format("Aluno com ID %s não cadastrado",id));
    }
    public AlunoDTO findByCodAluno(String codAluno){
        Optional<Aluno> alunoOptional = this.iAlunoRepository.findByCodAluno(codAluno);
        if (alunoOptional.isPresent()){
            return AlunoDTO.of(alunoOptional.get());
        }
        throw new IllegalArgumentException(String.format("Código Aluno %s não cadastrado",codAluno));
    }

}

