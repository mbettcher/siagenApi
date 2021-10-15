package br.com.mtonon.siagen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.UnidadeSaude;
import br.com.mtonon.siagen.repositories.UnidadeSaudeRepository;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class UnidadeSaudeService {
	
	@Autowired
	private UnidadeSaudeRepository unidadeSaudeRepository;
	
	public UnidadeSaude buscar(Integer id) {
		Optional<UnidadeSaude> obj = unidadeSaudeRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + UnidadeSaude.class.getName()));
	}

	public List<UnidadeSaude> listar() {
		List<UnidadeSaude> lista = unidadeSaudeRepository.findAll();
		return lista;
	}

}
