package br.com.mtonon.siagen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.Paciente;
import br.com.mtonon.siagen.repositories.PacienteRepository;
import br.com.mtonon.siagen.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private PacienteRepository repo;

	@Override
	public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
		
		Paciente pac = repo.findByCpf(cpf);
		
		
		if(pac == null) {
			throw new UsernameNotFoundException(cpf);
		}
		
		return new UserSS(pac.getId(), pac.getCpf(), pac.getSenha(), pac.getPerfis());
	}

}
