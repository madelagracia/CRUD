package com.application.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.application.crud.model.AlunoModel;
import com.application.crud.repository.AlunoRepository;


@RestController
@RequestMapping(value = "/api/aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    public AlunoController(AlunoRepository repository) {
        this.repository = repository;
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") Long id, @RequestBody AlunoModel aluno) {
        repository.findById(id)
                .map(record -> {
                    record.setNome(aluno.getNome());
                    AlunoModel updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/findAll")
    public List<AlunoModel> findAll() {
        return repository.findAll();
    }

    @PostMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<AlunoModel> findById(@PathVariable("id") Long id) {
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public AlunoModel create(@RequestBody AlunoModel aluno) {
        return repository.save(aluno);
    }

}
