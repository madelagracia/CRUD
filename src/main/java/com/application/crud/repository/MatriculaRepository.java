package com.application.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.crud.model.MatriculaModel;


@Repository
public interface MatriculaRepository extends JpaRepository<MatriculaModel, Long>{}