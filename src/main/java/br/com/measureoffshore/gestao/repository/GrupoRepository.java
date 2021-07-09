package br.com.measureoffshore.gestao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.measureoffshore.gestao.entity.GrupoEntity;

@Repository
public interface GrupoRepository extends CrudRepository<GrupoEntity, Long> {

	GrupoEntity findByNome(String nome);

}
