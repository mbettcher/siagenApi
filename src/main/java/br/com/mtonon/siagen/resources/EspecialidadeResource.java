package br.com.mtonon.siagen.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mtonon.siagen.domain.Especialidade;
import br.com.mtonon.siagen.dto.EspecialidadeDTO;
import br.com.mtonon.siagen.services.EspecialidadeService;

@RestController
@RequestMapping(value = "/especialidades")
public class EspecialidadeResource {
	
	@Autowired
	private EspecialidadeService especialidadeService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable Integer id) {
		Especialidade obj = especialidadeService.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<EspecialidadeDTO>> findAll() {
		List<Especialidade> list = especialidadeService.findAll();
		List<EspecialidadeDTO> listDTO = list.stream().map(obj -> new EspecialidadeDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

}
