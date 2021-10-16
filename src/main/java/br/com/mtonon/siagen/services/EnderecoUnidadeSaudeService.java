package br.com.mtonon.siagen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.EnderecoUnidadeSaude;
import br.com.mtonon.siagen.repositories.EnderecoUnidadeSaudeRepository;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class EnderecoUnidadeSaudeService {
	
	@Autowired
	private EnderecoUnidadeSaudeRepository enderecoUnidadeSaudeRepository;
	
	public List<EnderecoUnidadeSaude> listar() {
		List<EnderecoUnidadeSaude> obj = enderecoUnidadeSaudeRepository.findAll();
		return obj;
	}
	
	public EnderecoUnidadeSaude buscar(Integer id) {
		Optional<EnderecoUnidadeSaude> obj = enderecoUnidadeSaudeRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + EnderecoUnidadeSaude.class.getName()));
	}

}
