package com.stefanini.servico;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.persistence.Query;
import javax.validation.Valid;

import com.stefanini.dao.PessoaDao;
import com.stefanini.model.Pessoa;
import com.stefanini.util.IGenericService;

/**
 * 
 * Classe de servico, as regras de negocio devem estar nessa classe
 * @author joaopedromilhome
 *
 */
public class PessoaServico implements IGenericService<Pessoa, Long> {
	
	@Inject
	private PessoaDao dao;
	
	
	/**
	 * Salvar os dados de uma Pessoa
	 */
	public Pessoa salvar(@Valid Pessoa pessoa) {
		return dao.salvar(pessoa);
	}


	/**
	 * Atualizar o dados de uma pessoa
	 */
	@Override
	public Pessoa atualizar(@Valid Pessoa entity) {
		return dao.atualizar(entity);
	}


	/**
	 * Remover uma pessoa pelo id
	 */
	@Override
	public void remover(Long id) {
		dao.remover(id);
	}

	/**
	 * Buscar uma lista de Pessoa
	 */
	@Override
	public Optional<List<Pessoa>> getList() {
		return dao.getList();
	}


	/**
	 * Buscar uma Pessoa pelo ID
	 */
	@Override
	public Optional<Pessoa> encontrar(Long id) {
		return dao.encontrar(id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> getListPessoa(String cidade, String uf) {
		
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("SELECT p  FROM Pessoa p");
		stringBuilder.append(" JOIN Endereco e ON p.id = e.id ");
		stringBuilder.append("WHERE e.cidade = '");
		stringBuilder.append(cidade);
		stringBuilder.append("' AND e.uf = '"+ uf +"'");
		
		Query query = dao.getEntityManager().createQuery(stringBuilder.toString());
		List<Pessoa> lista = query.getResultList();
		
		return  lista;
	}
	
	
	
	
	
}


