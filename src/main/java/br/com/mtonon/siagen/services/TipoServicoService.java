package br.com.mtonon.siagen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.TipoServico;
import br.com.mtonon.siagen.repositories.TipoServicoRepository;
import br.com.mtonon.siagen.services.exceptions.DataIntegrityException;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class TipoServicoService {
	
	@Autowired
	private TipoServicoRepository tipoServicoRepository;
	
	public List<TipoServico> findAll() {
		List<TipoServico> obj = tipoServicoRepository.findAll();
		return obj;
	}
	
	
	public TipoServico find(Integer id) {
		Optional<TipoServico> obj = tipoServicoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + TipoServico.class.getName()));
	}
	
	public TipoServico save(TipoServico obj) {
		obj.setId(null);
		return tipoServicoRepository.save(obj);
	}
	
	public TipoServico update(TipoServico obj) {
		find(obj.getId());
		return tipoServicoRepository.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			tipoServicoRepository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					"Não é possível excluir um Tipo de Serviço que esteja sendo usado por outra tabela!"
					);
		}
	}
	
	public Page<TipoServico> findPage(Integer page, Integer linesPerPage, String direction, String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return tipoServicoRepository.findAll(pageRequest);
	}

}
