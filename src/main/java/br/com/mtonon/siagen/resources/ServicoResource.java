package br.com.mtonon.siagen.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.mtonon.siagen.domain.Servico;
import br.com.mtonon.siagen.dto.ServicoDTO;
import br.com.mtonon.siagen.dto.ServicoNewDTO;
import br.com.mtonon.siagen.services.ServicoService;

@RestController
@RequestMapping(value = "/servicos")
public class ServicoResource {

	@Autowired
	private ServicoService servicoService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Servico>> findAll() {
		List<Servico> obj = servicoService.findAll();
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Servico> findById(@PathVariable Integer id) {
		Servico obj = servicoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('GERENTE') or hasRole('ANALISTA')")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Servico> save(@RequestBody ServicoNewDTO objDTO) {
		Servico obj = servicoService.fromDTO(objDTO);
		obj.setId(null);
		obj = servicoService.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('GERENTE') or hasRole('ANALISTA')")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody ServicoDTO objDTO, @PathVariable Integer id) {
		Servico obj = servicoService.fromDTO(objDTO);
		obj.setId(id);
		obj = servicoService.update(obj);
		return ResponseEntity.ok().build();
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('GERENTE') or hasRole('ANALISTA')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		servicoService.delete(id);
		return ResponseEntity.ok().build();
	}

}
