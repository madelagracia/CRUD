package com.application.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.application.crud.model.CursoModel;
import com.application.crud.repository.CursoRepository;


@RestController
@RequestMapping("api/curso")
public class CursoController {

    @Autowired
    private final CursoRepository repository;
    
    public CursoController(CursoRepository repository) {
        this.repository = repository;
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CursoModel> update(Long id, CursoModel curso) {
        return repository.findById(id)
                .map(record -> {
                    record.setDescricao(curso.getDescricao());
                    record.setEmenta(curso.getEmenta());
                    CursoModel updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/findAll")
    public List<CursoModel> findAll() {
        return repository.findAll();
    }

    @PostMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Long id) {
        repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/findById/{id}")
    public ResponseEntity<CursoModel> findById(Long id) {
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public CursoModel create(CursoModel curso) {
        return repository.save(curso);
    }

}
