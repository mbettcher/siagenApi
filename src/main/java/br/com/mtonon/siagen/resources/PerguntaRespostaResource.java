package br.com.mtonon.siagen.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mtonon.siagen.domain.PerguntaResposta;
import br.com.mtonon.siagen.services.PerguntaRespostaService;

@RestController
@RequestMapping(value = "/perguntas")
public class PerguntaRespostaResource {
	
	@Autowired
	private PerguntaRespostaService perguntaRespostaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listar() {
		List<PerguntaResposta> obj = perguntaRespostaService.listar();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable Integer id) {
		PerguntaResposta obj = perguntaRespostaService.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}
