package br.com.mtonon.siagen.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.mtonon.siagen.domain.Perfil;
import br.com.mtonon.siagen.dto.PerfilDTO;
import br.com.mtonon.siagen.services.PerfilService;

@RestController
@RequestMapping(value = "/perfis")
public class PerfilResource {
	
	@Autowired
	private PerfilService perfilService;
	
	@GetMapping
	public ResponseEntity<List<Perfil>> listar() {
		List<Perfil> obj = perfilService.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Perfil> buscar(@PathVariable Integer id) {
		Perfil obj = perfilService.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<PerfilDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "perfil") String orderBy){
		Page<Perfil> list = perfilService.findPage(page, linesPerPage, direction, orderBy);
		Page<PerfilDTO> listDTO = list.map(obj -> new PerfilDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody @Valid PerfilDTO objDTO) {
		Perfil obj = perfilService.fromDTO(objDTO);
		obj = perfilService.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody @Valid PerfilDTO objDTO, @PathVariable Integer id) {
		Perfil obj = perfilService.fromDTO(objDTO);
		obj.setId(id);
		obj = perfilService.update(obj);
		return ResponseEntity.noContent().build();
		}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		perfilService.delete(id);
		return ResponseEntity.noContent().build();
		}
}
