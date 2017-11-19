package com.ejsistemas.pontointeligente.api.services.impl;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ejsistemas.pontointeligente.api.entities.Lancamento;
import com.ejsistemas.pontointeligente.api.repositories.LancamentoRepository;
import com.ejsistemas.pontointeligente.api.services.LancamentoService;

@Service
public class LancamentoServiceImpl implements LancamentoService {

	private static final Logger log = LoggerFactory.getLogger(LancamentoServiceImpl.class);
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	
	@Override
	public Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest) {
		log.info("Buscando lançamentos por funcionário Id {}", funcionarioId);
		return this.lancamentoRepository.findByFuncionarioId(funcionarioId, pageRequest);
	}

	public Optional<Lancamento> buscarPorId(Long id) {
		log.info("Buscando um lançamento por Id {}", id);
		return Optional.ofNullable(this.lancamentoRepository.findOne(id));
	}

	@Override
	public Lancamento persistir(Lancamento lancameto) {
		log.info("Persistindo o Lançamento {}", lancameto);
		return this.lancamentoRepository.save(lancameto);
	}

	@Override
	public void remover(Long id) {
		log.info("Removendo Lançamento por Id {}", id);
		this.lancamentoRepository.delete(id);
	}

}
