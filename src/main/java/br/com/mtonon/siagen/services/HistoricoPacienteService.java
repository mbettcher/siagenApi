package br.com.mtonon.siagen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.HistoricoPaciente;
import br.com.mtonon.siagen.repositories.HistoricoPacienteRepository;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class HistoricoPacienteService {
	
	@Autowired
	private HistoricoPacienteRepository historicoPacienteRepository;
	
	public List<HistoricoPaciente> listar() {
		List<HistoricoPaciente> obj = historicoPacienteRepository.findAll();
		return obj;
	}
	
	public HistoricoPaciente buscar(Integer id) {
		Optional<HistoricoPaciente> obj = historicoPacienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + HistoricoPaciente.class.getName()));
	}

}
