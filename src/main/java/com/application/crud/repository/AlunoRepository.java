package com.application.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.crud.model.AlunoModel;




@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, Long> {

    
}
