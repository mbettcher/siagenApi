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

import br.com.mtonon.siagen.domain.Horario;
import br.com.mtonon.siagen.dto.HorarioDTO;
import br.com.mtonon.siagen.services.HorarioService;

@RestController
@RequestMapping(value = "/horarios")
public class HorarioResource {

	@Autowired
	private HorarioService horarioService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Horario>> findAll() {
		List<Horario> obj = horarioService.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Horario> find(@PathVariable Integer id) {
		Horario obj = horarioService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<HorarioDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "hora") String orderBy
			) {
		Page<Horario> list = horarioService.findPage(page, linesPerPage, direction, orderBy);
		Page<HorarioDTO> listDTO = list.map(obj -> new HorarioDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('GERENTE') or hasRole('ANALISTA')")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody @Valid HorarioDTO objDTO) {
		Horario obj = horarioService.fromDTO(objDTO);
		obj = horarioService.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('GERENTE') or hasRole('ANALISTA')")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody @Valid HorarioDTO objDTO, @PathVariable Integer id) {
		Horario obj = horarioService.fromDTO(objDTO);
		obj.setId(id);
		obj = horarioService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('GERENTE') or hasRole('ANALISTA')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		horarioService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
