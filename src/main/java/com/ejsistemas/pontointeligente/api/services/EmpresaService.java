package com.ejsistemas.pontointeligente.api.services;

import java.util.Optional;

import com.ejsistemas.pontointeligente.api.entities.Empresa;

public interface EmpresaService {

	/**
	 * Retorna uma empresa dado o CNPJ.
	 * 
	 * @PARAM cnpj
	 * @return Optional<empresa>
	 * 
	 * 
	 */
	
	Optional<Empresa> buscarPorCnpj(String cnpj);
	
	/**
	 * Cadastra uma nova empresa na base de dados.
	 * 
	 * @Param empresa
	 * @Return Empresa 
	 */
	
	Empresa persistir(Empresa empresa);
	
}
