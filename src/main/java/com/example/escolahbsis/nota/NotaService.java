package com.example.escolahbsis.nota;


import com.example.escolahbsis.aluno.AlunoService;
import com.example.escolahbsis.disciplina.DisciplinaService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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
        this.validacao(notaDTO);
        LOGGER.info("Salvando nota");
        LOGGER.debug("Categoria: {}", notaDTO);

        Nota nota = new Nota();

        nota.setId(notaDTO.getId());
        nota.setCodNota(notaDTO.getCodNota());
        nota.setAluno(alunoService.findByCodAluno(notaDTO.getAluno()));
        nota.setDisciplina(disciplinaService.findByCodDisciplinaEntidade(notaDTO.getDisciplina()));
        nota.setNotaPrimeira(notaDTO.getNotaPrimeira());
        nota.setNotaSegunda(notaDTO.getNotaSegunda());
        nota.setPeriodo(notaDTO.getPeriodo());
        nota.setMedia((notaDTO.getNotaPrimeira() + notaDTO.getNotaSegunda()) / 2);

        nota = this.iNotaRepository.save(nota);
        return NotaDTO.of(nota);
    }

    public void validacao(NotaDTO notaDTO) {
        if (notaDTO == null) {
            throw new IllegalArgumentException("Nota não pode ser nula");
        }
        if (StringUtils.isEmpty(notaDTO.getCodNota())) {
            throw new IllegalArgumentException("Código da nota deve ser informado");
        }
        if (notaDTO.getCodNota().length() != 4) {
            throw new IllegalArgumentException("Código deve conter 4 digitos");
        }
        if (StringUtils.isEmpty(notaDTO.getAluno())) {
            throw new IllegalArgumentException("Código do aluno deve ser informado");
        }
        if (StringUtils.isEmpty(notaDTO.getDisciplina())) {
            throw new IllegalArgumentException("Código da disciplina deve ser informado");
        }
        if (StringUtils.isEmpty(notaDTO.getPeriodo())) {
            throw new IllegalArgumentException("O perido da nota deve ser informada");
        }
        if (StringUtils.isEmpty(notaDTO.getNotaPrimeira())) {
            throw new IllegalArgumentException("Nota deve ser informada");
        }
        if (notaDTO.getNotaPrimeira() < 0 || notaDTO.getNotaPrimeira() > 10) {
            throw new IllegalArgumentException("Nota não deve ser menor que 0 ou maior que 10");
        }
        if (StringUtils.isEmpty(notaDTO.getNotaSegunda())) {
            throw new IllegalArgumentException("Nota deve ser informada");
        }
        if (notaDTO.getNotaSegunda() < 0 || notaDTO.getNotaSegunda() > 10) {
            throw new IllegalArgumentException("Nota não deve ser menor que 0 ou maior que 10");
        }
        if (StringUtils.isEmpty(notaDTO.getMedia())) {
            throw new IllegalArgumentException("Média não deve ser nula");
        }
         notaDTO.setMedia((notaDTO.getNotaPrimeira() + notaDTO.getNotaSegunda()) / 2);

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
            notaExistente.setNotaPrimeira(notaDTO.getNotaPrimeira());
            notaExistente.setNotaSegunda(notaDTO.getNotaSegunda());


            notaExistente = iNotaRepository.save(notaExistente);
            return NotaDTO.of(notaExistente);
        }
        throw new IllegalArgumentException(String.format("Nora de ID %s não existe para ser alterada", id));
    }

    public NotaDTO findById(long id) {
        Optional<Nota> notaOptional = this.iNotaRepository.findById(id);
        if (notaOptional.isPresent()) {
            return NotaDTO.of(notaOptional.get());
        }
        throw new IllegalArgumentException(String.format("nota com ID:{[]} não existe", id));
    }

    public Nota findByPeriodo(String periodo) {
        Optional<Nota> notaOptional = this.iNotaRepository.findByPeriodo(periodo);
        if (notaOptional.isPresent()) {
            return notaOptional.get();
        }
        throw new IllegalArgumentException(String.format("Nota de periodo %s não cadatrada", periodo));
    }

    public void delete(long id) {
        LOGGER.info("Executando delete para nota de ID:{}", id);
        this.iNotaRepository.deleteById(id);
    }

    public List<Nota> consulta() {
        List<Nota> notaOptional = this.iNotaRepository.findAll();
        try {
            notaOptional = iNotaRepository.findAll();
        } catch (Exception e) {
            LOGGER.error("erro ao lista nota", notaOptional);
        }
        return notaOptional;
    }

    public List<NotaDTO> notaDTOS() {
        List<NotaDTO> notaDTOList = new ArrayList<>();

        for (Nota nota : iNotaRepository.findAll()) {
            notaDTOList.add(NotaDTO.of(nota));
        }

        return notaDTOList;
    }



    public String exportaReport(String format, String codAluno, String periodo) throws FileNotFoundException, JRException {
        LOGGER.info(String.format("Gerando Boletim do aluno de código %s", codAluno));
        String path = "C:\\Users\\daniel.ranghetti\\Desktop\\exportJaper";
        List<Nota> notaList = iNotaRepository.findByAlunoAndPeriodo(alunoService.findByCodAluno(codAluno), periodo);
        File file = ResourceUtils.getFile("classpath:boletim.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(notaList);
        Map<String, Object> stringOptionalMap = new HashMap<>();
        stringOptionalMap.put("createdBy", "Nota");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, stringOptionalMap, dataSource);
        if (format.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\Boletim" + codAluno + ".html");
        }
        if (format.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\Boletim" + codAluno + ".pdf");
        }
        return "Gerado em " + path;

    }
}





