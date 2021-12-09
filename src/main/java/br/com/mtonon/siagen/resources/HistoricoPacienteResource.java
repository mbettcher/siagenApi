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

import br.com.mtonon.siagen.domain.HistoricoPaciente;
import br.com.mtonon.siagen.dto.HistoricoPacienteDTO;
import br.com.mtonon.siagen.dto.HistoricoPacienteNewDTO;
import br.com.mtonon.siagen.services.HistoricoPacienteService;

@RestController
@RequestMapping(value = "/historicos/pacientes")
public class HistoricoPacienteResource {

	@Autowired
	private HistoricoPacienteService historicoPacienteService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<HistoricoPaciente>> findAll() {
		List<HistoricoPaciente> obj = historicoPacienteService.findAll();
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<HistoricoPaciente> findById(@PathVariable Integer id) {
		HistoricoPaciente obj = historicoPacienteService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody HistoricoPacienteNewDTO objDTO) {
		HistoricoPaciente obj = historicoPacienteService.fromDTO(objDTO);
		obj = historicoPacienteService.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody HistoricoPacienteDTO objDTO) {
		HistoricoPaciente obj = historicoPacienteService.fromDTO(objDTO);
		obj.setId(id);
		obj = historicoPacienteService.update(obj);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		historicoPacienteService.delete(id);
		return ResponseEntity.ok().build();
	}
}
