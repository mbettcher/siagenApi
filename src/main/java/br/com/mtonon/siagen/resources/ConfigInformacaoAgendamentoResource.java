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

import br.com.mtonon.siagen.domain.ConfigInformacaoAgendamento;
import br.com.mtonon.siagen.dto.ConfigInformacaoAgendamentoDTO;
import br.com.mtonon.siagen.services.ConfigInformacaoAgendamentoService;

@RestController
@RequestMapping(value = "/configuracoes/informacoes/agendamentos")
public class ConfigInformacaoAgendamentoResource {

	@Autowired
	private ConfigInformacaoAgendamentoService configInformacaoAgendamentoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ConfigInformacaoAgendamento>> findAll() {
		List<ConfigInformacaoAgendamento> obj = configInformacaoAgendamentoService.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ConfigInformacaoAgendamento> find(@PathVariable Integer id) {
		ConfigInformacaoAgendamento obj = configInformacaoAgendamentoService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<ConfigInformacaoAgendamentoDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy){
		Page<ConfigInformacaoAgendamento> list = configInformacaoAgendamentoService.findPage(page, linesPerPage, direction, orderBy);
		Page<ConfigInformacaoAgendamentoDTO> listDTO = list.map(obj -> new ConfigInformacaoAgendamentoDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('GERENTE') or hasRole('ANALISTA')")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody @Valid ConfigInformacaoAgendamentoDTO objDTO) {
		ConfigInformacaoAgendamento obj = configInformacaoAgendamentoService.fromDTO(objDTO);
		obj = configInformacaoAgendamentoService.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('GERENTE') or hasRole('ANALISTA')")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody @Valid ConfigInformacaoAgendamentoDTO objDTO, @PathVariable Integer id) {
		ConfigInformacaoAgendamento obj = configInformacaoAgendamentoService.fromDTO(objDTO);
		obj.setId(id);
		obj = configInformacaoAgendamentoService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('GERENTE') or hasRole('ANALISTA')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		configInformacaoAgendamentoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
