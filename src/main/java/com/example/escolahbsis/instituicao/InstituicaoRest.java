package com.example.escolahbsis.instituicao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/instituicao")
public class InstituicaoRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(InstituicaoRest.class);
    private final InstituicaoService instituicaoService;

    @Autowired
    public InstituicaoRest(InstituicaoService instituicaoService) {
        this.instituicaoService = instituicaoService;
    }

    @PostMapping
    public InstituicaoDTO save(@RequestBody InstituicaoDTO instituicaoDTO) {
        LOGGER.info("Recebendo solicitação de persistência de instituição...");
        LOGGER.debug("Payaload: {}", instituicaoDTO);

        return this.instituicaoService.save(instituicaoDTO);
    }

    @GetMapping("/{id}")
    public InstituicaoDTO findBy(@PathVariable("id") long id) {
        LOGGER.info("Recebendo Pesquisa por ID... id: {}", id);
        return this.instituicaoService.findById(id);
    }

    @PutMapping("/altera/{id}")
    public InstituicaoDTO upadet(@PathVariable("id") long id, @RequestBody InstituicaoDTO instituicaoDTO) {
        return this.instituicaoService.updat(instituicaoDTO, id);
    }

    @DeleteMapping("/deleta/{id}")
    public void deleta(@PathVariable("id") long id) {
        this.instituicaoService.delete(id);
    }

    @GetMapping("/consulta")
    public List<Instituicao> findall() {
        LOGGER.info("Recebendo consulta para turma");
        return this.instituicaoService.findAll();
    }
}
