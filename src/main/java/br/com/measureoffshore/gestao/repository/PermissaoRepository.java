package br.com.measureoffshore.gestao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.measureoffshore.gestao.entity.GrupoEntity;
import br.com.measureoffshore.gestao.entity.PermissaoEntity;
 
public interface PermissaoRepository extends JpaRepository<PermissaoEntity, Long> {
 
	List<PermissaoEntity> findByGrupos(GrupoEntity grupoEntity);
	
	PermissaoEntity findByPermissao(String permissao);
	
}