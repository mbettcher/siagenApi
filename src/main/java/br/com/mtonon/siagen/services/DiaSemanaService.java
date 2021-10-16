package br.com.mtonon.siagen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.DiaSemana;
import br.com.mtonon.siagen.repositories.DiaSemanaRepository;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class DiaSemanaService {
	
	@Autowired
	private DiaSemanaRepository diaSemanaRepository;
	
	public List<DiaSemana> listar() {
		List<DiaSemana> obj = diaSemanaRepository.findAll();
		return obj;
	}
	
	public DiaSemana buscar(Integer id) {
		Optional<DiaSemana> obj = diaSemanaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + DiaSemana.class.getName()));
	}

}
