package br.com.mtonon.siagen.resources;

import java.net.URI;
import java.util.List;

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

import br.com.mtonon.siagen.domain.Dia;
import br.com.mtonon.siagen.dto.DiaDTO;
import br.com.mtonon.siagen.services.DiaService;

@RestController
@RequestMapping(value = "/dias")
public class DiaResource {
	
	@Autowired
	private DiaService diaService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Dia> find(@PathVariable Integer id) {
		Dia obj = diaService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Dia>> findAll() {
		List<Dia> obj = diaService.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<DiaDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "data") String orderBy) {
		Page<Dia> list = diaService.findPage(page, linesPerPage, direction, orderBy);
		Page<DiaDTO> listDTO = list.map(obj -> new DiaDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('GERENTE') or hasRole('ANALISTA')")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody @Valid DiaDTO objDTO){
		Dia obj = diaService.fromDTO(objDTO);
		obj = diaService.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('GERENTE') or hasRole('ANALISTA')")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody @Valid DiaDTO objDTO,@PathVariable Integer id){
		Dia obj = diaService.fromDTO(objDTO);
		obj.setId(id);
		obj = diaService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('GERENTE') or hasRole('ANALISTA')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		diaService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
