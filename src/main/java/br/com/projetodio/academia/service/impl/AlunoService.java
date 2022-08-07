package br.com.projetodio.academia.service.impl;

import br.com.projetodio.academia.entity.Aluno;
import br.com.projetodio.academia.entity.AvaliacaoFisica;
import br.com.projetodio.academia.entity.form.AlunoForm;
import br.com.projetodio.academia.entity.form.AlunoUpdateForm;
import br.com.projetodio.academia.infra.utils.JavaTimeUtils;
import br.com.projetodio.academia.repository.AlunoRepository;
import br.com.projetodio.academia.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlunoService implements IAlunoService {

    @Autowired
    private AlunoRepository repository;

    @Override
    public Aluno create(AlunoForm form) {

        return repository.save(Aluno.builder()
                .nome(form.getNome())
                .cpf(form.getCpf())
                .bairro(form.getBairro())
                .dataDeNascimento(form.getDataDeNascimento())
                .build());
    }

    @Override
    public Aluno get(Long id) {
        return null;
    }

    @Override
    public List<Aluno> getAll(String dataDeNascimento) {

        if(dataDeNascimento == null) {
            return repository.findAll();
        } else {
            LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
            return repository.findByDataDeNascimento(localDate);
        }

    }

    @Override
    public Aluno update(Long id, AlunoUpdateForm formUpdate) {
        var aluno = repository.findById(id).get();
        aluno.setNome(formUpdate.getNome());
        aluno.setBairro(formUpdate.getBairro());
        aluno.setDataDeNascimento(formUpdate.getDataDeNascimento());
        return aluno;
    }

    @Override
    public void delete(Long id) {
        repository.findById(id)
                .ifPresent(value -> repository.delete(value));
    }

    @Override
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {

        Aluno aluno = repository.findById(id).get();

        return aluno.getAvaliacoes();

    }

}

