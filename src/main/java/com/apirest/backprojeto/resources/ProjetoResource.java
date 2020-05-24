package com.apirest.backprojeto.resources;

import java.net.URI;

import java.util.List;
import java.util.stream.Collectors;

import com.apirest.backprojeto.DTO.ProjetoDTO;
import com.apirest.backprojeto.DTO.ProjetoNewDTO;
import com.apirest.backprojeto.models.Pessoa;
import com.apirest.backprojeto.models.Projeto;
import com.apirest.backprojeto.resources.utils.URL;
import com.apirest.backprojeto.services.PessoaService;
import com.apirest.backprojeto.services.ProjetoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping(value="/api")
public class ProjetoResource {
    
    @Autowired    
    private ProjetoService projetoService;


    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Projeto> find(@PathVariable Integer id ) {
    
        Projeto obj = projetoService.find(id);

        return ResponseEntity.ok().body(obj);

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody ProjetoNewDTO objDTO){
        Projeto obj = projetoService.fromDTO(objDTO);

        obj = projetoService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Projeto obj, @PathVariable Integer id){
        obj.setId(id); 
        obj = projetoService.update(obj);

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id ) {
        projetoService.delete(id);

        return ResponseEntity.noContent().build();

    }
    
    @RequestMapping(value="/projetos",method=RequestMethod.GET)
    public ResponseEntity<List<ProjetoDTO>> findAll() {

        List<Projeto> list = projetoService.findAll();
        List<ProjetoDTO> listDTO = list.stream().map(obj -> new ProjetoDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDTO);

    } 

    @RequestMapping(value="/page", method=RequestMethod.GET)
    public ResponseEntity<Page<ProjetoDTO>> findPage(
           @RequestParam(value="page", defaultValue = "0") Integer page, 
           @RequestParam(value="linesPerPage", defaultValue = "24") Integer linesPerPage,   
           @RequestParam(value="orderBy", defaultValue = "titulo") String orderBy, 
           @RequestParam(value="direction", defaultValue = "ASC") String direction    ) {

        Page<Projeto> list = projetoService.findPage(page,linesPerPage,orderBy,direction);
        Page<ProjetoDTO> listDTO = list.map(obj -> new ProjetoDTO(obj));

        return ResponseEntity.ok().body(listDTO);

    } 

    @RequestMapping(value="/pesquisa/titulo",  method=RequestMethod.GET)
    public ResponseEntity<List<Projeto>> findByTitulo(@RequestParam(value="titulo", defaultValue = "0") String titulo) {

        String nomeDecoded = URL.decodeParam(titulo);
        List<Projeto> list = projetoService.searchTitulo(nomeDecoded);
       /* List<ProjetoDTO> listDTO = list.stream().map(obj -> new ProjetoDTO(obj)).collect(Collectors.toList());*/

        return ResponseEntity.ok().body(list);

    } 


    @RequestMapping(value="/pesquisa/cliente",  method=RequestMethod.GET)
    public ResponseEntity<List<Projeto>> findByCliente(@RequestParam(value="cliente", defaultValue = "0") String cliente) {

        List<Projeto> list = projetoService.searchCliente(cliente);
       /* List<ProjetoDTO> listDTO = list.stream().map(obj -> new ProjetoDTO(obj)).collect(Collectors.toList());*/

        return ResponseEntity.ok().body(list);

    } 
    


}