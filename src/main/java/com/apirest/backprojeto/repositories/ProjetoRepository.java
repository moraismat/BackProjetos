package com.apirest.backprojeto.repositories;

import com.apirest.backprojeto.models.Projeto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Integer>{

} 