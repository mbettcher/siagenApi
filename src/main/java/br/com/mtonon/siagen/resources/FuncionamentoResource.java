package br.com.mtonon.siagen.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mtonon.siagen.domain.Funcionamento;
import br.com.mtonon.siagen.services.FuncionamentoService;

@RestController
@RequestMapping(value = "/funcionamentos")
public class FuncionamentoResource {
	
	@Autowired
	private FuncionamentoService funcionamentoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listar() {
		List<Funcionamento> obj = funcionamentoService.listar();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable Integer id) {
		Funcionamento obj = funcionamentoService.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

}
