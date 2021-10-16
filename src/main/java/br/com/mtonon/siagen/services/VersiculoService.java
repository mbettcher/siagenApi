package br.com.mtonon.siagen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.Versiculo;
import br.com.mtonon.siagen.repositories.VersiculoRepository;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class VersiculoService {
	
	@Autowired
	private VersiculoRepository versiculoRepository;
	
	public List<Versiculo> listar() {
		List<Versiculo> obj = versiculoRepository.findAll();
		return obj;
	}
	
	public Versiculo buscar(Integer id) {
		Optional<Versiculo> obj = versiculoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Versiculo.class.getName()));
	}

}
