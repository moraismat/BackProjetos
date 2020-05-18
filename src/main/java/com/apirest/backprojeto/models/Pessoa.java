package com.apirest.backprojeto.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Pessoa implements Serializable{
    private static final long serialVersionUID = 1L;
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        private String nome;
        private String cpf;
        private String email;

        @JsonBackReference
        @ManyToOne
        @JoinColumn(name = "projeto_id")
	    private Projeto projeto;

        
        public Pessoa() {}

		public Pessoa(Integer id, String nome, String cpf, String email, Projeto projeto) {
			this.id = id;
			this.nome = nome;
			this.cpf = cpf;
            this.email = email;
            this.projeto = projeto;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Projeto getProjeto() {
			return projeto;
		}

		public void setProjeto(Projeto projeto) {
			this.projeto = projeto;
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
			Pessoa other = (Pessoa) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
        
        
}