package br.com.mtonon.siagen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.Cidade;
import br.com.mtonon.siagen.domain.Estado;
import br.com.mtonon.siagen.dto.CidadeDTO;
import br.com.mtonon.siagen.repositories.CidadeRepository;
import br.com.mtonon.siagen.services.exceptions.DataIntegrityException;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	public List<Cidade> findAll() {
		List<Cidade> obj = cidadeRepository.findAll();
		return obj;
	}
	
	public Cidade find(Integer id) {
		Optional<Cidade> obj = cidadeRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cidade.class.getName()));
	}
	
	public Page<Cidade> findPage(Integer page, Integer linesPerPage, String direction, String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return cidadeRepository.findAll(pageRequest);
	}
	
	public Cidade save(Cidade obj) {
		obj.setId(null);
		return cidadeRepository.save(obj);
	}
	
	public Cidade update(Cidade obj) {
		Cidade newObj = find(obj.getId());
		updateData(newObj, obj);
		return cidadeRepository.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			cidadeRepository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					"Não é possível excluir uma Cidade que esteja sendo usada por outra tabela!"
					);
		}
	}
	
	public Cidade fromDTO(CidadeDTO objDTO) {
		return new Cidade(objDTO.getId(), objDTO.getNome(), new Estado(objDTO.getEstado().getId(), objDTO.getEstado().getNome()));
	}
	
	private void updateData(Cidade newObj, Cidade obj) {
		newObj.setNome(obj.getNome());
	}
}
