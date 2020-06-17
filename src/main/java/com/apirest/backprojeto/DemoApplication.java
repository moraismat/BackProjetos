package com.apirest.backprojeto;

import com.apirest.backprojeto.services.DBService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;	
import org.springframework.boot.autoconfigure.SpringBootApplication;	

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private DBService db;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		db.instantiateTestDataBase();
	}

}
