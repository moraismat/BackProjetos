package com.apirest.backprojeto;

import java.util.Arrays;

import com.apirest.backprojeto.models.Pessoa;
import com.apirest.backprojeto.models.Projeto;
import com.apirest.backprojeto.repositories.PessoaRepository;
import com.apirest.backprojeto.repositories.ProjetoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;	
import org.springframework.boot.autoconfigure.SpringBootApplication;	

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private ProjetoRepository projetoRepository;

	@Autowired
	private PessoaRepository pessoaRepository;


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Projeto proj1 = new Projeto(null, "Projetos API", "Criando back-end para Projetos", "Matheus Morais", "18/05/20");
		Pessoa p1 = new Pessoa(null, "Matheus Araujo de Morais", "70240980457", "morais629@gmail.com", proj1);
		Pessoa p2 = new Pessoa(null, "Ana Raquel Fernandes Rodrigue", "87790298747", "anaraquelfernandes@gmail.com", proj1);
		
		proj1.getPessoasEnvolvidas().addAll(Arrays.asList(p1, p2));;

		projetoRepository.saveAll(Arrays.asList(proj1));
		pessoaRepository.saveAll(Arrays.asList(p1, p2));
	}

}
