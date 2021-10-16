package br.com.mtonon.siagen.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mtonon.siagen.domain.NomeVacina;
import br.com.mtonon.siagen.services.NomeVacinaService;

@RestController
@RequestMapping(value = "/nomes/vacinas")
public class NomeVacinaResource {
	
	@Autowired
	private NomeVacinaService nomeVacinaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listar() {
		List<NomeVacina> obj = nomeVacinaService.listar();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable Integer id) {
		NomeVacina obj = nomeVacinaService.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

}
