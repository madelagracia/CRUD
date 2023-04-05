package com.application.crud.model;

import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MatriculaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "matricula_id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="curso_id")
    private CursoModel curso;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="aluno_id")
    private AlunoModel aluno;

  
    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }



    public CursoModel getCurso() {
        return curso;
    }



    public void setCurso(CursoModel curso) {
        this.curso = curso;
    }



    public AlunoModel getAluno() {
        return aluno;
    }



    public void setAluno(AlunoModel aluno) {
        this.aluno = aluno;
    }




}
