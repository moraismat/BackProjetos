package com.apirest.backprojeto.services;

import java.util.List;
import java.util.Optional;

import com.apirest.backprojeto.services.exception.DataIntegrityException;
import com.apirest.backprojeto.services.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.apirest.backprojeto.models.Projeto;
import com.apirest.backprojeto.repositories.ProjetoRepository;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository repo;

    public Projeto find(Integer id){
        Optional<Projeto> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + id + ", Tipo: " + Projeto.class.getName())); 

    }
    
    public List<Projeto> findAll(){    
        return repo.findAll();
    }


    public Projeto insert(Projeto obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Projeto update(Projeto obj){
        find(obj.getId());

        return repo.save(obj);
    }
    
    public void delete(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        } 
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possivel excluir uma Projeto que possui Pessoas Envolvidas"); 
        }
    }
    public Page<Projeto> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
    }
    
    public List<Projeto> search(String titulo) {
		/*PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Projeto> projetos = repo.findAllById(ids);*/
		return repo.findByTitulo(titulo);	
	}

}
