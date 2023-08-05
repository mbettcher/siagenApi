package br.com.mtonon.siagen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.NomeVacina;
import br.com.mtonon.siagen.dto.NomeVacinaDTO;
import br.com.mtonon.siagen.repositories.NomeVacinaRepository;
import br.com.mtonon.siagen.services.exceptions.DataIntegrityException;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class NomeVacinaService {
	
	@Autowired
	private NomeVacinaRepository nomeVacinaRepository;
	
	public List<NomeVacina> findAll() {
		List<NomeVacina> obj = nomeVacinaRepository.findAll();
		return obj;
	}
	
	public NomeVacina find(Integer id) {
		Optional<NomeVacina> obj = nomeVacinaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + NomeVacina.class.getName()));
	}
	
	public Page<NomeVacina> findPage(Integer page, Integer linesPerPage, String direction, String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return nomeVacinaRepository.findAll(pageRequest);
	}
	
	public NomeVacina fromDTO(NomeVacinaDTO objDTO) {
		return new NomeVacina(objDTO.getId(), objDTO.getNomeVacina(), objDTO.getLaboratorio());
	}
	
	public NomeVacina save(NomeVacina obj) {
		obj.setId(null);
		return nomeVacinaRepository.save(obj);
	}
	
	public NomeVacina update(NomeVacina obj) {
		find(obj.getId());
		return nomeVacinaRepository.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			nomeVacinaRepository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					"Não é possível excluir um Nome de Vacina que esteja sendo usada por outra tabela!"
					);
		}
	}
}
