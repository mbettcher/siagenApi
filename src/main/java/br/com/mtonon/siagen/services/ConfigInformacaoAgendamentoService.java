package br.com.mtonon.siagen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.ConfigInformacaoAgendamento;
import br.com.mtonon.siagen.dto.ConfigInformacaoAgendamentoDTO;
import br.com.mtonon.siagen.repositories.ConfigInformacaoAgendamentoRepository;
import br.com.mtonon.siagen.services.exceptions.DataIntegrityException;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class ConfigInformacaoAgendamentoService {

	@Autowired
	private ConfigInformacaoAgendamentoRepository configInformacaoAgendamentoRepository;
	
	public List<ConfigInformacaoAgendamento> findAll() {
		List<ConfigInformacaoAgendamento> obj = configInformacaoAgendamentoRepository.findAll();
		return obj;
	}
	
	public ConfigInformacaoAgendamento find(Integer id) {
		Optional<ConfigInformacaoAgendamento> obj = configInformacaoAgendamentoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + ConfigInformacaoAgendamento.class.getName()));
	}
	
	public Page<ConfigInformacaoAgendamento> findPage(Integer page, Integer linesPerPage, String direction, String orderBy){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return configInformacaoAgendamentoRepository.findAll(pageRequest);
	}
	
	public ConfigInformacaoAgendamento save(ConfigInformacaoAgendamento obj) {
		obj.setId(null);
		return configInformacaoAgendamentoRepository.save(obj);
	}
	
	public ConfigInformacaoAgendamento update(ConfigInformacaoAgendamento obj) {
		find(obj.getId());
		return configInformacaoAgendamentoRepository.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			configInformacaoAgendamentoRepository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					"Não é possível excluir uma Informação de Agendamento que esteja em uso por outra tabela!"
					);
		}
	}
	
	public ConfigInformacaoAgendamento fromDTO(ConfigInformacaoAgendamentoDTO objDTO) {
		return new ConfigInformacaoAgendamento(objDTO.getId(), objDTO.isAtivo(), objDTO.getTitulo(), objDTO.getDescricao(), objDTO.getComplementar(),
				objDTO.getInformacao1(), objDTO.getInformacao2(), objDTO.getInformacao3(), objDTO.getInformacao4(), objDTO.getInformacao5(), 
				objDTO.getInformacao6(), objDTO.getInformacao7(), objDTO.getInformacao8(), objDTO.getInformacao9(), objDTO.getInformacao10(), 
				objDTO.isInformacaoVisivel1(), objDTO.isInformacaoVisivel2(), objDTO.isInformacaoVisivel3(), objDTO.isInformacaoVisivel4(), 
				objDTO.isInformacaoVisivel5(), objDTO.isInformacaoVisivel6(), objDTO.isInformacaoVisivel7(), objDTO.isInformacaoVisivel8(), 
				objDTO.isInformacaoVisivel9(), objDTO.isInformacaoVisivel10());
	}
}
