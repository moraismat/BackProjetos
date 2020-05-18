package com.apirest.backprojeto.resources;

import java.util.ArrayList;
import java.util.List;

import com.apirest.backprojeto.models.Projeto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/projetos")
public class ProjetoResource {
    
    @RequestMapping(method=RequestMethod.GET)
    public List<Projeto> listar() {

        Projeto proj1 = new Projeto(1, "Projeto API", "Criando uma apirest no meu back-end", "Matheus Morais", "18/05/20", "Matheus");

        List<Projeto> lista = new ArrayList<>();
        lista.add(proj1);
        

        return lista;
    }
}