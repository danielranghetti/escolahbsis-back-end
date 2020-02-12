package com.example.escolahbsis.disciplina;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaRest {
    private static final Logger LOGGER = LoggerFactory.getLogger(DisciplinaRest.class);

    private final DisciplinaService disciplinaService;

    @Autowired
    public DisciplinaRest(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }
    @PostMapping("/salva")
    public DisciplinaDTO save(@RequestBody DisciplinaDTO disciplinaDTO){
        LOGGER.info("Recebendo persistência para disciplina");
        LOGGER.debug("Payaload: {}", disciplinaDTO);

        return this.disciplinaService.save(disciplinaDTO);
    }
    @GetMapping("/consulta/{id}")
    public  DisciplinaDTO find(@PathVariable("id") long id){
        LOGGER.info("Recebendo consulta para disciplina de ID:{}",id);
        return this.disciplinaService.findById(id);
    }
    @PutMapping("/altera/{id}")
    public DisciplinaDTO update(@RequestBody DisciplinaDTO disciplinaDTO, @PathVariable("id") long id){
        LOGGER.info("Recebendo Update para disciplina de ID: {}", id);
        LOGGER.debug("Payload: {}", disciplinaDTO);
        return this.disciplinaService.update(disciplinaDTO,id);
    }
    @DeleteMapping("deleta/{id}")
    public void deleta(@PathVariable("id") long id){
        LOGGER.info("Recebendo delete para disciplida de ID: {}",id);
        this.disciplinaService.deleteById(id);
    }
}
