package br.com.mtonon.siagen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.PerguntaResposta;
import br.com.mtonon.siagen.repositories.PerguntaRespostaRepository;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class PerguntaRespostaService {
	
	@Autowired
	private PerguntaRespostaRepository perguntaRespostaRepository;
	
	public List<PerguntaResposta> listar() {
		List<PerguntaResposta> obj = perguntaRespostaRepository.findAll();
		return obj;
	}
	
	public PerguntaResposta buscar(Integer id) {
		Optional<PerguntaResposta> obj = perguntaRespostaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + PerguntaResposta.class.getName()));
	}

}
