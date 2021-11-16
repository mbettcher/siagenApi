package br.com.mtonon.siagen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.ConfigAgendamento;
import br.com.mtonon.siagen.dto.ConfigAgendamentoDTO;
import br.com.mtonon.siagen.repositories.ConfigAgendamentoRepository;
import br.com.mtonon.siagen.services.exceptions.DataIntegrityException;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class ConfigAgendamentoService {
	
	@Autowired
	private ConfigAgendamentoRepository configAgendamentoRepository;
	
	public List<ConfigAgendamento> findAll() {
		List<ConfigAgendamento> obj = configAgendamentoRepository.findAll();
		return obj;
	}
	
	
	public ConfigAgendamento find(Integer id) {
		Optional<ConfigAgendamento> obj = configAgendamentoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + ConfigAgendamento.class.getName()));
	}
	
	public Page<ConfigAgendamento> findPage(Integer page, Integer linesPerPage, String direction, String orderBy){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return configAgendamentoRepository.findAll(pageRequest);
	}
	
	public ConfigAgendamento fromDTO(ConfigAgendamentoDTO objDTO) {
		return new ConfigAgendamento(objDTO.getId(), objDTO.getDataInicio(), objDTO.getDataEncerramento(), 
				objDTO.getHoraInicio(), objDTO.getHoraEncerramento(), objDTO.isIniciarAutomaticamente(),
				objDTO.isEncerrarAutomaricamente(), objDTO.isAtivo());
	}
	
	public ConfigAgendamento save(ConfigAgendamento obj) {
		obj.setId(null);
		return configAgendamentoRepository.save(obj);
	}
	
	public ConfigAgendamento update(ConfigAgendamento obj) {
		find(obj.getId());
		return configAgendamentoRepository.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			configAgendamentoRepository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					"Não é possível excluir uma configuração de agendamento que esteja sendo usada por outra tabela!"
					);
		}
	}
}
