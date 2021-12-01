package br.com.mtonon.siagen.resources;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.mtonon.siagen.domain.Paciente;
import br.com.mtonon.siagen.dto.PacienteNewDTO;
import br.com.mtonon.siagen.services.PacienteService;
import br.com.mtonon.siagen.utils.HttpUtils;

@RestController
@RequestMapping(value = "/pacientes")
public class PacienteResource {
	
	@Autowired
	private PacienteService pacienteService;
	
	@GetMapping
	public ResponseEntity<List<Paciente>> findAll() {
		List<Paciente> obj = pacienteService.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Paciente> findById(@PathVariable Integer id) {
		Paciente obj = pacienteService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Paciente> save(@RequestBody PacienteNewDTO objDTO, HttpServletRequest request) {
		Paciente obj = pacienteService.fromDTO(objDTO);
		obj.setIpAddrAlteracao(HttpUtils.getRequestIP(request));
		obj = pacienteService.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
