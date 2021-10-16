package br.com.mtonon.siagen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.NomeVacina;
import br.com.mtonon.siagen.repositories.NomeVacinaRepository;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class NomeVacinaService {
	
	@Autowired
	private NomeVacinaRepository nomeVacinaRepository;
	
	public List<NomeVacina> listar() {
		List<NomeVacina> obj = nomeVacinaRepository.findAll();
		return obj;
	}
	
	public NomeVacina buscar(Integer id) {
		Optional<NomeVacina> obj = nomeVacinaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + NomeVacina.class.getName()));
	}

}
