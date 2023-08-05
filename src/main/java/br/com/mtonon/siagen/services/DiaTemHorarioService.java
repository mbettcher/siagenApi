package br.com.mtonon.siagen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.Dia;
import br.com.mtonon.siagen.domain.DiaTemHorario;
import br.com.mtonon.siagen.domain.Horario;
import br.com.mtonon.siagen.domain.Servico;
import br.com.mtonon.siagen.domain.UnidadeSaude;
import br.com.mtonon.siagen.dto.DiaTemHorarioDTO;
import br.com.mtonon.siagen.dto.DiaTemHorarioNewDTO;
import br.com.mtonon.siagen.repositories.DiaTemHorarioRepository;
import br.com.mtonon.siagen.services.exceptions.DataIntegrityException;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class DiaTemHorarioService {
	
	@Autowired
	private DiaTemHorarioRepository diaTemHorarioRepository;
	
	public List<DiaTemHorario> findAll() {
		List<DiaTemHorario> obj = diaTemHorarioRepository.findAll();
		return obj;
	}
	
	
	public DiaTemHorario findById(Integer id) {
		Optional<DiaTemHorario> obj = diaTemHorarioRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + DiaTemHorario.class.getName()));
	}
	
	public DiaTemHorario save(DiaTemHorario obj) {
		obj.setId(null);
		return diaTemHorarioRepository.save(obj);
	}
	
	public DiaTemHorario update(DiaTemHorario obj) {
		DiaTemHorario newObj = findById(obj.getId());
		updateData(newObj, obj);
		return diaTemHorarioRepository.save(newObj);
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			diaTemHorarioRepository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					"Não é possível excluir uma Agenda que esteja sendo usada por outra tabela!"
					);
		}
	}

	
	public DiaTemHorario fromDTO(DiaTemHorarioDTO objDTO) {
		Dia dia = new Dia(objDTO.getDiaId(), null);
		Horario horario = new Horario(objDTO.getHorarioId(), null);
		Servico servico = new Servico(objDTO.getServicoId(), null, null, null, null, null, null, null, null);
		UnidadeSaude unidadeSaude = new UnidadeSaude(objDTO.getUnidadeSaudeId(), null, null, null, null);
		return new DiaTemHorario(objDTO.getId(), objDTO.isDisponivel(), dia, horario, servico, unidadeSaude);
	}
	
	
	public DiaTemHorario fromDTO(DiaTemHorarioNewDTO objDTO) {
		Dia dia = new Dia(objDTO.getDiaId(), null);
		Horario horario = new Horario(objDTO.getHorarioId(), null);
		Servico servico = new Servico(objDTO.getServicoId(), null, null, null, null, null, null, null, null);
		UnidadeSaude unidadeSaude = new UnidadeSaude(objDTO.getUnidadeSaudeId(), null, null, null, null);
		return new DiaTemHorario(null, objDTO.isDisponivel(), dia, horario, servico, unidadeSaude);
	}
	
	
	
	private void updateData(DiaTemHorario newObj, DiaTemHorario obj) {
		newObj.setDisponivel(obj.isDisponivel());
	}

}
