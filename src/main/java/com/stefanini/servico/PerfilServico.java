package com.stefanini.servico;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.validation.Valid;

import com.stefanini.dao.PerfilDao;
import com.stefanini.model.Perfil;
import com.stefanini.util.IGenericService;

/**
 * 
 * Classe de servico, as regras de negocio devem estar nessa classe
 * @author SamukaAlves000
 *
 */
public class PerfilServico implements IGenericService<Perfil, Integer>{

	@Inject
	private PerfilDao dao;
	
	
	/**
	 * Salvar os dados de um perfil
	 */
	@Override
	public Perfil salvar(@Valid Perfil perfil) {
		
		return dao.salvar(perfil);
	}

	/**
	 * Atualizar o dados de um perfil
	 */
	@Override
	public Perfil atualizar(@Valid Perfil perfil) {
		
		return dao.atualizar(perfil);
	}

	/**
	 * Remover uma perfil pelo id
	 */
	@Override
	public void remover(Integer id) {
		dao.remover(id);
	}

	/**
	 * Buscar uma lista de perfil
	 */
	@Override
	public Optional<List<Perfil>> getList() {
		
		return dao.getList();
	}

	/**
	 * Buscar uma perfil pelo ID
	 */
	@Override
	public Optional<Perfil> encontrar(Integer id) {
		
		return dao.encontrar(id);
	}

}
