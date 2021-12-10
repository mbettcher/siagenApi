package br.com.mtonon.siagen.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.mtonon.siagen.domain.Agendamento;
import br.com.mtonon.siagen.dto.AgendamentoDTO;
import br.com.mtonon.siagen.dto.AgendamentoNewDTO;
import br.com.mtonon.siagen.services.AgendamentoService;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoResource {

	@Autowired
	private AgendamentoService agendamentoService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AgendamentoDTO>> findAll() {
		List<Agendamento> list = agendamentoService.findAll();
		List<AgendamentoDTO> listDTO = list.stream().map(obj -> new AgendamentoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Agendamento> findById(@PathVariable Integer id) {
		Agendamento obj = agendamentoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody AgendamentoNewDTO objDTO){
		Agendamento obj = agendamentoService.fromDTO(objDTO);
		obj = agendamentoService.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody AgendamentoDTO objDTO){
		Agendamento obj = agendamentoService.fromDTO(objDTO);
		obj.setId(id);
		obj = agendamentoService.update(obj);
		return ResponseEntity.ok().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		agendamentoService.delete(id);
		return ResponseEntity.ok().build();
	}
}
