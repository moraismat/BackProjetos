package com.apirest.backprojeto.services;

import java.text.ParseException;
import java.util.Arrays;

import com.apirest.backprojeto.models.Pessoa;
import com.apirest.backprojeto.models.Projeto;
import com.apirest.backprojeto.repositories.PessoaRepository;
import com.apirest.backprojeto.repositories.ProjetoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {
    
    @Autowired
	private ProjetoRepository projetoRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

    public void instantiateTestDataBase() throws ParseException{

        Projeto proj1 = new Projeto(null, "API", "Criando back-end para Projetos", "Matheus Morais", "18/05/20");
        Projeto proj2 = new Projeto(null, "CODATA", "APP CODATA", "Helder", "10/03/18");
        Projeto proj3 = new Projeto(null, "ACI", "Aplicação S-intex", "Iure", "01/10/17");
        Projeto proj4 = new Projeto(null, "CI", "Aplicação Lavid", "Matheus Morais", "18/05/20");
        Projeto proj5 = new Projeto(null, "UFPB", "Criando Aplicação SIGAA", "STI", "30/01/16");
       
        Pessoa p1 = new Pessoa(null, "Matheus Araujo de Morais", "70240980457", "morais629@gmail.com", proj1);
        Pessoa p2 = new Pessoa(null, "Ana Raquel Fernandes Rodrigues", "87790298747", "anaraquelfernandes@gmail.com", proj1);
        Pessoa p3 = new Pessoa(null, "Benedito Rangel de Morais", "59863275896", "benedito@gmail.com", proj1);
        Pessoa p4 = new Pessoa(null, "Francisca Alda Araujo de Morais", "58731269875", "alda@gmail.com", proj2);
        Pessoa p5 = new Pessoa(null, "Jeffeson Araujo de Morais", "12759384657", "jeffeson@gmail.com", proj3);
        Pessoa p6 = new Pessoa(null, "Jeronimo Wallage Araujo de Morais", "11369527841", "jeronimo@gmail.com", proj3);
        Pessoa p7 = new Pessoa(null, "Alice Morais", "10236058985", "alice@gmail.com", proj4);
        Pessoa p8 = new Pessoa(null, "Viviane Araujo", "11425689752", "viviane@gmail.com", proj5);
        Pessoa p9 = new Pessoa(null, "Viviane asda", "11425689752", "viviane@gmail.com", proj1);
        
        proj1.getPessoasEnvolvidas().addAll(Arrays.asList(p1, p2,p3));
        proj2.getPessoasEnvolvidas().addAll(Arrays.asList(p4));
        proj3.getPessoasEnvolvidas().addAll(Arrays.asList(p5, p6));
        proj4.getPessoasEnvolvidas().addAll(Arrays.asList(p7));
        proj5.getPessoasEnvolvidas().addAll(Arrays.asList(p8));

        projetoRepository.saveAll(Arrays.asList(proj1,proj2,proj3,proj4,proj5));
        pessoaRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7,p8));


        proj1.getPessoasEnvolvidas().addAll(Arrays.asList(p9));
        projetoRepository.saveAll(Arrays.asList(proj1));
    }
}