package com.bsilva.cinelist.model;

public class Filme {

    private Long id;
    private String titulo;
    private String genero;
    private Integer anoLancamento;
    private String diretor;
    private Integer nota;

    // Construtor vazio (necessário para o Spring/Thymeleaf)
    public Filme() {
    }

    // Construtor completo
    public Filme(Long id, String titulo, String genero, Integer anoLancamento, String diretor, Integer nota) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
        this.diretor = diretor;
        this.nota = nota;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }
}
