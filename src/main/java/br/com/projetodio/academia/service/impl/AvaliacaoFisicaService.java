package br.com.projetodio.academia.service.impl;


import br.com.projetodio.academia.entity.Aluno;
import br.com.projetodio.academia.entity.AvaliacaoFisica;
import br.com.projetodio.academia.entity.form.AvaliacaoFisicaForm;
import br.com.projetodio.academia.entity.form.AvaliacaoFisicaUpdateForm;
import br.com.projetodio.academia.repository.AlunoRepository;
import br.com.projetodio.academia.repository.AvaliacaoFisicaRepository;
import br.com.projetodio.academia.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoFisicaService implements IAvaliacaoFisicaService {

    @Autowired
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setPeso(form.getPeso());
        avaliacaoFisica.setAltura(form.getAltura());

        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    @Override
    public AvaliacaoFisica get(Long id) {
        return avaliacaoFisicaRepository.getById(id);
    }

    @Override
    public List<AvaliacaoFisica> getAll() {

        return avaliacaoFisicaRepository.findAll();
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
        var avaliacao = avaliacaoFisicaRepository.getById(id);
        avaliacao.setPeso(formUpdate.getPeso());
        avaliacao.setAltura(formUpdate.getAltura());
        return avaliacao;
    }

    @Override
    public void delete(Long id) {
        var avaliacao = avaliacaoFisicaRepository.getById(id);
        avaliacaoFisicaRepository.delete(avaliacao);
    }
}
