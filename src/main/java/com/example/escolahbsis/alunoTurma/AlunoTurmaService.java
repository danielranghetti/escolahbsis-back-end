package com.example.escolahbsis.alunoTurma;

import com.example.escolahbsis.aluno.AlunoConexao;
import com.example.escolahbsis.turma.TurmaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoTurmaService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AlunoTurmaService.class);

    private final IAlunoTurmaRepository iAlunoTurmaRepository;
    private final TurmaService turmaService;
    private final AlunoConexao alunoConexao;

    @Autowired
    public AlunoTurmaService(IAlunoTurmaRepository iAlunoTurmaRepository, TurmaService turmaService, AlunoConexao alunoConexao) {
        this.iAlunoTurmaRepository = iAlunoTurmaRepository;
        this.turmaService = turmaService;
        this.alunoConexao = alunoConexao;

    }

    public AlunoTurmaDTO save(AlunoTurmaDTO alunoTurmaDTO) {
        AlunoTurma alunoTurma = new AlunoTurma();
        alunoTurma.setId(alunoTurmaDTO.getId());
        alunoTurma.setTurma(turmaService.findByCodTurmaEntidade(alunoTurmaDTO.getTurma()));
        alunoTurma.setAluno(alunoConexao.findByCodAlunoEntidade(alunoTurmaDTO.getAluno()));

        alunoTurma = this.iAlunoTurmaRepository.save(alunoTurma);
        return AlunoTurmaDTO.of(alunoTurma);
    }
}
