package br.com.mtonon.siagen.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mtonon.siagen.domain.Versiculo;
import br.com.mtonon.siagen.services.VersiculoService;

@RestController
@RequestMapping(value = "/versiculos")
public class VersiculoResource {
	
	@Autowired
	private VersiculoService versiculoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listar() {
		List<Versiculo> obj = versiculoService.listar();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable Integer id) {
		Versiculo obj = versiculoService.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

}
