package com.apirest.backprojeto.resources;

import com.apirest.backprojeto.models.Projeto;
import com.apirest.backprojeto.services.ProjetoService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/projetos")
public class ProjetoResource {
    
    @Autowired    
    private ProjetoService service;

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id ) {
    
        Projeto obj = service.searchForId(id);

        return ResponseEntity.ok().body(obj);

    }

}