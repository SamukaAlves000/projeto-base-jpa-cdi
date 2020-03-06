package com.stefanini.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author SamukaAlves000
 *
 */
@Entity
@Table(name = "TB_PERFIL")
public class Perfil implements Serializable{
	
	/**
	 * Serializacao da Classe
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ID da Tabela
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CO_SEQ_PERFIL")
	private Integer id;
	
	/**
	 * Nome do perfil
	 */
	@NotNull
    @Column(name = "NO_PERFIL",length = 255)
	private String nome;
	
	/**
	 * Descrição do perfil
	 */
	@NotNull
	@Column(name = "DS_PERFIL",length = 1000)
	private String descricao;
	
	/**
	 * Data de inclusão do perfil
	 */
	@NotNull
	@Column(name = "DT_HORA_INCLUSAO")
	private LocalDate dataHoraInclusao;
	
	/**
	 * Data de alteração do perfil
	 */
	@Column(name = "DT_HORA_ALTERACAO")
	private LocalDate dataHoraAlteracao;
	
	@ManyToMany(mappedBy = "perfis")
    Set<Pessoa> pessoas;

	/**
	 * Metodo construtor da classe
	 */
	public Perfil() {
		super();
	}

	/**
	 * Construtor da Classe, Obrigando receber todos os parametros
	 * @param nome
	 * @param descricao
	 * @param dataHoraInclusao
	 * @param dataHoraAlteracao
	 */
	public Perfil(@NotNull String nome, @NotNull String descricao, @NotNull LocalDate dataHoraInclusao,LocalDate dataHoraAlteracao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.dataHoraInclusao = dataHoraInclusao;
		this.dataHoraAlteracao = dataHoraAlteracao;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataHoraInclusao() {
		return dataHoraInclusao;
	}

	public void setDataHoraInclusao(LocalDate dataHoraInclusao) {
		this.dataHoraInclusao = dataHoraInclusao;
	}

	public LocalDate getDataHoraAlteracao() {
		return dataHoraAlteracao;
	}

	public void setDataHoraAlteracao(LocalDate dataHoraAlteracao) {
		this.dataHoraAlteracao = dataHoraAlteracao;
	}

	public Set<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(Set<Pessoa> pessoas) {
		this.pessoas = pessoas;
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
		Perfil other = (Perfil) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Perfil [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", dataHoraInclusao="
				+ dataHoraInclusao + ", dataHoraAlteracao=" + dataHoraAlteracao + "]";
	}	

}
