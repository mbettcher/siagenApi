package br.com.mtonon.siagen.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<TipoServico> buscar(@PathVariable Integer id) {
		TipoServico obj = tipoServicoService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@Valid @RequestBody TipoServicoDTO objDTO) {
		TipoServico obj = new TipoServico(objDTO);
		obj = tipoServicoService.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody TipoServicoDTO objDTO, @PathVariable Integer id) {
		TipoServico obj = new TipoServico(objDTO);
		obj.setId(id);
		obj = tipoServicoService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		tipoServicoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<TipoServicoDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "direction", defaultValue = "ASC")String direction, 
			@RequestParam(value = "orderBy", defaultValue = "nome")String orderBy){
		Page<TipoServico> list = tipoServicoService.findPage(page, linesPerPage, direction, orderBy);
		Page<TipoServicoDTO> listDTO = list.map(obj -> new TipoServicoDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}

}
