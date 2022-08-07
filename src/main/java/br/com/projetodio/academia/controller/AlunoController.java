package br.com.projetodio.academia.controller;

import br.com.projetodio.academia.entity.Aluno;
import br.com.projetodio.academia.entity.AvaliacaoFisica;
import br.com.projetodio.academia.entity.form.AlunoForm;
import br.com.projetodio.academia.service.impl.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @PostMapping
    public Aluno create(@Valid @RequestBody AlunoForm form) {
        return service.create(form);
    }

    @GetMapping("/avaliacoes/{id}")
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id) {
        return service.getAllAvaliacaoFisicaId(id);
    }

    @GetMapping
    public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false)
                              String dataDeNacimento) {
        return service.getAll(dataDeNacimento);
    }
}
