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

import br.com.mtonon.siagen.domain.Funcionamento;
import br.com.mtonon.siagen.dto.FuncionamentoDTO;
import br.com.mtonon.siagen.dto.FuncionamentoNewDTO;
import br.com.mtonon.siagen.services.FuncionamentoService;

@RestController
@RequestMapping(value = "/funcionamentos")
public class FuncionamentoResource {
	
	@Autowired
	private FuncionamentoService funcionamentoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Funcionamento>> listar() {
		List<Funcionamento> obj = funcionamentoService.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Funcionamento> buscar(@PathVariable Integer id) {
		Funcionamento obj = funcionamentoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody FuncionamentoNewDTO objDTO) {
		Funcionamento obj = funcionamentoService.fromDTO(objDTO);
		obj = funcionamentoService.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody FuncionamentoDTO objDTO) {
		Funcionamento obj = funcionamentoService.fromDTO(objDTO);
		obj.setId(id);
		obj = funcionamentoService.update(obj);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		funcionamentoService.delete(id);
		return ResponseEntity.ok().build();
	}
}
