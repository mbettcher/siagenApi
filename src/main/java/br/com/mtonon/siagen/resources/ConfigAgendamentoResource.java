package br.com.mtonon.siagen.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mtonon.siagen.domain.ConfigAgendamento;
import br.com.mtonon.siagen.services.ConfigAgendamentoService;

@RestController
@RequestMapping("/configuracoes/agendamentos")
public class ConfigAgendamentoResource {
	
	@Autowired
	private ConfigAgendamentoService configAgendamentoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listar() {
		List<ConfigAgendamento> obj = configAgendamentoService.listar();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable Integer id) {
		ConfigAgendamento obj = configAgendamentoService.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

}
