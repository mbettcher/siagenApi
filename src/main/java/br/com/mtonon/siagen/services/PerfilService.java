package br.com.mtonon.siagen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.Perfil;
import br.com.mtonon.siagen.repositories.PerfilRepository;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class PerfilService {
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	public List<Perfil> listar() {
		List<Perfil> obj = perfilRepository.findAll();
		return obj;
	}
	
	public Perfil buscar(Integer id) {
		Optional<Perfil> obj = perfilRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Perfil.class.getName()));
	}

}
