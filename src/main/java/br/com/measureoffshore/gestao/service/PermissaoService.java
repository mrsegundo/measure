package br.com.measureoffshore.gestao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.measureoffshore.gestao.entity.PermissaoEntity;
import br.com.measureoffshore.gestao.repository.PermissaoRepository;

@Service
@Transactional
public class PermissaoService {

	@Autowired
	private PermissaoRepository permissaoRepository;

	/** CONSULTA AS PERMISSOES CADASTRADAS */
	@Transactional(readOnly = true)
	public List<PermissaoEntity> consultarPermissoes() {
		return this.permissaoRepository.findAll();
	}

	/** CONSULA OS PERMISSOES CADASTRADAS */
	@Transactional(readOnly = true)
	public PermissaoEntity buscaPermissao(String permissao) {
		/* CONSULTA PERMISSAO POR NOME */
		return this.permissaoRepository.findByPermissao(permissao);
	}

	/***
	 * SALVA UM NOVO REGISTRO DE PERMISSAO
	 * 
	 * @param permissaoEntity
	 */
	public void criarPermissao(PermissaoEntity permissaoEntity) {
		this.permissaoRepository.save(permissaoEntity);
	}

}
