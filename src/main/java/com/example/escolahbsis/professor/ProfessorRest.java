package com.example.escolahbsis.professor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/professor")
public class ProfessorRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProfessorRest.class);

  private final ProfessorService professorService;

  @Autowired
    public ProfessorRest(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping("/salva")
    public ProfessorDTO save(@RequestBody ProfessorDTO professorDTO){
        LOGGER.info("Recebendo persistência de professor");
        LOGGER.debug("Payaload: {}", professorDTO);
        return this.professorService.save(professorDTO);
    }
    @GetMapping("/consulta/{id}")
    public ProfessorDTO find(@PathVariable("id") long id){
      LOGGER.info("Recebendo consulta para professor de ID: {}",id);
      return this.professorService.findById(id);
    }
    @PutMapping("/atualiza/{id}")
    public ProfessorDTO update(@PathVariable("id") long id, @RequestBody ProfessorDTO professorDTO){
        LOGGER.info("Recebendo Update para professor de ID: {}", id);
        LOGGER.debug("Payload: {}", professorDTO);
        return this.professorService.update(professorDTO,id);
    }
    @DeleteMapping("/deleta/{id}")
    public void delete(long id){
      LOGGER.info("Recebendo delete para professor de ID:{}",id);
      this.professorService.deleteById(id);
    }
}
