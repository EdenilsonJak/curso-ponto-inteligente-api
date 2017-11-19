package com.ejsistemas.pontointeligente.api.services;

import java.util.Optional;

import com.ejsistemas.pontointeligente.api.entities.Funcionario;

public interface FuncionarioService {

	/**
	 * Persiste um funcionario na base de dados.
	 * 
	 * @Param funcionario
	 * @return Funcionario
	 * 
	 */
	Funcionario persistir(Funcionario funcionario);
	
	/**
	 * Busca e retorno um Funcionario dado cpf.
	 * 
	 * @Param CPF
	 * @return Optional<Funcionario>
	 * 
	 */
	Optional<Funcionario> buscarPorCpf(String cpf);
	
	/**
	 * Buca e retorno um Funcionario dado email.
	 * 
	 * @Param EMAIL
	 * @return Optional<Funcionario>
	 */
	Optional<Funcionario> buscarPorEmail(String email);
	
	/**
	 * Bucar e retorno Funcionario por Id.
	 * 
	 * @Param id
	 * @return Optional<Funcionario>
	 */
	
	Optional<Funcionario> buscarPorID(Long id);
}
