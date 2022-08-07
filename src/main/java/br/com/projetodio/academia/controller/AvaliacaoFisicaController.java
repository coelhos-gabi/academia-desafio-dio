package br.com.projetodio.academia.controller;

import br.com.projetodio.academia.entity.AvaliacaoFisica;
import br.com.projetodio.academia.entity.form.AvaliacaoFisicaForm;
import br.com.projetodio.academia.service.impl.AvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    @Autowired
    private AvaliacaoFisicaService service;

    @PostMapping
    public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaForm form) {
        return service.create(form);
    }

    @GetMapping
    public List<AvaliacaoFisica> getAll(){
        return service.getAll();
    }

}
