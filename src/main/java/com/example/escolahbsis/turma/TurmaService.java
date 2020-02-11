package com.example.escolahbsis.turma;

import com.example.escolahbsis.instituicao.InstituicaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class TurmaService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TurmaService.class);

    private final IturmaReposytory iturmaReposytory;
    private final InstituicaoService instituicaoService;

    @Autowired
    public TurmaService(IturmaReposytory iturmaReposytory, InstituicaoService instituicaoService) {
        this.iturmaReposytory = iturmaReposytory;
        this.instituicaoService = instituicaoService;
    }

    public TurmaDTO save(TurmaDTO turmaDTO) {
        this.validacao(turmaDTO);
        LOGGER.info("Salvando turma");
        LOGGER.debug("Turma: {}", turmaDTO);

        Turma turma = new Turma();

        turma.setId(turmaDTO.getId());
        turma.setCodTurma(turmaDTO.getCodTurma());
        turma.setPeriodoTurma(turmaDTO.getPeriodoTurma());
        turma.setInstituicao(instituicaoService.findByCodIstituicao(turmaDTO.getInstituicao()));

        turma = this.iturmaReposytory.save(turma);
        return TurmaDTO.of(turma);

    }

    public void validacao(TurmaDTO turmaDTO) {
        LOGGER.info("Validando Turma");

        if (turmaDTO == null) {
            throw new IllegalArgumentException("Turma não deve ser nula");
        }
        if (StringUtils.isEmpty(turmaDTO.getCodTurma())) {
            throw new IllegalArgumentException("Código da turma não deve ser nulo");
        }
        if (StringUtils.isEmpty(turmaDTO.getPeriodoTurma())) {
            throw new IllegalArgumentException("Periodo da turma não deve ser nulo");
        }
        if (StringUtils.isEmpty(turmaDTO.getInstituicao())) {
            throw new IllegalArgumentException("Instituição não deve ser nulo");
        }
    }

    public TurmaDTO update(TurmaDTO turmaDTO, long id) {
        Optional<Turma> turmaOptional = this.iturmaReposytory.findById(id);
        if (turmaOptional.isPresent()) {
            Turma turmaExistente = turmaOptional.get();

            LOGGER.info("Atualizando turma de ID: [{}]", turmaExistente.getId());
            LOGGER.debug("Payload: {}", turmaDTO);
            LOGGER.debug("Categoria Existente: {}", turmaExistente);

            turmaExistente.setPeriodoTurma(turmaDTO.getPeriodoTurma());
            turmaExistente.setInstituicao(instituicaoService.findByCodIstituicao(turmaDTO.getInstituicao()));

            turmaExistente = this.iturmaReposytory.save(turmaExistente);
            return TurmaDTO.of(turmaExistente);
        }
        throw new IllegalArgumentException(String.format("ID %s não cadrastado para ser alterado", id));
    }

    public void delete(long id) {
        LOGGER.info("Executando delete para turma de ID: [{}]", id);
        this.iturmaReposytory.deleteById(id);
    }
    public TurmaDTO findById(Long id){
        Optional<Turma> turmaOptional = this.iturmaReposytory.findById(id);
        if (turmaOptional.isPresent()){
            return TurmaDTO.of(turmaOptional.get());
        }
        throw new IllegalArgumentException(String.format("ID %s de turma não existe",id));
    }
    public TurmaDTO findByCodTurma(String codTurma){
        Optional<Turma> turmaOptional = this.iturmaReposytory.findByCodTurma(codTurma);
        if (turmaOptional.isPresent()){
            return TurmaDTO.of(turmaOptional.get());
        }
        throw new IllegalArgumentException(String.format("Código  %s de turma não cadatrado",codTurma));
    }

}
