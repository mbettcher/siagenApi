package br.com.mtonon.siagen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.Versiculo;
import br.com.mtonon.siagen.dto.VersiculoDTO;
import br.com.mtonon.siagen.repositories.VersiculoRepository;
import br.com.mtonon.siagen.services.exceptions.DataIntegrityException;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class VersiculoService {
	
	@Autowired
	private VersiculoRepository versiculoRepository;
	
	public List<Versiculo> findAll() {
		List<Versiculo> obj = versiculoRepository.findAll();
		return obj;
	}
	
	public Versiculo find(Integer id) {
		Optional<Versiculo> obj = versiculoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Versiculo.class.getName()));
	}
	
	public Page<Versiculo> findPage(Integer page, Integer linesPerPage, String direction, String orderBy){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return versiculoRepository.findAll(pageRequest);
	}
	
	public Versiculo fromDTO(VersiculoDTO objDTO) {
		return new Versiculo(objDTO.getId(), objDTO.getLivro(), objDTO.getVersiculo());
	}
	
	public Versiculo save(Versiculo obj) {
		obj.setId(null);
		return versiculoRepository.save(obj);
	}
	
	public Versiculo update(Versiculo obj) {
		find(obj.getId());
		return versiculoRepository.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			versiculoRepository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					"Não é possível excluir um versículo que esteja sendo usada por outra tabela!"
					);
		}
	}
}
