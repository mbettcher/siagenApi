package br.com.mtonon.siagen.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mtonon.siagen.domain.DiaTemHorario;
import br.com.mtonon.siagen.services.DiaTemHorarioService;

@RestController
@RequestMapping(value = "/dias/horarios")
public class DiaTemHorarioResource {
	
	@Autowired
	private DiaTemHorarioService diaTemHorarioService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<DiaTemHorario>> listar() {
		List<DiaTemHorario> obj = diaTemHorarioService.listar();
		return ResponseEntity.ok().body(obj);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<DiaTemHorario> buscar(@PathVariable Integer id) {
		DiaTemHorario obj = diaTemHorarioService.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

}
