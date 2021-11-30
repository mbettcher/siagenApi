package br.com.mtonon.siagen.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mtonon.siagen.domain.Paciente;
import br.com.mtonon.siagen.services.PacienteService;

@RestController
@RequestMapping(value = "/pacientes")
public class PacienteResource {
	
	@Autowired
	private PacienteService pacienteService;
	
	@GetMapping
	public ResponseEntity<List<Paciente>> listar() {
		List<Paciente> obj = pacienteService.listar();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Paciente> buscar(@PathVariable Integer id) {
		Paciente obj = pacienteService.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

}
