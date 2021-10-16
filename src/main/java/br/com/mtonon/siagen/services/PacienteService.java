package br.com.mtonon.siagen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.Paciente;
import br.com.mtonon.siagen.repositories.PacienteRepository;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class PacienteService {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	public Paciente buscar(Integer id) {
		Optional<Paciente> obj = pacienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado. Id " + id + ", Tipo: " + Paciente.class.getName()));
	}
	
	public List<Paciente> listar() {
		List<Paciente> lista = pacienteRepository.findAll();
		return lista;
	}

}
