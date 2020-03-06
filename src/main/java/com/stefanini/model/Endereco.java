package com.stefanini.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author SamukaAlves000
 *
 */
@Entity
@Table(name = "TB_ENDERECO")
public class Endereco implements Serializable{

	/**
	 * Serializacao da Classe
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ID da Tabela
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CO_SEQ_ENDERECO")
	private Integer id;
	
	/**
	 * Logradouro do endereco
	 */
	@NotNull
	@Column(name = "DS_LOGRADOURO",length = 150)
	private String logradouro;
	
	/**
	 * Complemento do endereco
	 */
	@NotNull
	@Column(name = "DS_COMPLEMENTO",length = 150)
	private String complemento;
	
	/**
	 * Bairro do endereco
	 */
	@NotNull
	@Column(name = "DS_BAIRRO",length = 250)
	private String bairro;
	
	/**
	 * Cidade do endereco
	 */
	@NotNull
	@Column(name = "DS_CIDADE")
	private String cidade;
	
	/**
	 * Undidade Federativa do endereco
	 */
	@NotNull
	@Column(name = "CO_UF")
	private String uf;
	
	/**
	 * CEP do endereco
	 */
	@NotNull
	@Column(name = "DS_CEP",length = 8)
	private String cep;
	
	@ManyToOne
	@JoinColumn(name = "CO_SEQ_PESSOA",nullable = false)
	private Pessoa pessoa;
	
	/**
	 * Metodo construtor da classe
	 */
	public Endereco() {
		
	}

	/**
	 * Construtor da Classe, Obrigando receber todos os parametros
	 * @param logradouro
	 * @param complemento
	 * @param bairro
	 * @param cidade
	 * @param uf
	 * @param cep
	 * @param pessoa
	 */
	public Endereco(@NotNull String logradouro, @NotNull String complemento, @NotNull String bairro, @NotNull String cidade, @NotNull String uf, @NotNull String cep, @NotNull Pessoa pessoa) {
		super();
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.pessoa = pessoa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", logradouro=" + logradouro + ", complemento=" + complemento + ", bairro="
				+ bairro + ", cidade=" + cidade + ", uf=" + uf + ", cep=" + cep + "]";
	}
		
	
}
