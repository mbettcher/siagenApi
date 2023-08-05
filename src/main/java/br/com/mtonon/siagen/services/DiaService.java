package br.com.mtonon.siagen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.Dia;
import br.com.mtonon.siagen.dto.DiaDTO;
import br.com.mtonon.siagen.repositories.DiaRepository;
import br.com.mtonon.siagen.services.exceptions.DataIntegrityException;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class DiaService {
	
	@Autowired
	private DiaRepository diaRepository;
	
	public List<Dia> findAll() {
		List<Dia> obj = diaRepository.findAll();
		return obj;
	}
	
	public Dia find(Integer id) {
		Optional<Dia> obj = diaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id " + id + ", Tipo: " + Dia.class.getName()));
	}
	
	public Dia save(Dia obj) {
		obj.setId(null);
		return diaRepository.save(obj);
	}
	
	public Dia update(Dia obj) {
		find(obj.getId());
		return diaRepository.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			diaRepository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					"Não é possível excluir uma data que esteja sendo usada por outra tabela!"
					);
		}
	}
	
	public Page<Dia> findPage(Integer page, Integer linesPerPage, String direction, String orderBy){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return diaRepository.findAll(pageRequest);
	}
	
	public Dia fromDTO(DiaDTO objDTO) {
		return new Dia(objDTO.getId(), objDTO.getData());
	}
}
