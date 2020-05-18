package com.apirest.backprojeto.models;

import java.io.Serializable;

import javax.persistence.Id;

public class Projeto implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    private Integer id;

    private String titulo;
    private String descricao;
    private String cliente;
    private String data;
    private String pessoasEnvolvidas;


	public Projeto() {}

	public Projeto(Integer id, String titulo, String descricao, String cliente, String data, String pessoasEnvolvidas) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.cliente = cliente;
		this.data = data;
		this.pessoasEnvolvidas = pessoasEnvolvidas;
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



	public String getPessoasEnvolvidas() {
		return pessoasEnvolvidas;
	}



	public void setPessoasEnvolvidas(String pessoasEnvolvidas) {
		this.pessoasEnvolvidas = pessoasEnvolvidas;
	}
    
}