package com.stefanini.dao;

import com.stefanini.dao.abstracao.GenericDao;
import com.stefanini.model.Endereco;

/**
 * O Unico objetivo da Dao 
 * @author  SamukaAlves000
 *
 */
public class EnderecoDao extends GenericDao<Endereco, Integer>{

	public EnderecoDao() {
		super(Endereco.class);
	}
}
