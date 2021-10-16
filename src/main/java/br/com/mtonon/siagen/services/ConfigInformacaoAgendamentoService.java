package br.com.mtonon.siagen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.ConfigInformacaoAgendamento;
import br.com.mtonon.siagen.repositories.ConfigInformacaoAgendamentoRepository;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class ConfigInformacaoAgendamentoService {

	@Autowired
	private ConfigInformacaoAgendamentoRepository configInformacaoAgendamentoRepository;
	
	public List<ConfigInformacaoAgendamento> listar() {
		List<ConfigInformacaoAgendamento> obj = configInformacaoAgendamentoRepository.findAll();
		return obj;
	}
	
	public ConfigInformacaoAgendamento buscar(Integer id) {
		Optional<ConfigInformacaoAgendamento> obj = configInformacaoAgendamentoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + ConfigInformacaoAgendamento.class.getName()));
	}
}
