package br.com.measureoffshore.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.measureoffshore.gestao.entity.UsuarioEntity;
 
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
 
	UsuarioEntity findByLogin(String login);
}
