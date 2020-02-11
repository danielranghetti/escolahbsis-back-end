package com.example.escolahbsis.turma;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turma")
public class TurmaRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(TurmaRest.class);

    private final TurmaService turmaService;

    @Autowired
    public TurmaRest(TurmaService turmaService) {
        this.turmaService = turmaService;
    }
    @PostMapping("/salva")
    public TurmaDTO save(@RequestBody TurmaDTO turmaDTO) {
        LOGGER.info("Recebendo solicitação de persistência para turma...");
        LOGGER.debug("Payaload: {}", turmaDTO);

        return this.turmaService.save(turmaDTO);
    }
    @GetMapping("/{id}")
    public TurmaDTO find(@PathVariable("id") long id){
        LOGGER.info("Recebendo consulta para ID: {}",id);
        return this.turmaService.findById(id);
    }
    @PutMapping("/Altera/{id}")
    public TurmaDTO udpate(@PathVariable("id") long id, @RequestBody TurmaDTO turmaDTO){
        LOGGER.info("Recebendo atualização para turma de ID: {}" ,id);
        LOGGER.debug("Playload: {}" , turmaDTO);
        return this.turmaService.update(turmaDTO,id);
    }
    @DeleteMapping("/deleta/{id}")
    public void delete(@PathVariable("id") long id){
        LOGGER.info("recebendo delete para o ID: {}",id);
        this.turmaService.delete(id);
    }
}
