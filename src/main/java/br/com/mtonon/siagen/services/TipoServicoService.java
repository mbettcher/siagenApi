package br.com.mtonon.siagen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.TipoServico;
import br.com.mtonon.siagen.repositories.TipoServicoRepository;
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

}
