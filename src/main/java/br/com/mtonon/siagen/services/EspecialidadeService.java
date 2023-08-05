package br.com.mtonon.siagen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.Especialidade;
import br.com.mtonon.siagen.dto.EspecialidadeDTO;
import br.com.mtonon.siagen.repositories.EspecialidadeRepository;
import br.com.mtonon.siagen.services.exceptions.DataIntegrityException;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class EspecialidadeService {

	@Autowired
	private EspecialidadeRepository especialidadeRepository;

	public Especialidade find(Integer id) {
		Optional<Especialidade> obj = especialidadeRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Especialidade.class.getName()));
	}

	public List<Especialidade> findAll() {
		return especialidadeRepository.findAll();
	}

	public Especialidade save(Especialidade obj) {
		obj.setId(null);
		return especialidadeRepository.save(obj);
	}
	
	public Especialidade update(Especialidade obj) {
		find(obj.getId());
		return especialidadeRepository.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			especialidadeRepository.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					"Não é possível excluir uma especialidade que esteja sendo usada por uma Unidade de Saúde!"
					);
		}
	}
	
	public Page<Especialidade> findPage(Integer page, Integer linesPerPage, String direction, String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return especialidadeRepository.findAll(pageRequest);
	}
	
	/** Método auxiliar que converte um objeto do tipo EspecialidadeDTO em um objeto do tipo
	 * Especialidade; 
	**/
	public Especialidade fromDTO(EspecialidadeDTO objDTO) {
		return new Especialidade(objDTO.getId(), objDTO.getDescricao());
	}

}
