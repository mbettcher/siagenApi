package br.com.mtonon.siagen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.PerguntaResposta;
import br.com.mtonon.siagen.dto.PerguntaRespostaDTO;
import br.com.mtonon.siagen.repositories.PerguntaRespostaRepository;
import br.com.mtonon.siagen.services.exceptions.DataIntegrityException;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class PerguntaRespostaService {
	
	@Autowired
	private PerguntaRespostaRepository perguntaRespostaRepository;
	
	public List<PerguntaResposta> findAll() {
		List<PerguntaResposta> obj = perguntaRespostaRepository.findAll();
		return obj;
	}
	
	public PerguntaResposta find(Integer id) {
		Optional<PerguntaResposta> obj = perguntaRespostaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + PerguntaResposta.class.getName()));
	}

	public Page<PerguntaResposta> findPage(Integer page, Integer linesPerPage, String direction, String orderBy){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return perguntaRespostaRepository.findAll(pageRequest);
	}
	
	public PerguntaResposta save(PerguntaResposta obj) {
		obj.setId(null);
		return perguntaRespostaRepository.save(obj);
	}
	
	public PerguntaResposta update(PerguntaResposta obj) {
		find(obj.getId());
		return perguntaRespostaRepository.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			perguntaRespostaRepository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					"Não é possível excluir uma Pergunta Resposta que esteja em uso por outra tabela!"
					);
		}
	}
	
	public PerguntaResposta fromDTO(PerguntaRespostaDTO objDTO) {
		return new PerguntaResposta(objDTO.getId(), objDTO.getPergunta(), objDTO.getResposta());
	}
}
