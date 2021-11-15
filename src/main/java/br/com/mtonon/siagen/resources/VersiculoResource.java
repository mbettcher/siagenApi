package br.com.mtonon.siagen.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.mtonon.siagen.domain.Versiculo;
import br.com.mtonon.siagen.dto.VersiculoDTO;
import br.com.mtonon.siagen.services.VersiculoService;

@RestController
@RequestMapping(value = "/versiculos")
public class VersiculoResource {
	
	@Autowired
	private VersiculoService versiculoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listar() {
		List<Versiculo> obj = versiculoService.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable Integer id) {
		Versiculo obj = versiculoService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<VersiculoDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "livro") String orderBy){
		Page<Versiculo> list = versiculoService.findPage(page, linesPerPage, direction, orderBy);
		Page<VersiculoDTO> listDTO = list.map(obj -> new VersiculoDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody @Valid VersiculoDTO objDTO) {
		Versiculo obj = versiculoService.fromDTO(objDTO);
		obj = versiculoService.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody @Valid VersiculoDTO objDTO, @PathVariable Integer id) {
		Versiculo obj = versiculoService.fromDTO(objDTO);
		obj.setId(id);
		obj = versiculoService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		versiculoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
