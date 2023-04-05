package com.application.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.application.crud.model.MatriculaModel;
import com.application.crud.repository.MatriculaRepository;

@RestController
@RequestMapping("api/matricula")
public class MatriculaController {

    @Autowired
    private final MatriculaRepository repository;

    public MatriculaController(MatriculaRepository repository) {
        this.repository = repository;
    }

    @DeleteMapping("/delete/{Id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Long id) {
        repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public MatriculaModel create(MatriculaModel matricula) {
        return repository.save(matricula);
    }

    @GetMapping("/findAll")
    public List<MatriculaModel> findAll() {
        return repository.findAll();
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<MatriculaModel> findById(@PathVariable("id") Long id) {
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

}
