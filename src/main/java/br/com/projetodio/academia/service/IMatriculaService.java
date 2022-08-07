package br.com.projetodio.academia.service;


import br.com.projetodio.academia.entity.Matricula;
import br.com.projetodio.academia.entity.form.MatriculaForm;

import java.util.List;

public interface IMatriculaService {

    Matricula create(MatriculaForm form);
    Matricula get(Long id);
    List<Matricula> getAll(String bairro);
    void delete(Long id);

}
