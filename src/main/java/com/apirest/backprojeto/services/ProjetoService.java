package com.apirest.backprojeto.services;

import java.util.Optional;

import com.apirest.backprojeto.models.Projeto;
import com.apirest.backprojeto.repositories.ProjetoRepository;

import com.apirest.backprojeto.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository repo;

    public Projeto find(Integer id){
        Optional<Projeto> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + id + ", Tipo: " + Projeto.class.getName())); 

    }

    public Projeto insert(Projeto obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Projeto update(Projeto obj){
        find(obj.getId());

        return repo.save(obj);
    }

}
