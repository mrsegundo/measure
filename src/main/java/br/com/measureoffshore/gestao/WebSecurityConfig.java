package br.com.measureoffshore.gestao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.measureoffshore.gestao.service.UsuarioService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioService usuarioRepositoryImpl;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		/*
		 * AQUI ESTOU INFORMANDO QUE QUALQUER REQUEST TEM ACESSO AO DIRETÓRIO
		 * src/main/resources
		 */
	    web.ignoring().antMatchers("/resources/**");
	}

	/**
	 * REALIZA AS CONFIGURAÇÕES DE ACESSO
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				/*
				 * DETERMINA QUE PARA REALIZAR ESSA REQUEST PRECISA TER UMA DAS PERMISSÕES
				 * ABAIXO EXEMPLO DA URL: http://localhost:8080/usuario/novoCadastro VEJA QUE EM
				 * UM ITEM("hasRole('ADMIN')) NÃO ESTOU PASSANDO O PREFIXO ROLE_, ESSE PREFIXO
				 * NÃO É OBRIGATÓRIO QUANDO USAMOS o hasRole
				 */
//				.antMatchers("/usuario/novoCadastro").access("hasRole('ADMIN') or hasRole('ROLE_CADASTROUSUARIO')")
				/*
				 * DETERMINA QUE PARA REALIZAR ESSA REQUEST PRECISA TER UMA DAS PERMISSÕES
				 * ABAIXO EXEMPLO DA URL: http://localhost:8080/usuario/consultar
				 */
//				.antMatchers("/usuario/consultar").access("hasRole('ADMIN') or hasRole('CONSULTAUSUARIO')")
				
				.antMatchers("/").permitAll()
				/*
				 * DETERMINA QUE PARA ACESSAR A PÁGINA INICIAL DA APLICAÇÃO PRECISA ESTÁ
				 * AUTENTICADO
				 */
//				.antMatchers("/privado").authenticated().anyRequest().authenticated()
				/*
				 * INFORMANDO O CAMINHO DA PÁGINA DE LOGIN, E SE O LOGIN FOR EFETUADO COM
				 * SUCESSO O USUÁRIO DEVE SER REDIRECIONADO PARA
				 * /home(http://localhost:8080/home)
				 */
//				.and().formLogin().loginPage("/login").defaultSuccessUrl("/home", true).permitAll() 
				/*
				* AQUI ESTAMOS INFORMANDO QUE TODOS TEM
				* ACESSO A PÁGINA DE LOGIN
				*/
				
				/*
				 * AQUI ESTAMOS INFORMANDO QUE QUANDO FOR REDIRECIONADO PARA O LINK
				 * http://localhost:8080/logout O USUÁRIO DEVE TER SUA SESSÃO FINALIZADA E
				 * REDIRECIONADO PARA A PÁGINA DE LOGIN
				 */
				.and().logout().logoutSuccessUrl("/").logoutUrl("/logout").permitAll();

				/*
				 * PÁGINA COM A MENSAGEM DE ACESSO NEGADO QUANDO O USUÁRIO NÃO TER UMA
				 * DETERMINADA PERMISSÃO DE ACESSO AO SISTEMA ELE VAI SER REDIRECIONADO PARA A
				 * URL ABAIXO
				 */
				http.exceptionHandling().accessDeniedPage("/acessoNegado");

				
//				http.authorizeRequests().antMatchers("/resources/**").permitAll().anyRequest().permitAll();

	}
	
	

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		/* INFORMA A CRIPTOGRAFIA QUE DEVE SER USADA PARA A SENHA DO USUÁRIO */
		auth.userDetailsService(usuarioRepositoryImpl).passwordEncoder(new BCryptPasswordEncoder());

	}
}