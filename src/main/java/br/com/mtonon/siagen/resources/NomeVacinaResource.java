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

import br.com.mtonon.siagen.domain.NomeVacina;
import br.com.mtonon.siagen.dto.NomeVacinaDTO;
import br.com.mtonon.siagen.services.NomeVacinaService;

@RestController
@RequestMapping(value = "/nomes/vacinas")
public class NomeVacinaResource {
	
	@Autowired
	private NomeVacinaService nomeVacinaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<NomeVacina>> listar() {
		List<NomeVacina> obj = nomeVacinaService.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<NomeVacina> buscar(@PathVariable Integer id) {
		NomeVacina obj = nomeVacinaService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<NomeVacinaDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "nomeVacina") String orderBy){
		Page<NomeVacina> list = nomeVacinaService.findPage(page, linesPerPage, direction, orderBy);
		Page<NomeVacinaDTO> listDTO = list.map(obj -> new NomeVacinaDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('GERENTE') or hasRole('ANALISTA')")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody @Valid NomeVacinaDTO objDTO) {
		NomeVacina obj = nomeVacinaService.fromDTO(objDTO);
		obj = nomeVacinaService.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('GERENTE') or hasRole('ANALISTA')")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody @Valid NomeVacinaDTO objDTO, @PathVariable Integer id) {
		NomeVacina obj = nomeVacinaService.fromDTO(objDTO);
		obj.setId(id);
		obj = nomeVacinaService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('GERENTE') or hasRole('ANALISTA')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		nomeVacinaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
