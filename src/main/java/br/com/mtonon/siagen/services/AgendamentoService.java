package br.com.mtonon.siagen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.Agendamento;
import br.com.mtonon.siagen.repositories.AgendamentoRepository;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class AgendamentoService {
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	public List<Agendamento> listar() {
		List<Agendamento> obj = agendamentoRepository.findAll();
		return obj;
	}
	
	public Agendamento buscar(Integer id) {
		Optional<Agendamento> obj = agendamentoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Agendamento.class.getName()));
	}

}
