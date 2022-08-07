package br.com.projetodio.academia.entity.form;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class AlunoUpdateForm {

    private String nome;

    private String bairro;

    private LocalDate dataDeNascimento;
}

