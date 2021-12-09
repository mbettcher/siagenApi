package br.com.mtonon.siagen.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.Agendamento;
import br.com.mtonon.siagen.domain.Paciente;
import br.com.mtonon.siagen.domain.Servico;
import br.com.mtonon.siagen.domain.UnidadeSaude;
import br.com.mtonon.siagen.domain.enums.Status;
import br.com.mtonon.siagen.dto.AgendamentoDTO;
import br.com.mtonon.siagen.dto.AgendamentoNewDTO;
import br.com.mtonon.siagen.repositories.AgendamentoRepository;
import br.com.mtonon.siagen.services.exceptions.DataIntegrityException;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository agendamentoRepository;

	public List<Agendamento> findAll() {
		List<Agendamento> obj = agendamentoRepository.findAll();
		return obj;
	}

	public Agendamento findById(Integer id) {
		Optional<Agendamento> obj = agendamentoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Agendamento.class.getName()));
	}

	public Agendamento save(Agendamento obj) {
		obj.setId(null);
		return agendamentoRepository.save(obj);
	}

	public Agendamento update(Agendamento obj) {
		Agendamento newObj = findById(obj.getId());
		updateData(newObj, obj);
		return agendamentoRepository.save(newObj);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			agendamentoRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					"Não é possível excluir um agendamento que esteja sendo usado por outra tabela!");
		}
	}

	public Agendamento fromDTO(AgendamentoDTO objDTO) {

		Paciente paciente = new Paciente(objDTO.getPacienteId(), null, null, null, null, null, null, null, null, null,
				null, null, null, null, null);
		UnidadeSaude unidadeSaude = new UnidadeSaude(objDTO.getUnidadeSaudeId(), null, null, null, null);
		Servico servico = new Servico(objDTO.getServicoId(), null, null, null, null, null, null, null, null);

		return new Agendamento(objDTO.getId(), LocalDateTime.now(), objDTO.getAddrAgendamento(), objDTO.getDataInicio(),
				objDTO.getDataFim(), objDTO.isDiaInteiro(), Status.toEnum(objDTO.getStatusEvento()), objDTO.getTitulo(),
				objDTO.getDescricao(), objDTO.getChaveAgendamento(), objDTO.getDataAlteracao(), paciente, unidadeSaude,
				servico);
	}

	public Agendamento fromDTO(AgendamentoNewDTO objDTO) {

		Paciente paciente = new Paciente(objDTO.getPacienteId(), null, null, null, null, null, null, null, null, null,
				null, null, null, null, null);
		UnidadeSaude unidadeSaude = new UnidadeSaude(objDTO.getUnidadeSaudeId(), null, null, null, null);
		Servico servico = new Servico(objDTO.getServicoId(), null, null, null, null, null, null, null, null);

		Agendamento agendamento = new Agendamento(null, LocalDateTime.now(), null,
				objDTO.getDataInicio().atTime(objDTO.getHoraInicio()), null, false, Status.toEnum(objDTO.getStatusEvento()),
				objDTO.getTitulo(), objDTO.getDescricao(), null, null, paciente, unidadeSaude, servico);
		paciente.getAgendamentos().add(agendamento);
		unidadeSaude.getAgendamentos().add(agendamento);
		return agendamento;
	}

	private void updateData(Agendamento newObj, Agendamento obj) {
		newObj.setAddrAgendamento(obj.getAddrAgendamento());
		newObj.setDataAlteracao(obj.getDataAlteracao());
		newObj.setDescricao(obj.getDescricao());
		newObj.setTitulo(obj.getTitulo());
		newObj.setStatusEvento(obj.getStatusEvento());
	}

}
