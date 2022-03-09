package br.com.mtonon.siagen.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mtonon.siagen.domain.Agendamento;
import br.com.mtonon.siagen.domain.DiaTemHorario;
import br.com.mtonon.siagen.domain.Paciente;
import br.com.mtonon.siagen.domain.Servico;
import br.com.mtonon.siagen.domain.UnidadeSaude;
import br.com.mtonon.siagen.domain.enums.Status;
import br.com.mtonon.siagen.dto.AgendamentoDTO;
import br.com.mtonon.siagen.dto.AgendamentoNewDTO;
import br.com.mtonon.siagen.repositories.AgendamentoRepository;
import br.com.mtonon.siagen.repositories.PacienteRepository;
import br.com.mtonon.siagen.security.UserSS;
import br.com.mtonon.siagen.services.exceptions.AuthorizationException;
import br.com.mtonon.siagen.services.exceptions.DataIntegrityException;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	@Autowired
	private DiaTemHorarioService diaTemHorarioService;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private ServicoService servicoService;
	
	@Autowired
	private UnidadeSaudeService unidadeSaudeService;
	
	@Autowired
	private EmailService emailService;

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
		obj.setPacienteAgendamento(pacienteService.findById(obj.getPacienteAgendamento().getId()));
		obj.setServico(servicoService.findById(obj.getServico().getId()));
		obj.setUnidadeSaude(unidadeSaudeService.findById(obj.getUnidadeSaude().getId()));
		
		agendamentoRepository.save(obj);
		
		emailService.sendSchedulingConfirmationEmail(obj);
		return obj;
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
				null, null, null, null, null,null);
		UnidadeSaude unidadeSaude = new UnidadeSaude(objDTO.getUnidadeSaudeId(), null, null, null, null);
		Servico servico = new Servico(objDTO.getServicoId(), null, null, null, null, null, null, null, null);

		return new Agendamento(objDTO.getId(), LocalDateTime.now(), objDTO.getAddrAgendamento(), objDTO.getDataInicio(),
				objDTO.getDataFim(), objDTO.isDiaInteiro(), Status.toEnum(objDTO.getStatusEvento()), objDTO.getTitulo(),
				objDTO.getDescricao(), objDTO.getChaveAgendamento(), objDTO.getDataAlteracao(), paciente, unidadeSaude,
				servico);
	}

	@Transactional
	public Agendamento fromDTO(AgendamentoNewDTO objDTO) {
		
		DiaTemHorario agenda = diaTemHorarioService.findById(objDTO.getAgendaId());

		Paciente paciente = new Paciente(objDTO.getPacienteId(), null, null, null, null, null, null, null, null, null,
				null, null, null, null, null,null);
		
		UnidadeSaude unidadeSaude = agenda.getUnidadeSaude();
		
		Servico servico = agenda.getServico();
		
		Agendamento agendamento = new Agendamento(null, LocalDateTime.now(), null,
				agenda.getDia().getData().atTime(agenda.getHorario().getHora()), 
				agenda.getDia().getData().atTime(agenda.getHorario().getHora().plusMinutes(servico.getTempoExecucao())), 
				false, Status.toEnum(objDTO.getStatusEvento()),	objDTO.getTitulo(), servico.getDescricao(), 
				null, null, paciente, unidadeSaude, servico);
		
		paciente.getAgendamentos().add(agendamento);
		unidadeSaude.getAgendamentos().add(agendamento);
		
		agenda.setDisponivel(false);
		diaTemHorarioService.update(agenda);
		
		return agendamento;
	}

	private void updateData(Agendamento newObj, Agendamento obj) {
		newObj.setAddrAgendamento(obj.getAddrAgendamento());
		newObj.setDataAlteracao(obj.getDataAlteracao());
		newObj.setTitulo(obj.getTitulo());
		newObj.setStatusEvento(obj.getStatusEvento());
	}
	
	public Page<Agendamento> findPage(Integer page, Integer linesPerPage, String direction, String orderBy) {
		
		UserSS user = UserService.authenticated();
		if(user == null) {
			throw new AuthorizationException("Acesso Negado!");
		}
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Optional<Paciente> pacienteOpt = pacienteRepository.findById(user.getId());
		return agendamentoRepository.findByPacienteAgendamento(pacienteOpt.get(), pageRequest);
	}

}
