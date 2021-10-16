package br.com.mtonon.siagen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.Dia;
import br.com.mtonon.siagen.repositories.DiaRepository;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class DiaService {
	
	@Autowired
	private DiaRepository diaRepository;
	
	public List<Dia> listar() {
		List<Dia> obj = diaRepository.findAll();
		return obj;
	}
	
	public Dia buscar(Integer id) {
		Optional<Dia> obj = diaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id " + id + ", Tipo: " + Dia.class.getName()));
	}

}
