package br.com.mtonon.siagen.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import br.com.mtonon.siagen.security.JWTAuthenticationFilter;
import br.com.mtonon.siagen.security.JWTAuthorizationFilter;
import br.com.mtonon.siagen.security.JWTUtil;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private Environment env;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private UserDetailsService userDetailsService;

	/* VETOR COM OS PATHS QUE ESTÃO LIBERADOS PARA ACESSO SEM SENHA */
	private static final String[] PUBLIC_MATCHERS = {
			"/h2-console/**"
	};
	
	/* VETOR COM OS PATHS QUE ESTÃO LIBERADOS APENAS PARA O MÉTODO GET PARA ACESSO SEM SENHA */
	private static final String[] PUBLIC_MATCHERS_GET = {
			"/especialidades/**",
			"/dias/horarios/**",
			"/pacientes/**"
	};
	
		
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		/* VERIFICA QUAL O PROFILE ESTÁ ATIVO NO SISTEMA. SE FOR O PROFILE TEST, EXECUTA O COMANDO ABAIXO */
		if(Arrays.asList(env.getActiveProfiles()).contains("test")) {
			http.headers().frameOptions().disable();
		}
		
		/* CHAMA O BEAN corsConfigurationSource E DESABILITA O CSRF, POIS O BACKEND SERÁ TIPO STATELESS */
		http.cors().and().csrf().disable();
		
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()
			.antMatchers(PUBLIC_MATCHERS).permitAll()
			.anyRequest()
			.authenticated();
		
		/* REGISTRANDO O FILTRO DE AUTHENTICATION */
		http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil));
		
		/* REGISTRANDO O FILTRO DE AUTHORIZATION */
		http.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil, userDetailsService));
		
		/*CONFIGURAÇÃO PARA QUE O SISTEMA NÃO CRIE UMA SESSÃO PARA O USUÁRIO, PREVALECENDO O STATELESS*/
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
	
	/* BEAN PARA PERMITIR O ACESSO AO NOSSO BACKEND POR DIVERSAS FONTES */
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
