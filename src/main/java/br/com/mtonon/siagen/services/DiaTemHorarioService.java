package br.com.mtonon.siagen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.DiaTemHorario;
import br.com.mtonon.siagen.repositories.DiaTemHorarioRepository;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class DiaTemHorarioService {
	
	@Autowired
	private DiaTemHorarioRepository diaTemHorarioRepository;
	
	public List<DiaTemHorario> listar() {
		List<DiaTemHorario> obj = diaTemHorarioRepository.findAll();
		return obj;
	}
	
	
	public DiaTemHorario buscar(Integer id) {
		Optional<DiaTemHorario> obj = diaTemHorarioRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + DiaTemHorario.class.getName()));
	}

}
