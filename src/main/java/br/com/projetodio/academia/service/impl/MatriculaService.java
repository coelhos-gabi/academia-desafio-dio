package br.com.projetodio.academia.service.impl;

import br.com.projetodio.academia.entity.Aluno;
import br.com.projetodio.academia.entity.Matricula;
import br.com.projetodio.academia.entity.form.MatriculaForm;
import br.com.projetodio.academia.repository.AlunoRepository;
import br.com.projetodio.academia.repository.MatriculaRepository;
import br.com.projetodio.academia.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService implements IMatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Matricula create(MatriculaForm form) {
        Matricula matricula = new Matricula();
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

        matricula.setAluno(aluno);

        return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula get(Long id) {
        return matriculaRepository.findById(id).get();
    }

    @Override
    public List<Matricula> getAll(String bairro) {

        if(bairro == null){
            return matriculaRepository.findAll();
        }else{
            return matriculaRepository.findAlunosMatriculadosBairro(bairro);
        }

    }

    @Override
    public void delete(Long id) {
        matriculaRepository.findById(id)
                .ifPresent(value -> matriculaRepository.delete(value));
    }
}
