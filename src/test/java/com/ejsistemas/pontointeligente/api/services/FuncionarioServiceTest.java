package com.ejsistemas.pontointeligente.api.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.ejsistemas.pontointeligente.api.entities.Funcionario;
import com.ejsistemas.pontointeligente.api.repositories.FuncionarioRepository;
import com.ejsistemas.pontointeligente.api.repositories.FuncionarioRepositoryTest;
import com.jayway.jsonpath.Option;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class FuncionarioServiceTest {

	@MockBean
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Before
	public void setUp() throws Exception{
		BDDMockito.given(this.funcionarioRepository.save(Mockito.any(Funcionario.class))).willReturn(new Funcionario());
		BDDMockito.given(this.funcionarioRepository.findOne(Mockito.anyLong())).willReturn(new Funcionario());
		BDDMockito.given(this.funcionarioRepository.findByEmail(Mockito.anyString())).willReturn(new Funcionario());
		BDDMockito.given(this.funcionarioRepository.findByCpf(Mockito.anyString())).willReturn(new Funcionario());
	}
	
	@Test
	public void persisitirFuncionario(){
		Funcionario funcionario = this.funcionarioRepository.save(new Funcionario());
		
		assertNotNull(funcionario);
	}
	
	@Test
	public void testBuscarFuncionarioPorId(){
		Optional<Funcionario> funcionario = this.funcionarioService.buscarPorID(1L);
		
		assertTrue(funcionario.isPresent());
	}
	
	@Test
	public void testBuscarPorEmail(){
		Optional<Funcionario> funcionario = this.funcionarioService.buscarPorEmail("email@email.com");
		
		assertTrue(funcionario.isPresent());
	}
	
	@Test
	public void testBuscarFuncionarioPorCpf(){
		Optional<Funcionario> funcionario = this.funcionarioService.buscarPorCpf("24291173474");
		
		assertTrue(funcionario.isPresent());
	}
	
}
