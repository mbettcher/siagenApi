package br.com.mtonon.siagen.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.mtonon.siagen.domain.DiaSemana;
import br.com.mtonon.siagen.dto.DiaSemanaDTO;
import br.com.mtonon.siagen.dto.DiaSemanaNewDTO;
import br.com.mtonon.siagen.services.DiaSemanaService;

@RestController
@RequestMapping(value = "/dias/semanas")
public class DiaSemanaResource {
	
	@Autowired
	private DiaSemanaService diaSemanaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<DiaSemana>> listar(){
		List<DiaSemana> obj = diaSemanaService.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<DiaSemana> buscar(@PathVariable Integer id){
		DiaSemana obj = diaSemanaService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody DiaSemanaNewDTO objDTO) {
		DiaSemana obj = diaSemanaService.fromDTO(objDTO);
		obj = diaSemanaService.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody DiaSemanaDTO objDTO) {
		DiaSemana obj = diaSemanaService.fromDTO(objDTO);
		obj = diaSemanaService.update(obj);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		diaSemanaService.delete(id);
		return ResponseEntity.ok().build();
	}
}
