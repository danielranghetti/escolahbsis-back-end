package com.example.escolahbsis.nota;

import net.sf.jasperreports.engine.JRException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@CrossOrigin("*")
@RestController
@RequestMapping("/nota")
public class NotaRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotaRest.class);

    private final NotaService notaService;

    @Autowired
    public NotaRest(NotaService notaService) {
        this.notaService = notaService;
    }

    @GetMapping("/consulta/{id}")
    public NotaDTO find(@PathVariable("id") long id) {
        LOGGER.info("Recebendo consulta para nota de ID:{}", id);
        return this.notaService.findById(id);
    }

    @PostMapping("/salva")
    public NotaDTO save(@RequestBody NotaDTO notaDTO) {
        LOGGER.info("Recebendo solicitação de prescistência para nota");
        LOGGER.debug("Payaload: {}", notaDTO);
        return this.notaService.save(notaDTO);
    }

    @PutMapping("/altera/{id}")
    public NotaDTO update(@PathVariable("id") long id, @RequestBody NotaDTO notaDTO) {
        LOGGER.info("Recebendo alteração para nota de ID:{}", id);
        return this.notaService.update(id, notaDTO);
    }

    @DeleteMapping("/deleta/{id}")
    public void delete(long id) {
        LOGGER.info("Recebendo delete para nota de ID:{}", id);
        this.notaService.delete(id);
    }

    @GetMapping("/report/{format}/{codAluno}")
    public String export(@PathVariable("format") String format, @PathVariable("codAluno") String codAluno) throws FileNotFoundException, JRException {
        LOGGER.info("Recebendo report");
        return notaService.exportaReport(format, codAluno);

    }

}
