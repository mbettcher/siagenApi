package br.com.mtonon.siagen.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
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

import br.com.mtonon.siagen.domain.Paciente;
import br.com.mtonon.siagen.dto.PacienteDTO;
import br.com.mtonon.siagen.dto.PacienteNewDTO;
import br.com.mtonon.siagen.services.PacienteService;
import br.com.mtonon.siagen.utils.HttpUtils;

@RestController
@RequestMapping(value = "/pacientes")
public class PacienteResource {
	
	@Autowired
	private PacienteService pacienteService;
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('GERENTE') or hasRole('ANALISTA')")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PacienteDTO>> findAll() {
		List<Paciente> list = pacienteService.findAll();
		List<PacienteDTO> listDTO = list.stream().map(obj -> new PacienteDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('GERENTE') or hasRole('ANALISTA')")
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<PacienteDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy) {
		Page<Paciente> list = pacienteService.findPage(page, linesPerPage, direction, orderBy);
		Page<PacienteDTO> listDTO = list.map(obj -> new PacienteDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Paciente> findById(@PathVariable Integer id) {
		Paciente obj = pacienteService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Paciente> save(@Valid @RequestBody PacienteNewDTO objDTO, HttpServletRequest request) {
		Paciente obj = pacienteService.fromDTO(objDTO);
		obj.setIpAddrAlteracao(HttpUtils.getRequestIP(request));
		obj = pacienteService.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody PacienteDTO objDTO, HttpServletRequest request) {
		Paciente obj = pacienteService.fromDTO(objDTO);
		obj.setId(id);
		obj.setIpAddrAlteracao(HttpUtils.getRequestIP(request));
		obj = pacienteService.update(obj);
		return ResponseEntity.ok().build();
	}
	
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('GERENTE')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		pacienteService.delete(id);
		return ResponseEntity.ok().build();
	}

}
