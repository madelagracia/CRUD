package com.application.crud.model;

import javax.persistence.*;

@Entity
public class CursoModel {

    @Id
    @GeneratedValue
    @Column(name = "curso_id")
    private Long id;

    private String descricao;

    private String ementa;

    public CursoModel(Long id, String descricao, String ementa) {
        this.id = id;
        this.descricao = descricao;
        this.ementa = ementa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    

 
}
