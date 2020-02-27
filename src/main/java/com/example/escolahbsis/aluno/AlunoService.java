package com.example.escolahbsis.aluno;

import com.example.escolahbsis.alunoTurma.AlunoTurma;
import com.example.escolahbsis.alunoTurma.AlunoTurmaDTO;
import com.example.escolahbsis.alunoTurma.AlunoTurmaService;
import com.example.escolahbsis.turma.TurmaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AlunoService.class);

    private final IAlunoRepository iAlunoRepository;
    private final TurmaService turmaService;
    private final AlunoTurmaService alunoTurmaService;
    @Autowired
    public AlunoService(IAlunoRepository iAlunoRepository, TurmaService turmaService, AlunoTurmaService alunoTurmaService) {
        this.iAlunoRepository = iAlunoRepository;
        this.turmaService = turmaService;
        this.alunoTurmaService = alunoTurmaService;
    }

    public AlunoDTO save(AlunoDTO alunoDTO){

        this.validacao(alunoDTO);
        LOGGER.info("Salvando Aluno");
        LOGGER.debug("Aluno: {}", alunoDTO);

        Aluno aluno = new Aluno();
        List<AlunoTurma> alunoTurmaList = new ArrayList<>();

        aluno.setId(alunoDTO.getId());
        aluno.setCodAluno(alunoDTO.getCodAluno());
        aluno.setEnderecoAluno(alunoDTO.getEnderecoAluno());
        aluno.setMatricula(alunoDTO.getMatricula());
        aluno.setNomeAluno(alunoDTO.getNomeAluno());
        aluno.setSobrenomeAluno(alunoDTO.getSobrenomeAluno());
        aluno.setResponsavel(alunoDTO.getResponsavel());
        aluno.setTelefoneAluno(alunoDTO.getTelefoneAluno());

        aluno = this.iAlunoRepository.save(aluno);
        aluno.setAlunoTurmaList(parseList(alunoDTO.getAlunoTurmaDTOS(),aluno));

        for (AlunoTurmaDTO alunoTurmaDTO : alunoDTO.getAlunoTurmaDTOS()){
            AlunoTurma alunoTurma = new AlunoTurma();

            LOGGER.info("Salvando Aluno na turma");

            alunoTurmaDTO.setAluno(aluno.getCodAluno());
            alunoTurmaService.save(alunoTurmaDTO);
            alunoTurma.setTurma(turmaService.findByCodTurmaEntidade(alunoTurmaDTO.getTurma()));

            alunoTurmaList.add(alunoTurma);
        }
        return AlunoDTO.of(aluno);
    }

    private void validacao(AlunoDTO alunoDTO){
        LOGGER.info("Validando Aluno");

        if (alunoDTO == null){
            throw new IllegalArgumentException("Aluno não deve ser nulo");
        }
        if (StringUtils.isEmpty(alunoDTO.getCodAluno())){
            throw new IllegalArgumentException("Código aluno não deve ser nulo");
        }
        if (alunoDTO.getCodAluno().length() != 4){
            throw new IllegalArgumentException("Código do aluno tem que ter 4 digítos");
        }
        if (StringUtils.isEmpty(alunoDTO.getEnderecoAluno())){
            throw new IllegalArgumentException("endereço do aluno não deve ser nulo");
        }
        if (StringUtils.isEmpty(alunoDTO.getMatricula())){
            throw new IllegalArgumentException("Matricula do aluno não deve ser nulo");
        }
        if (StringUtils.isEmpty(alunoDTO.getNomeAluno())){
            throw new IllegalArgumentException("Nome do aluno não deve ser nulo");
        }
        if (StringUtils.isEmpty(alunoDTO.getSobrenomeAluno())){
            throw new IllegalArgumentException("Sobrenome do aluno não deve ser nulo");
        }
        if (StringUtils.isEmpty(alunoDTO.getResponsavel())){
            throw new IllegalArgumentException("Responsavel do aluno não deve ser nulo");
        }
        if (StringUtils.isEmpty(alunoDTO.getTelefoneAluno())){
            throw new IllegalArgumentException("Telefone do aluno não deve ser nulo");
        }
    }

    public AlunoDTO update(AlunoDTO alunoDTO, long id){
        Optional<Aluno> alunoOptional = this.iAlunoRepository.findById(id);
        if (alunoOptional.isPresent()){
            Aluno alunoExistente = alunoOptional.get();

            LOGGER.info("Atualizando aluno de id: [{}]", alunoExistente.getId());
            LOGGER.debug("Payload: {}", alunoDTO);
            LOGGER.debug("Usuario Existente: {}", alunoExistente);

            alunoExistente.setNomeAluno(alunoDTO.getNomeAluno());
            alunoExistente.setSobrenomeAluno(alunoDTO.getSobrenomeAluno());
            alunoExistente.setEnderecoAluno(alunoDTO.getEnderecoAluno());
            alunoExistente.setResponsavel(alunoDTO.getResponsavel());
            alunoExistente.setTelefoneAluno(alunoDTO.getTelefoneAluno());
            alunoExistente.setMatricula(alunoDTO.getMatricula());

            alunoExistente = this.iAlunoRepository.save(alunoExistente);

            return AlunoDTO.of(alunoExistente);
        }
        throw new IllegalArgumentException(String.format("Aluno com o ID %s não esta cadastrado para ser alterado",id));
    }

    public void deleta(long id){
        LOGGER.info("Recebendo delete para aluno de ID: [{}]", id);
        this.iAlunoRepository.deleteById(id);
    }

    public AlunoDTO findById(long id){
        Optional<Aluno> alunoOptional = this.iAlunoRepository.findById(id);
        if (alunoOptional.isPresent()){
            return AlunoDTO.of(alunoOptional.get());
        }
        throw new IllegalArgumentException(String.format("Aluno com ID %s não cadastrado",id));
    }
    public Aluno findByCodAluno(String codAluno){
        Optional<Aluno> alunoOptional = this.iAlunoRepository.findByCodAluno(codAluno);
        if (alunoOptional.isPresent()){
            return alunoOptional.get();
        }
        throw new IllegalArgumentException(String.format("Código Aluno %s não cadastrado",codAluno));
    }


    private List<AlunoTurma> parseList(List<AlunoTurmaDTO> alunoTurmaDTOS, Aluno aluno){
        List<AlunoTurma> alunoTurmas = new ArrayList<>();
        for (AlunoTurmaDTO alunoTurmaDTO : alunoTurmaDTOS){
            AlunoTurma alunoTurma = new AlunoTurma();
            alunoTurma.setAluno(aluno);
            alunoTurma.setTurma(turmaService.findByCodTurmaEntidade(alunoTurmaDTO.getTurma()));
            alunoTurmas.add(alunoTurma);
        }
        return alunoTurmas;
    }
    public List<Aluno> findAllAluno(){
        List<Aluno> alunos = new ArrayList<>();
        try {
            alunos = iAlunoRepository.findAll();
        }catch (Exception e){
            LOGGER.error(e.getMessage());
        }
        return alunos;
    }


}

