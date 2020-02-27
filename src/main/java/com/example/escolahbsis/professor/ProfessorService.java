package com.example.escolahbsis.professor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class ProfessorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProfessorService.class);

    private final IProfessorRepository iProfessorRepository;

    @Autowired
    public ProfessorService(IProfessorRepository iProfessorRepository) {
        this.iProfessorRepository = iProfessorRepository;
    }

    public ProfessorDTO save(ProfessorDTO professorDTO) {
        this.validacao(professorDTO);
        LOGGER.info("Salvando professor");
        LOGGER.debug("Professor: {}", professorDTO);

        Professor professor = new Professor();

        professor.setId(professorDTO.getId());
        professor.setCodProfessor(professorDTO.getCodProfessor());
        professor.setNomeProfessor(professorDTO.getNomeProfessor());
        professor.setSobrenomeProfessor(professorDTO.getSobrenomeProfessor());
        professor.setEnderecoProfessor(professorDTO.getEnderecoProfessor());
        professor.setTelefoneProfessor(professorDTO.getTelefoneProfessor());

        professor = iProfessorRepository.save(professor);
        return ProfessorDTO.of(professor);

    }

    public void validacao(ProfessorDTO professorDTO) {
        LOGGER.info("validando Professor");
        if (professorDTO == null) {
            throw new IllegalArgumentException("Professor não deve ser nulo");
        }
        if (StringUtils.isEmpty(professorDTO.getCodProfessor())) {
            throw new IllegalArgumentException("Código de professor deve ser informado");
        }
        if (professorDTO.getCodProfessor().length() != 4) {
            throw new IllegalArgumentException("Código do professor deve conter 4 digitos");
        }
        if (StringUtils.isEmpty(professorDTO.getEnderecoProfessor())) {
            throw new IllegalArgumentException("O endereço do professor deve ser informado");
        }
        if (StringUtils.isEmpty(professorDTO.getNomeProfessor())) {
            throw new IllegalArgumentException("O nome do professor deve ser informado");
        }
        if (StringUtils.isEmpty(professorDTO.getSobrenomeProfessor())) {
            throw new IllegalArgumentException("O sobrenome do professor deve ser informado");
        }
        if (StringUtils.isEmpty(professorDTO.getTelefoneProfessor())) {
            throw new IllegalArgumentException("O telefoene do professor deve ser informado");
        }
    }

    public ProfessorDTO findById(long id) {
        Optional<Professor> professorOptional = this.iProfessorRepository.findById(id);

        if (professorOptional.isPresent()) {
            return ProfessorDTO.of(professorOptional.get());
        }
        throw new IllegalArgumentException(String.format("Professor de ID %s não existe", id));
    }


    public Professor findByCodProfessorEntidade(String codProfessor) {
        Optional<Professor> professorOptional = this.iProfessorRepository.findByCodProfessor(codProfessor);

        if (professorOptional.isPresent()) {
            return professorOptional.get();
        }
        throw new IllegalArgumentException(String.format("Professor de código %s não cadastrado", codProfessor));
    }

    public ProfessorDTO update(ProfessorDTO professorDTO, long id) {
        Optional<Professor> optionalProfessor = this.iProfessorRepository.findById(id);

        if (optionalProfessor.isPresent()) {
            Professor professorExistente = optionalProfessor.get();

            LOGGER.info("Atualizando Professor... id: [{}]", professorExistente.getId());
            LOGGER.debug("Payload: {}", professorDTO);
            LOGGER.debug("Professor Existente: {}", professorExistente);

            professorExistente.setNomeProfessor(professorDTO.getNomeProfessor());
            professorExistente.setSobrenomeProfessor(professorDTO.getSobrenomeProfessor());
            professorExistente.setTelefoneProfessor(professorDTO.getTelefoneProfessor());
            professorExistente.setEnderecoProfessor(professorDTO.getEnderecoProfessor());

            professorExistente = this.iProfessorRepository.save(professorExistente);
            return ProfessorDTO.of(professorExistente);

        }
        throw new IllegalArgumentException(String.format("Professor de ID %s não cadastrado para ser alterado", id));
    }

    public void deleteById(long id) {
        LOGGER.info("Executando delete para professor de ID: [{}]", id);
        this.iProfessorRepository.deleteById(id);
    }

}
