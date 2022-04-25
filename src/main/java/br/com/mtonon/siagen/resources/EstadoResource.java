package br.com.mtonon.siagen.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.mtonon.siagen.domain.Cidade;
import br.com.mtonon.siagen.domain.Estado;
import br.com.mtonon.siagen.dto.CidadeDTO;
import br.com.mtonon.siagen.dto.EstadoDTO;
import br.com.mtonon.siagen.services.CidadeService;
import br.com.mtonon.siagen.services.EstadoService;

@RestController
@RequestMapping(value = "/estados")
public class EstadoResource {
	
	@Autowired
	private EstadoService estadoService;
	
	@Autowired
	private CidadeService cidadeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<EstadoDTO>> findAll() {
		List<Estado> list = estadoService.findAll();
		List<EstadoDTO> listDTO = list.stream().map(obj -> new EstadoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value = "/{estadoId}/cidades", method = RequestMethod.GET)
	public ResponseEntity<List<CidadeDTO>> findCidades(@PathVariable Integer estadoId){
		List<Cidade> list = cidadeService.findByEstado(estadoId);
		List<CidadeDTO> listDTO = list.stream().map(obj -> new CidadeDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Estado> buscar(@PathVariable Integer id) {
		Estado obj = estadoService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('GERENTE') or hasRole('ANALISTA')")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@Valid @RequestBody EstadoDTO objDTO) {
		Estado obj = estadoService.fromDTO(objDTO);
		obj = estadoService.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('GERENTE') or hasRole('ANALISTA')")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody EstadoDTO objDTO, @PathVariable Integer id) {
		Estado obj = estadoService.fromDTO(objDTO);
		obj.setId(id);
		obj = estadoService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('GERENTE') or hasRole('ANALISTA')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		estadoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<EstadoDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction, 
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy){
		Page<Estado> list = estadoService.findPage(page, linesPerPage, direction, orderBy);
		Page<EstadoDTO> listDTO = list.map(obj -> new EstadoDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}

}
