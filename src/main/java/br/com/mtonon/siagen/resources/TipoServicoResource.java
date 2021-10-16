package br.com.mtonon.siagen.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mtonon.siagen.domain.TipoServico;
import br.com.mtonon.siagen.services.TipoServicoService;

@RestController
@RequestMapping(value = "/tipos/servicos")
public class TipoServicoResource {
	
	@Autowired
	private TipoServicoService tipoServicoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listar() {
		List<TipoServico> obj = tipoServicoService.listar();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable Integer id) {
		TipoServico obj = tipoServicoService.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

}
