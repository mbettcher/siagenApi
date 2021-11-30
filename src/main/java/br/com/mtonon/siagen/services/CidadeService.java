package br.com.mtonon.siagen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mtonon.siagen.domain.Cidade;
import br.com.mtonon.siagen.domain.Estado;
import br.com.mtonon.siagen.dto.CidadeDTO;
import br.com.mtonon.siagen.dto.CidadeNewDTO;
import br.com.mtonon.siagen.repositories.CidadeRepository;
import br.com.mtonon.siagen.repositories.EstadoRepository;
import br.com.mtonon.siagen.services.exceptions.DataIntegrityException;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
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
	
	@Transactional
	public Cidade save(Cidade obj) {
		obj.setId(null);
		obj = cidadeRepository.save(obj);
		return obj;
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
		Estado estado = new Estado(objDTO.getEstado(), null);
		return new Cidade(objDTO.getId(), objDTO.getNome(), objDTO.getIbge(), objDTO.getIbge7(), estado);
	}
	
	public Cidade fromDTO(CidadeNewDTO objDTO) {
		
		Cidade cidade = new Cidade(null, objDTO.getNome(), objDTO.getIbge(), objDTO.getIbge7(), null);
		Estado estado = new Estado(objDTO.getEstadoId(), null);
		cidade.setEstado(estado);
		
		return cidade; 
	}
	
	private void updateData(Cidade newObj, Cidade obj) {
		newObj.setNome(obj.getNome());
		newObj.setIbge(obj.getIbge());
		newObj.setIbge7(obj.getIbge7());
	}
}
