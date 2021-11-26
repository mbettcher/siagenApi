package br.com.mtonon.siagen.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mtonon.siagen.domain.Agendamento;
import br.com.mtonon.siagen.services.AgendamentoService;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoResource {

	@Autowired
	private AgendamentoService agendamentoService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Agendamento>> listar() {
		List<Agendamento> obj = agendamentoService.listar();
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Agendamento> buscar(@PathVariable Integer id) {
		Agendamento obj = agendamentoService.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

}
