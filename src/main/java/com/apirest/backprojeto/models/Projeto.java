package com.apirest.backprojeto.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Projeto implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;
    private String descricao;
    private String cliente;
	private String data;
	
	@OneToMany(mappedBy = "projeto")
	@JsonManagedReference
    private List<Pessoa> pessoasEnvolvidas = new ArrayList<>();  


	public Projeto() {}

	public Projeto(Integer id, String titulo, String descricao, String cliente, String data) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.cliente = cliente;
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Projeto other = (Projeto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public String getCliente() {
		return cliente;
	}



	public void setCliente(String cliente) {
		this.cliente = cliente;
	}



	public String getData() {
		return data;
	}



	public void setData(String data) {
		this.data = data;
	}



	public List<Pessoa> getPessoasEnvolvidas() {
		return pessoasEnvolvidas;
	}



	public void setPessoasEnvolvidas(List<Pessoa> pessoasEnvolvidas) {
		this.pessoasEnvolvidas = pessoasEnvolvidas;
	}
    
}