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

import br.com.mtonon.siagen.domain.PerguntaResposta;
import br.com.mtonon.siagen.dto.PerguntaRespostaDTO;
import br.com.mtonon.siagen.services.PerguntaRespostaService;

@RestController
@RequestMapping(value = "/perguntas")
public class PerguntaRespostaResource {
	
	@Autowired
	private PerguntaRespostaService perguntaRespostaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<PerguntaResposta> obj = perguntaRespostaService.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		PerguntaResposta obj = perguntaRespostaService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<PerguntaRespostaDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy){
		Page<PerguntaResposta> list = perguntaRespostaService.findPage(page, linesPerPage, direction, orderBy);
		Page<PerguntaRespostaDTO> listDTO =  list.map(obj -> new PerguntaRespostaDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody @Valid PerguntaRespostaDTO objDTO) {
		PerguntaResposta obj = perguntaRespostaService.fromDTO(objDTO);
		obj = perguntaRespostaService.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody @Valid PerguntaRespostaDTO objDTO, @PathVariable Integer id) {
		PerguntaResposta obj = perguntaRespostaService.fromDTO(objDTO);
		obj.setId(id);
		obj = perguntaRespostaService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		perguntaRespostaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
