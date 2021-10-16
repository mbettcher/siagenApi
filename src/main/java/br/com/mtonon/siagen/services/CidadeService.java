package br.com.mtonon.siagen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.Cidade;
import br.com.mtonon.siagen.repositories.CidadeRepository;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	public List<Cidade> listar() {
		List<Cidade> obj = cidadeRepository.findAll();
		return obj;
	}
	
	public Cidade buscar(Integer id) {
		Optional<Cidade> obj = cidadeRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cidade.class.getName()));
	}
	
}
