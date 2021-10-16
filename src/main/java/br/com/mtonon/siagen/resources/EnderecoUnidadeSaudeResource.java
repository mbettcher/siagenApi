package br.com.mtonon.siagen.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mtonon.siagen.domain.EnderecoUnidadeSaude;
import br.com.mtonon.siagen.services.EnderecoUnidadeSaudeService;

@RestController
@RequestMapping(value = "/enderecosunidade")
public class EnderecoUnidadeSaudeResource {
	
	@Autowired
	private EnderecoUnidadeSaudeService endeUnidadeSaudeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listar() {
		List<EnderecoUnidadeSaude> obj = endeUnidadeSaudeService.listar();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable Integer id) {
		EnderecoUnidadeSaude obj = endeUnidadeSaudeService.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

}
