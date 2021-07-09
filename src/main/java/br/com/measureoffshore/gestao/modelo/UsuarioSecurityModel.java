package br.com.measureoffshore.gestao.modelo;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
 
public class UsuarioSecurityModel extends User {
 
	private static final long serialVersionUID = -885115775500154816L;

	public UsuarioSecurityModel(String login, String senha,Boolean ativo,  Collection<? extends GrantedAuthority> authorities) {		
		super(login, senha, ativo,	true, true,true, authorities);
	}
}
