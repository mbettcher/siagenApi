package br.com.mtonon.siagen.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mtonon.siagen.domain.HistoricoPaciente;
import br.com.mtonon.siagen.services.HistoricoPacienteService;

@RestController
@RequestMapping(value = "/historicos/pacientes")
public class HistoricoPacienteResource {

	@Autowired
	private HistoricoPacienteService historicoPacienteService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listar() {
		List<HistoricoPaciente> obj = historicoPacienteService.listar();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable Integer id) {
		HistoricoPaciente obj = historicoPacienteService.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
