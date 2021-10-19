package br.com.mtonon.siagen.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mtonon.siagen.domain.Perfil;
import br.com.mtonon.siagen.services.PerfilService;

@RestController
@RequestMapping(value = "/perfis")
public class PerfilResource {
	
	@Autowired
	private PerfilService perfilService;
	
	@GetMapping
	public ResponseEntity<?> listar() {
		List<Perfil> obj = perfilService.listar();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable Integer id) {
		Perfil obj = perfilService.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

}
