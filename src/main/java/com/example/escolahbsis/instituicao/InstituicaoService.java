package com.example.escolahbsis.instituicao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class InstituicaoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(InstituicaoService.class);
    private final IInstituicaoRepository iInstituicaoRepository;

    @Autowired
    public InstituicaoService(IInstituicaoRepository iInstituicaoRepository) {
        this.iInstituicaoRepository = iInstituicaoRepository;
    }

    public InstituicaoDTO save(InstituicaoDTO instituicaoDTO) {

        this.validation(instituicaoDTO);
        LOGGER.info("Salvando Instituiçao");
        LOGGER.debug("Instituição: {}", instituicaoDTO);

        Instituicao instituicao = new Instituicao();

        instituicao.setCodInstituicao(instituicaoDTO.getCodInstituicao());
        instituicao.setNomeInstituicao(instituicaoDTO.getNomeInstituicao());
        instituicao.setEnderecoInstituicao(instituicaoDTO.getEnderecoInstituicao());
        instituicao.setTelefoneInstituicao(instituicaoDTO.getTelefoneInstituicao());

        instituicao = this.iInstituicaoRepository.save(instituicao);
        return InstituicaoDTO.of(instituicao);
    }

    public void validation(InstituicaoDTO instituicaoDTO) {
        LOGGER.info("Validando Instituição");

        if (StringUtils.isEmpty(instituicaoDTO)) {
            throw new IllegalArgumentException("instituição não deve ser nula");
        }
        if (StringUtils.isEmpty(instituicaoDTO.getCodInstituicao())) {
            throw new IllegalArgumentException("Código não deve ser nulo");
        }
        if (instituicaoDTO.getCodInstituicao().length() != 10) {
            throw new IllegalArgumentException("Código d instituição deve conter dez digitos");
        }
        if (StringUtils.isEmpty(instituicaoDTO.getEnderecoInstituicao())) {
            throw new IllegalArgumentException("Endereço não deve ser nulo");
        }
        if (StringUtils.isEmpty(instituicaoDTO.getTelefoneInstituicao())) {
            throw new IllegalArgumentException("Telefone não deve ser nulo");
        }

    }

    public InstituicaoDTO findById(long id) {
        Optional<Instituicao> instituicaoOptional = this.iInstituicaoRepository.findById(id);

        if (instituicaoOptional.isPresent()) {
            return InstituicaoDTO.of(instituicaoOptional.get());
        }
        throw new IllegalArgumentException(String.format("Instituição de ID %s não existe", id));
    }

    public InstituicaoDTO updat(InstituicaoDTO instituicaoDTO, long id) {
        this.validation(instituicaoDTO);
        Optional<Instituicao> instituicaoExistenteOptional = this.iInstituicaoRepository.findById(id);

        if (instituicaoExistenteOptional.isPresent()) {
            Instituicao instituicaoExistente = instituicaoExistenteOptional.get();

            LOGGER.info("Atualizando instituição... id: [{}]", instituicaoExistente.getId());
            LOGGER.debug("Payload: {}", instituicaoDTO);
            LOGGER.debug("Categoria Existente: {}", instituicaoExistente);

            instituicaoExistente.setNomeInstituicao(instituicaoDTO.getNomeInstituicao());
            instituicaoExistente.setEnderecoInstituicao(instituicaoDTO.getEnderecoInstituicao());
            instituicaoExistente.setCodInstituicao(instituicaoDTO.getCodInstituicao());
            instituicaoExistente.setTelefoneInstituicao(instituicaoDTO.getTelefoneInstituicao());

            instituicaoExistente = this.iInstituicaoRepository.save(instituicaoExistente);
            return InstituicaoDTO.of(instituicaoExistente);
        }

        throw new IllegalArgumentException(String.format("Instituiçao de ID %s não existe", id));
    }

    public void delete(long id) {
        LOGGER.info("Executando Delete para instituição de ID: [{}]", id);
        this.iInstituicaoRepository.deleteById(id);
    }

    public Instituicao findByCodIstituicao(String codInstituicao) {
        Optional<Instituicao> instituicaoOptional = this.iInstituicaoRepository.findByCodInstituicao(codInstituicao);
        if (instituicaoOptional.isPresent()) {
            return instituicaoOptional.get();
        }
        throw new IllegalArgumentException("Código da Instituição não cadatrado");
    }

    public List<Instituicao> findAll() {
        List<Instituicao> Instituicaos = new ArrayList<>();
        try {
            Instituicaos = iInstituicaoRepository.findAll();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return Instituicaos;
    }

}
