package com.example.escolahbsis.aluno;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/aluno")
public class AlunoRest {

    private final static Logger LOGGER = LoggerFactory.getLogger(AlunoRest.class);
    private final AlunoService alunoService;

    @Autowired
    public AlunoRest(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("/consulta/{id}")
    public AlunoDTO find(@PathVariable("id") long id) {
        LOGGER.info("Recebendo consulta para aluno de ID: {}", id);
        return this.alunoService.findById(id);
    }

    @GetMapping("/todos")
    public List<Aluno> findAll() {
        LOGGER.info("Recebendo consulta para Lista de alunos");
        return alunoService.findAllAluno();
    }

    @PostMapping
    public AlunoDTO save(@RequestBody AlunoDTO alunoDTO) {
        LOGGER.info("Recebendo solicitação de persistência de aluno...");
        LOGGER.debug("Payaload: {}", alunoDTO);
        return this.alunoService.save(alunoDTO);
    }

    @DeleteMapping("/deleta/{id}")
    public void delete(@PathVariable("id") long id) {
        LOGGER.info("Recebendo delete para Aluno de ID: {}", id);
        this.alunoService.deleta(id);
    }

    @PutMapping("/alterando/{id}")
    public AlunoDTO update(@PathVariable("id") long id, @RequestBody AlunoDTO alunoDTO) {
        LOGGER.info("Recebendo Update para aluno de ID: {}", id);
        LOGGER.debug("Payload: {}", alunoDTO);
        return this.alunoService.update(alunoDTO, id);

    }

}
