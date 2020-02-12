package com.example.escolahbsis.nota;

import com.example.escolahbsis.aluno.AlunoService;
import com.example.escolahbsis.disciplina.DisciplinaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotaService.class);

    private final INotaRepository iNotaRepository;
    private final AlunoService alunoService;
    private final DisciplinaService disciplinaService;

    @Autowired
    public NotaService(INotaRepository iNotaRepository, AlunoService alunoService, DisciplinaService disciplinaService) {
        this.iNotaRepository = iNotaRepository;
        this.alunoService = alunoService;
        this.disciplinaService = disciplinaService;
    }

    public NotaDTO save(NotaDTO notaDTO) {
        LOGGER.info("Salvando nota");
        LOGGER.debug("Categoria: {}", notaDTO);

        Nota nota = new Nota();

        nota.setId(notaDTO.getId());
        nota.setCodNota(notaDTO.getCodNota());
        nota.setAluno(alunoService.findByCodAluno(notaDTO.getAluno()));
        nota.setDisciplina(disciplinaService.findByCodDisciplinaEntidade(notaDTO.getDisciplina()));
        nota.setNota(notaDTO.getNota());
        nota.setPeriodo(notaDTO.getPeriodo());

        nota = this.iNotaRepository.save(nota);
        return NotaDTO.of(nota);
    }

    public NotaDTO update(long id, NotaDTO notaDTO) {
        Optional<Nota> notaOptional = this.iNotaRepository.findById(id);
        if (notaOptional.isPresent()) {
            Nota notaExistente = notaOptional.get();

            LOGGER.info("Atualizando categoria... id: [{}]", notaExistente.getId());
            LOGGER.debug("Payload: {}", notaDTO);
            LOGGER.debug("Categoria Existente: {}", notaExistente);

            notaExistente.setAluno(alunoService.findByCodAluno(notaDTO.getAluno()));
            notaExistente.setDisciplina(disciplinaService.findByCodDisciplinaEntidade(notaDTO.getDisciplina()));
            notaExistente.setPeriodo(notaDTO.getPeriodo());
            notaExistente.setNota(notaDTO.getNota());

            notaExistente = iNotaRepository.save(notaExistente);
            return NotaDTO.of(notaExistente);
        }
        throw new IllegalArgumentException(String.format("Nora de ID %s não existe para ser alterada", id));
    }

    public NotaDTO findById(long id){
        Optional<Nota> notaOptional = this.iNotaRepository.findById(id);
        if (notaOptional.isPresent()){
            return NotaDTO.of(notaOptional.get());
        }
        throw new IllegalArgumentException(String.format("nota com ID:{[]} não existe",id));
    }
    public Nota findByCodNotaEntidade(String codNota){
        Optional<Nota> notaOptional = this.iNotaRepository.findByCodNota(codNota);
        if (notaOptional.isPresent()){
            return notaOptional.get();
        }
        throw new IllegalArgumentException(String.format("Nota de códido ID:{} não cadatrada",codNota));
    }
    public void delete(long id){
        LOGGER.info("Executando delete para nota de ID:{}",id);
        this.iNotaRepository.deleteById(id);
    }
}
