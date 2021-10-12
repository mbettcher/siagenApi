package br.com.mtonon.siagen.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mtonon.siagen.domain.Especialidade;

@RestController
@RequestMapping(value = "/especialidades")
public class EspecialidadeResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Especialidade> listar() {
		
		Especialidade esp1 = new Especialidade(Long.valueOf(1), "Atendimento Básico");
		Especialidade esp2 = new Especialidade(Long.valueOf(2), "Vacinação Básica");
		List<Especialidade> lista = new ArrayList<>();
		lista.add(esp1);
		lista.add(esp2);
		return lista;
	}

}
