package com.example.escolahbsis.disciplina;

import com.example.escolahbsis.professor.ProfessorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class DisciplinaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DisciplinaService.class);

    private final IDisciplinaRepository iDisciplinaRepository;
    private final ProfessorService professorService;

    @Autowired
    public DisciplinaService(IDisciplinaRepository iDisciplinaRepository, ProfessorService professorService) {
        this.iDisciplinaRepository = iDisciplinaRepository;
        this.professorService = professorService;
    }

    public void validacao(DisciplinaDTO disciplinaDTO) {
        LOGGER.info("Validando Disciplina");

        if (disciplinaDTO == null) {
            throw new IllegalArgumentException("Disciplina não deve ser nula");
        }
        if (StringUtils.isEmpty(disciplinaDTO.getNomeDisciplina())) {
            throw new IllegalArgumentException("Nome disciplina não deve ser nulo");
        }
        if (StringUtils.isEmpty(disciplinaDTO.getProfessor())) {
            throw new IllegalArgumentException("Professor da disciplina não deve ser nulo");
        }
        if (StringUtils.isEmpty(disciplinaDTO.getCodDisciplina())) {
            throw new IllegalArgumentException("Código da disciplina não mdeve ser nulo");
        }
        if (disciplinaDTO.getCodDisciplina().length() != 10) {
            throw new IllegalArgumentException("código da disciplina tem que conte dez digitos");
        }
    }

    public DisciplinaDTO save(DisciplinaDTO disciplinaDTO) {
        this.validacao(disciplinaDTO);
        LOGGER.info("Salvando disciplina");
        LOGGER.debug("Professor: {}", disciplinaDTO);
        Disciplina disciplina = new Disciplina();

        disciplina.setId(disciplinaDTO.getId());
        disciplina.setCodDisciplina(disciplinaDTO.getCodDisciplina());
        disciplina.setNomeDisciplina(disciplinaDTO.getNomeDisciplina());
        disciplina.setProfessor(professorService.findByCodProfessorEntidade(disciplinaDTO.getProfessor()));

        disciplina = this.iDisciplinaRepository.save(disciplina);
        return DisciplinaDTO.of(disciplina);
    }

    public DisciplinaDTO findById(long id) {
        Optional<Disciplina> disciplinaOptional = this.iDisciplinaRepository.findById(id);
        if (disciplinaOptional.isPresent()) {
            return DisciplinaDTO.of(disciplinaOptional.get());
        }
        throw new IllegalArgumentException(String.format("Disciplina de ID %s não existe", id));
    }

    public Disciplina findByCodDisciplinaEntidade(String codDisciplina) {
        Optional<Disciplina> disciplinaOptional = this.iDisciplinaRepository.findByCodDisciplina(codDisciplina);
        if (disciplinaOptional.isPresent()) {
            return disciplinaOptional.get();
        }
        throw new IllegalArgumentException(String.format("Código de disciplina %s não cadrastado", codDisciplina));
    }

    public DisciplinaDTO update(DisciplinaDTO disciplinaDTO, long id) {
        Optional<Disciplina> disciplinaOptional = this.iDisciplinaRepository.findById(id);
        if (disciplinaOptional.isPresent()) {
            Disciplina disciplinaExistente = disciplinaOptional.get();

            LOGGER.info("Atualizando categoria... id: [{}]", disciplinaExistente.getId());
            LOGGER.debug("Payload: {}", disciplinaDTO);
            LOGGER.debug("Categoria Existente: {}", disciplinaExistente);

            disciplinaExistente.setNomeDisciplina(disciplinaDTO.getNomeDisciplina());
            disciplinaExistente.setProfessor(professorService.findByCodProfessorEntidade(disciplinaDTO.getProfessor()));

            disciplinaExistente = iDisciplinaRepository.save(disciplinaExistente);
            return DisciplinaDTO.of(disciplinaExistente);
        }
        throw new IllegalArgumentException(String.format("disciplina de ID %s não está cadrastada", id));
    }

    public void deleteById(long id) {
        LOGGER.info("recebendo delete para disciplina de ID:{}", id);
        this.iDisciplinaRepository.deleteById(id);
    }

}
