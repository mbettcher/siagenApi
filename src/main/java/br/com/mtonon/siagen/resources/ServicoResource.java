package br.com.mtonon.siagen.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mtonon.siagen.domain.Servico;
import br.com.mtonon.siagen.dto.ServicoDTO;
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
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody ServicoDTO objDTO, @PathVariable Integer id) {
		Servico obj = servicoService.fromDTO(objDTO);
		obj.setId(id);
		obj = servicoService.update(obj);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		servicoService.delete(id);
		return ResponseEntity.ok().build();
	}

}
