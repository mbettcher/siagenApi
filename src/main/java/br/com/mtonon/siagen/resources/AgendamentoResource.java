package br.com.mtonon.siagen.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mtonon.siagen.domain.Agendamento;
import br.com.mtonon.siagen.dto.AgendamentoDTO;
import br.com.mtonon.siagen.services.AgendamentoService;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoResource {

	@Autowired
	private AgendamentoService agendamentoService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AgendamentoDTO>> listar() {
		List<Agendamento> list = agendamentoService.findAll();
		List<AgendamentoDTO> listDTO = list.stream().map(obj -> new AgendamentoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Agendamento> buscar(@PathVariable Integer id) {
		Agendamento obj = agendamentoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
