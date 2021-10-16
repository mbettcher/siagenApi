package br.com.mtonon.siagen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.Horario;
import br.com.mtonon.siagen.repositories.HorarioRepository;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class HorarioService {

	@Autowired
	private HorarioRepository horarioRepository;
	
	public List<Horario> listar() {
		List<Horario> obj = horarioRepository.findAll();
		return obj;
	}
	
	public Horario buscar(Integer id) {
		Optional<Horario> obj = horarioRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Horario.class.getName()));
	}
}
