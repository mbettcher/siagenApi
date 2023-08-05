package br.com.mtonon.siagen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.Horario;
import br.com.mtonon.siagen.dto.HorarioDTO;
import br.com.mtonon.siagen.repositories.HorarioRepository;
import br.com.mtonon.siagen.services.exceptions.DataIntegrityException;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class HorarioService {

	@Autowired
	private HorarioRepository horarioRepository;
	
	public List<Horario> findAll() {
		List<Horario> obj = horarioRepository.findAll();
		return obj;
	}
	
	public Horario find(Integer id) {
		Optional<Horario> obj = horarioRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Horario.class.getName()));
	}
	
	public Page<Horario> findPage(Integer page, Integer linesPerPage, String direction, String orderBy){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return horarioRepository.findAll(pageRequest);
	}
	
	public Horario fromDTO(HorarioDTO objDTO) {
		return new Horario(objDTO.getId(), objDTO.getHora());
	}
	
	public Horario save(Horario obj) {
		obj.setId(null);
		return horarioRepository.save(obj);
	}
	
	public Horario update(Horario obj) {
		find(obj.getId());
		return horarioRepository.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			horarioRepository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					"Não é possível excluir um horário que esteja sendo usada por outra tabela!"
					);
		}
	}
}
