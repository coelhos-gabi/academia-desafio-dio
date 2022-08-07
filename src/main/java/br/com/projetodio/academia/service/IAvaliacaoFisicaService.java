package br.com.projetodio.academia.service;

import br.com.projetodio.academia.entity.AvaliacaoFisica;
import br.com.projetodio.academia.entity.form.AvaliacaoFisicaForm;
import br.com.projetodio.academia.entity.form.AvaliacaoFisicaUpdateForm;

import java.util.List;

public interface IAvaliacaoFisicaService {

    AvaliacaoFisica create(AvaliacaoFisicaForm form);
    AvaliacaoFisica get(Long id);
    List<AvaliacaoFisica> getAll();
    AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate);
    void delete(Long id);
}

