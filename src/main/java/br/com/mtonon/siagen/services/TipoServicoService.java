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
	
	public List<TipoServico> listar() {
		List<TipoServico> obj = tipoServicoRepository.findAll();
		return obj;
	}
	
	
	public TipoServico buscar(Integer id) {
		Optional<TipoServico> obj = tipoServicoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + TipoServico.class.getName()));
	}

}
