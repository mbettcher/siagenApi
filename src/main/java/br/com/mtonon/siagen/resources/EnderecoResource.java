package br.com.mtonon.siagen.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mtonon.siagen.domain.Endereco;
import br.com.mtonon.siagen.services.EnderecoService;

@RestController
@RequestMapping(value = "/enderecos/pacientes")
public class EnderecoResource {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Endereco>> listar() {
		List<Endereco> obj = enderecoService.listar();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Endereco> buscar(@PathVariable Integer id) {
		Endereco obj = enderecoService.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

}
