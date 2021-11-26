package br.com.mtonon.siagen.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mtonon.siagen.domain.UnidadeSaude;
import br.com.mtonon.siagen.services.UnidadeSaudeService;

@RestController
@RequestMapping(value = "/unidades")
public class UnidadeSaudeResource {
	
	@Autowired
	private UnidadeSaudeService unidadeSaudeService;
	
	@GetMapping
	public ResponseEntity<List<UnidadeSaude>> listar() {
		List<UnidadeSaude> obj = unidadeSaudeService.listar();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UnidadeSaude> buscar(@PathVariable Integer id) {
		UnidadeSaude obj = unidadeSaudeService.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

}
