package br.com.projetodio.academia.service;

import br.com.projetodio.academia.entity.Aluno;
import br.com.projetodio.academia.entity.AvaliacaoFisica;
import br.com.projetodio.academia.entity.form.AlunoForm;
import br.com.projetodio.academia.entity.form.AlunoUpdateForm;

import java.util.List;

public interface IAlunoService {

    Aluno create(AlunoForm form);
    Aluno get(Long id);

    List<Aluno> getAll(String dataDeNascimento);

    Aluno update(Long id, AlunoUpdateForm formUpdate);

    void delete(Long id);

    List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id);


}

