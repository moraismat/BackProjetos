package com.apirest.backprojeto.services;

import java.util.Optional;

import com.apirest.backprojeto.models.Projeto;
import com.apirest.backprojeto.repositories.ProjetoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository repo;

    public Projeto searchForId(Integer id){
        Optional<Projeto> obj = repo.findById(id);

        return obj.orElse(null);
    }
} 
