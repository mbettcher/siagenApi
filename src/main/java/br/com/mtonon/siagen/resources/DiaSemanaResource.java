package br.com.mtonon.siagen.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mtonon.siagen.domain.DiaSemana;
import br.com.mtonon.siagen.services.DiaSemanaService;

@RestController
@RequestMapping(value = "/dias/semanas")
public class DiaSemanaResource {
	
	@Autowired
	private DiaSemanaService diaSemanaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<DiaSemana>> listar(){
		List<DiaSemana> obj = diaSemanaService.listar();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<DiaSemana> buscar(@PathVariable Integer id){
		DiaSemana obj = diaSemanaService.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

}
