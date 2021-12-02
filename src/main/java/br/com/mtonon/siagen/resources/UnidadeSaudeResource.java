package br.com.mtonon.siagen.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.mtonon.siagen.domain.UnidadeSaude;
import br.com.mtonon.siagen.dto.UnidadeSaudeDTO;
import br.com.mtonon.siagen.dto.UnidadeSaudeNewDTO;
import br.com.mtonon.siagen.services.UnidadeSaudeService;

@RestController
@RequestMapping(value = "/unidades")
public class UnidadeSaudeResource {
	
	@Autowired
	private UnidadeSaudeService unidadeSaudeService;
	
	@GetMapping
	public ResponseEntity<List<UnidadeSaudeDTO>> listar() {
		List<UnidadeSaude> list = unidadeSaudeService.findAll();
		List<UnidadeSaudeDTO> ListDTO = list.stream().map(obj -> new UnidadeSaudeDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(ListDTO);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UnidadeSaude> buscar(@PathVariable Integer id) {
		UnidadeSaude obj = unidadeSaudeService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	public ResponseEntity<Void> save(UnidadeSaudeNewDTO objDTO) {
		UnidadeSaude obj = unidadeSaudeService.fromDTO(objDTO);
		obj = unidadeSaudeService.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
