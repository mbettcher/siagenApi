package br.com.mtonon.siagen.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.DiaSemana;
import br.com.mtonon.siagen.domain.Funcionamento;
import br.com.mtonon.siagen.dto.FuncionamentoDTO;
import br.com.mtonon.siagen.dto.FuncionamentoNewDTO;
import br.com.mtonon.siagen.repositories.FuncionamentoRepository;
import br.com.mtonon.siagen.services.exceptions.DataIntegrityException;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class FuncionamentoService {
	
	@Autowired
	private FuncionamentoRepository funcionamentoRepository;
	
	public List<Funcionamento> findAll() {
		List<Funcionamento> obj = funcionamentoRepository.findAll();
		return obj;
	}
	
	public Funcionamento findById(Integer id) {
		Optional<Funcionamento> obj = funcionamentoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Funcionamento.class.getName()));
	}

	public Funcionamento save(Funcionamento obj) {
		obj.setId(null);
		return funcionamentoRepository.save(obj);
	}
	
	public Funcionamento update(Funcionamento obj) {
		Funcionamento newObj = findById(obj.getId());
		updateData(newObj, obj);
		return funcionamentoRepository.save(newObj);
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			funcionamentoRepository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					"Não é possível excluir um funcionamento que esteja sendo usado por outra tabela!"
					);
		}
	}
	
	public Funcionamento fromDTO(FuncionamentoDTO objDTO) {

		Funcionamento funcionamento = new Funcionamento(objDTO.getId(), objDTO.getHorarioAbertura(),
				objDTO.getHoraFechamento());

		List<DiaSemana> diasFuncionamento = new ArrayList<>();

		for (DiaSemana diaSemana : objDTO.getDiasSemana()) {
			diaSemana.setFuncionamento(funcionamento);
			diasFuncionamento.add(diaSemana);
		}

		funcionamento.setDiasSemana(diasFuncionamento);
		
		return funcionamento;
	}
	
	public Funcionamento fromDTO(FuncionamentoNewDTO objDTO) {
		return new Funcionamento(null, objDTO.getHorarioAbertura(), objDTO.getHoraFechamento());
	}
	
	private void updateData(Funcionamento newObj, Funcionamento obj) {
		newObj.setHorarioAbertura(obj.getHorarioAbertura());
		newObj.setHoraFechamento(obj.getHoraFechamento());
		newObj.setDiasSemana(obj.getDiasSemana());
	}
}
