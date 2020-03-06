package com.stefanini.servico;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.validation.Valid;

import com.stefanini.dao.EnderecoDao;
import com.stefanini.model.Endereco;
import com.stefanini.util.IGenericService;

/**
 * 
 * Classe de servico, as regras de negocio devem estar nessa classe
 * @author SamukaAlves000
 *
 */
public class EnderecoServico implements IGenericService<Endereco, Integer>{
	
	@Inject
	EnderecoDao dao;

	/**
	 * Salvar os dados de um endereço
	 */
	@Override
	public Endereco salvar(@Valid Endereco endereco) {
		return dao.salvar(endereco);
	}

	/**
	 * Atualizar o dados de um endereço
	 */
	@Override
	public Endereco atualizar(@Valid Endereco endereco) {
		return dao.atualizar(endereco);
	}

	/**
	 * Remover um endereço pelo id
	 */
	@Override
	public void remover(Integer id) {
		dao.remover(id);
		
	}

	/**
	 * Buscar uma lista de endereços
	 */
	@Override
	public Optional<List<Endereco>> getList() {
		return dao.getList();
	}

	/**
	 * Buscar um endereço pelo ID
	 */
	@Override
	public Optional<Endereco> encontrar(Integer id) {
		return dao.encontrar(id);
	}
}
