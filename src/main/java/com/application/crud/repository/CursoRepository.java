package com.application.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.crud.model.CursoModel;


@Repository
public interface CursoRepository  extends JpaRepository<CursoModel, Long> {
    
}
