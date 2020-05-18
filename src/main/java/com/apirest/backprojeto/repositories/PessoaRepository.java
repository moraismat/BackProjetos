package com.apirest.backprojeto.repositories;

import com.apirest.backprojeto.models.Pessoa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

} 