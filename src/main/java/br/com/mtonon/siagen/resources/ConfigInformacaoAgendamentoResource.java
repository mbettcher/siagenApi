package br.com.mtonon.siagen.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mtonon.siagen.domain.ConfigInformacaoAgendamento;
import br.com.mtonon.siagen.services.ConfigInformacaoAgendamentoService;

@RestController
@RequestMapping(value = "/configuracoes/informacoes/agendamentos")
public class ConfigInformacaoAgendamentoResource {

	@Autowired
	private ConfigInformacaoAgendamentoService configInformacaoAgendamentoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listar() {
		List<ConfigInformacaoAgendamento> obj = configInformacaoAgendamentoService.listar();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable Integer id) {
		ConfigInformacaoAgendamento obj = configInformacaoAgendamentoService.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}
