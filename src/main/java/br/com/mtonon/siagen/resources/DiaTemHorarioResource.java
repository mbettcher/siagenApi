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

import br.com.mtonon.siagen.domain.DiaTemHorario;
import br.com.mtonon.siagen.dto.DiaTemHorarioDTO;
import br.com.mtonon.siagen.dto.DiaTemHorarioNewDTO;
import br.com.mtonon.siagen.services.DiaTemHorarioService;

@RestController
@RequestMapping(value = "/dias/horarios")
public class DiaTemHorarioResource {
	
	@Autowired
	private DiaTemHorarioService diaTemHorarioService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<DiaTemHorario>> findAll() {
		List<DiaTemHorario> obj = diaTemHorarioService.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<DiaTemHorario> findById(@PathVariable Integer id) {
		DiaTemHorario obj = diaTemHorarioService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody DiaTemHorarioNewDTO objDTO) {
		DiaTemHorario obj = diaTemHorarioService.fromDTO(objDTO);
		obj = diaTemHorarioService.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody DiaTemHorarioDTO objDTO) {
		DiaTemHorario obj = diaTemHorarioService.fromDTO(objDTO);
		obj.setId(id);
		obj = diaTemHorarioService.update(obj);
		return ResponseEntity.ok().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		diaTemHorarioService.delete(id);
		return ResponseEntity.ok().build();
	}
}
