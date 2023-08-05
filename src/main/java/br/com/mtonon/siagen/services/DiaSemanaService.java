package br.com.mtonon.siagen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.DiaSemana;
import br.com.mtonon.siagen.domain.Funcionamento;
import br.com.mtonon.siagen.dto.DiaSemanaDTO;
import br.com.mtonon.siagen.dto.DiaSemanaNewDTO;
import br.com.mtonon.siagen.repositories.DiaSemanaRepository;
import br.com.mtonon.siagen.services.exceptions.DataIntegrityException;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class DiaSemanaService {

	@Autowired
	private DiaSemanaRepository diaSemanaRepository;

	public List<DiaSemana> findAll() {
		List<DiaSemana> obj = diaSemanaRepository.findAll();
		return obj;
	}

	public DiaSemana findById(Integer id) {
		Optional<DiaSemana> obj = diaSemanaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + DiaSemana.class.getName()));
	}

	public DiaSemana save(DiaSemana obj) {
		obj.setId(null);
		return diaSemanaRepository.save(obj);
	}

	public DiaSemana update(DiaSemana obj) {
		DiaSemana newObj = findById(obj.getId());
		updateData(newObj, obj);
		return diaSemanaRepository.save(newObj);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			diaSemanaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					"Não é possível excluir um Dia da Semana que esteja sendo usado por outra tabela!");
		}
	}

	public DiaSemana fromDTO(DiaSemanaDTO objDTO) {
		Funcionamento funcionamento = objDTO.getFuncionamento();
		return new DiaSemana(objDTO.getId(), objDTO.getDia(), objDTO.isAtivo(), funcionamento);
	}

	public DiaSemana fromDTO(DiaSemanaNewDTO objDTO) {
		Funcionamento funcionamento = new Funcionamento(objDTO.getFuncionamentoId(), null, null);
		return new DiaSemana(null, objDTO.getDia(), true, funcionamento);
	}
	
	private void updateData(DiaSemana newObj, DiaSemana obj) {
		newObj.setDia(obj.getDia());
		newObj.setAtivo(obj.isAtivo());
		newObj.setFuncionamento(obj.getFuncionamento());
	}

}
