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

import br.com.mtonon.siagen.domain.TipoServico;
import br.com.mtonon.siagen.dto.TipoServicoDTO;
import br.com.mtonon.siagen.services.TipoServicoService;

@RestController
@RequestMapping(value = "/tipos/servicos")
public class TipoServicoResource {
	
	@Autowired
	private TipoServicoService tipoServicoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<TipoServicoDTO>> findAll() {
		List<TipoServico> list = tipoServicoService.findAll();
		List<TipoServicoDTO> listDTO = list.stream().map(obj -> new TipoServicoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable Integer id) {
		TipoServico obj = tipoServicoService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody TipoServico obj) {
		obj = tipoServicoService.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody TipoServico obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = tipoServicoService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		tipoServicoService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
