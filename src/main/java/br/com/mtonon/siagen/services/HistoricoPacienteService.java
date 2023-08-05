package br.com.mtonon.siagen.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.HistoricoPaciente;
import br.com.mtonon.siagen.domain.Paciente;
import br.com.mtonon.siagen.dto.HistoricoPacienteDTO;
import br.com.mtonon.siagen.dto.HistoricoPacienteNewDTO;
import br.com.mtonon.siagen.repositories.HistoricoPacienteRepository;
import br.com.mtonon.siagen.services.exceptions.DataIntegrityException;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class HistoricoPacienteService {
	
	@Autowired
	private HistoricoPacienteRepository historicoPacienteRepository;
	
	public List<HistoricoPaciente> findAll() {
		List<HistoricoPaciente> obj = historicoPacienteRepository.findAll();
		return obj;
	}
	
	public HistoricoPaciente findById(Integer id) {
		Optional<HistoricoPaciente> obj = historicoPacienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + HistoricoPaciente.class.getName()));
	}
	
	public HistoricoPaciente save(HistoricoPaciente obj) {
		obj.setId(null);
		return historicoPacienteRepository.save(obj);
	}
	
	public HistoricoPaciente update(HistoricoPaciente obj) {
		HistoricoPaciente newObj = findById(obj.getId());
		updateData(newObj, obj);
		return historicoPacienteRepository.save(newObj);
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			historicoPacienteRepository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					"Não é possível excluir um histórico de Paciente que esteja sendo usado por outra tabela!"
					);
		}
	}

	public HistoricoPaciente fromDTO(HistoricoPacienteDTO objDTO) {
		Paciente paciente = new Paciente(objDTO.getPaciente(), null, null, null, null, null, null, null, null, null, null, null, null, null, null,null);
		return new HistoricoPaciente(objDTO.getId(), objDTO.getDataHistorico(), objDTO.getObservacao(), paciente);
	}
	
	public HistoricoPaciente fromDTO(HistoricoPacienteNewDTO objDTO) {
		return new HistoricoPaciente(null, LocalDateTime.now(), objDTO.getObservacao(), null);
	}
	
	private void updateData(HistoricoPaciente newObj, HistoricoPaciente obj) {
		newObj.setObservacao(obj.getObservacao());
	}
}
