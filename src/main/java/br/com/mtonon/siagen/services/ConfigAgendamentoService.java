package br.com.mtonon.siagen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.ConfigAgendamento;
import br.com.mtonon.siagen.repositories.ConfigAgendamentoRepository;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class ConfigAgendamentoService {
	
	@Autowired
	private ConfigAgendamentoRepository configAgendamentoRepository;
	
	public List<ConfigAgendamento> listar() {
		List<ConfigAgendamento> obj = configAgendamentoRepository.findAll();
		return obj;
	}
	
	
	public ConfigAgendamento buscar(Integer id) {
		Optional<ConfigAgendamento> obj = configAgendamentoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + ConfigAgendamento.class.getName()));
	}

}
