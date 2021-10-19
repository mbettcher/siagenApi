package br.com.mtonon.siagen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.Estado;
import br.com.mtonon.siagen.dto.EstadoDTO;
import br.com.mtonon.siagen.repositories.EstadoRepository;
import br.com.mtonon.siagen.services.exceptions.DataIntegrityException;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;
	
	public List<Estado> findAll() {
		List<Estado> obj = estadoRepository.findAll();
		return obj;
	}
	
	public Estado find(Integer id) {
		Optional<Estado> obj = estadoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+ id + ", Tipo: " + Estado.class.getName()));
	}
	
	public Estado save(Estado obj) {
		obj.setId(null);
		return estadoRepository.save(obj);
	}

	public Estado update(Estado obj) {
		find(obj.getId());
		return estadoRepository.save(obj);
	}
	
	public Estado fromDTO(EstadoDTO objDTO) {
		return new Estado(objDTO.getId(), objDTO.getNome());
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			estadoRepository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					"Não é possível excluir um Estado que esteja sendo usado por uma Cidade"
					);
		}
	}
	
	public Page<Estado> findPage(Integer page, Integer linesPerPage, String direction, String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return estadoRepository.findAll(pageRequest);
	}
}
