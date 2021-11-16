package br.com.mtonon.siagen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.Perfil;
import br.com.mtonon.siagen.dto.PerfilDTO;
import br.com.mtonon.siagen.repositories.PerfilRepository;
import br.com.mtonon.siagen.services.exceptions.DataIntegrityException;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class PerfilService {
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	public List<Perfil> findAll() {
		List<Perfil> obj = perfilRepository.findAll();
		return obj;
	}
	
	public Perfil find(Integer id) {
		Optional<Perfil> obj = perfilRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Perfil.class.getName()));
	}
	
	public Page<Perfil> findPage(Integer page, Integer linesPerPage, String direction, String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return perfilRepository.findAll(pageRequest);
	}

	public Perfil save(Perfil obj) {
		obj.setId(null);
		return perfilRepository.save(obj);
	}
	
	public Perfil update(Perfil obj) {
		find(obj.getId());
		return perfilRepository.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			perfilRepository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					"Não é possível excluir um perfil que esteja sendo usado por outra tabela!"
					);
		}
		
	}
	
	public Perfil fromDTO(PerfilDTO objDTO) {
		return new Perfil(objDTO.getId(), objDTO.getPerfil());
	}
}
