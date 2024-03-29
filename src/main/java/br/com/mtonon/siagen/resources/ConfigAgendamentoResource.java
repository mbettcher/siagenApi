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

import br.com.mtonon.siagen.domain.ConfigAgendamento;
import br.com.mtonon.siagen.dto.ConfigAgendamentoDTO;
import br.com.mtonon.siagen.services.ConfigAgendamentoService;

@RestController
@RequestMapping("/configuracoes/agendamentos")
public class ConfigAgendamentoResource {
	
	@Autowired
	private ConfigAgendamentoService configAgendamentoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ConfigAgendamento>> findAll() {
		List<ConfigAgendamento> obj = configAgendamentoService.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ConfigAgendamento> find(@PathVariable Integer id) {
		ConfigAgendamento obj = configAgendamentoService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/page")
	public ResponseEntity<Page<ConfigAgendamentoDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "dataInicio") String orderBy){
		Page<ConfigAgendamento> list = configAgendamentoService.findPage(page, linesPerPage, direction, orderBy);
		Page<ConfigAgendamentoDTO> listDTO = list.map(obj -> new ConfigAgendamentoDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('GERENTE') or hasRole('ANALISTA')")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ConfigAgendamento> save(@RequestBody @Valid ConfigAgendamentoDTO objDTO) {
		ConfigAgendamento obj = configAgendamentoService.fromDTO(objDTO);
		obj = configAgendamentoService.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('GERENTE') or hasRole('ANALISTA')")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody @Valid ConfigAgendamentoDTO objDTO, @PathVariable Integer id) {
		ConfigAgendamento obj = configAgendamentoService.fromDTO(objDTO);
		obj.setId(id);
		obj = configAgendamentoService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('GERENTE') or hasRole('ANALISTA')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		configAgendamentoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
