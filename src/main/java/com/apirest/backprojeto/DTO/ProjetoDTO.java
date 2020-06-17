package com.apirest.backprojeto.DTO;

import java.io.Serializable;
import java.util.List;

import com.apirest.backprojeto.models.Pessoa;
import com.apirest.backprojeto.models.Projeto;


public class ProjetoDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String titulo;
	private String descricao;
	private String cliente;
    private String data;
    private List<Pessoa> pessoasEnvolvidas;
 
    public ProjetoDTO(){}

    public ProjetoDTO(Projeto obj){
        id = obj.getId();
        titulo = obj.getTitulo();
		descricao = obj.getDescricao();
		cliente = obj.getCliente();
        data = obj.getData();
		pessoasEnvolvidas = obj.getPessoasEnvolvidas();
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

	public void setNome(String titulo) {
		this.titulo = titulo;
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

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

} 