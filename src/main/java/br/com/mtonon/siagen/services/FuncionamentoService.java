package br.com.mtonon.siagen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.Funcionamento;
import br.com.mtonon.siagen.repositories.FuncionamentoRepository;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class FuncionamentoService {
	
	@Autowired
	private FuncionamentoRepository funcionamentoRepository;
	
	public List<Funcionamento> listar() {
		List<Funcionamento> obj = funcionamentoRepository.findAll();
		return obj;
	}
	
	public Funcionamento buscar(Integer id) {
		Optional<Funcionamento> obj = funcionamentoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Funcionamento.class.getName()));
	}

}
