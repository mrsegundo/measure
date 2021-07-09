package br.com.measureoffshore.gestao.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.measureoffshore.gestao.entity.GrupoEntity;
import br.com.measureoffshore.gestao.modelo.GrupoModel;
import br.com.measureoffshore.gestao.repository.GrupoRepository;

@Service
@Transactional
public class GrupoService {

	@Autowired
	private GrupoRepository grupoRepository;

	/** CONSULA OS GRUPOS CADASTRADOS */
	@Transactional(readOnly = true)
	public List<GrupoModel> consultarGrupos() {

		List<GrupoModel> gruposModel = new ArrayList<GrupoModel>();

		/* CONSULTA TODOS OS GRUPOS */
		List<GrupoEntity> gruposEntity = (List<GrupoEntity>) this.grupoRepository.findAll();

		gruposEntity.forEach(grupo -> {
			gruposModel.add(new GrupoModel(grupo.getCodigo(), grupo.getDescricao()));
		});

		return gruposModel;
	}
	
	/** CONSULA OS GRUPOS CADASTRADOS */
	@Transactional(readOnly = true)
	public GrupoModel buscaGrupo(Long codigo) {
		/* CONSULTA GRUPO POR NOME */
		Optional<GrupoEntity>  grupo = this.grupoRepository.findById(codigo);
		
		return entityToModel(grupo.get());
	}
	
	/** CONSULA OS GRUPOS CADASTRADOS */
	@Transactional(readOnly = true)
	public GrupoModel buscaGrupo(String nome) {
		/* CONSULTA GRUPO POR NOME */
		GrupoEntity  grupo = this.grupoRepository.findByNome(nome);
		
		return entityToModel(grupo);
	}
	
	/***
	 * SALVA UM NOVO REGISTRO DE GRUPO
	 * @param grupoModel
	 */
	public void criarGrupo(GrupoModel grupoModel){
		this.grupoRepository.save(modelToEntity( grupoModel));
	}
	
	/***
	 * CONVERTE GRUPO MODELO PARA GRUPO ENTITY
	 * @param grupoModel
	 */
	private GrupoEntity modelToEntity(GrupoModel grupoModel){
		GrupoEntity gruposEntity = new GrupoEntity();
		gruposEntity.setCodigo(grupoModel.getCodigo());
		gruposEntity.setDescricao(grupoModel.getDescricao());
		gruposEntity.setNome(grupoModel.getNome());
		return gruposEntity;
	}
	
	/***
	 * CONVERTE GRUPO MODELO PARA GRUPO ENTITY
	 * @param grupoModel
	 */
	private GrupoModel entityToModel(GrupoEntity grupoEntity){
		return new GrupoModel(grupoEntity.getCodigo(), grupoEntity.getDescricao());
	}

}
