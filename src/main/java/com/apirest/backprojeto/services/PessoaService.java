package com.apirest.backprojeto.services;

import java.util.Optional;

import com.apirest.backprojeto.models.Pessoa;
import com.apirest.backprojeto.repositories.PessoaRepository;
import com.apirest.backprojeto.services.exception.DataIntegrityException;
import com.apirest.backprojeto.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repo;

    public Pessoa find(Integer id){
        Optional<Pessoa> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + id + ", Tipo: " + Pessoa.class.getName())); 

    }

    public Pessoa insert(Pessoa obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Pessoa update(Pessoa obj){
        find(obj.getId());

        return repo.save(obj);
    }
    
    public void delete(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        } 
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possivel excluir uma Categoria que possui Produtos"); 
        }
    }

}