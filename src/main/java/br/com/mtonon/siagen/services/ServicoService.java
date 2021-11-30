package br.com.mtonon.siagen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.Servico;
import br.com.mtonon.siagen.dto.ServicoDTO;
import br.com.mtonon.siagen.repositories.ServicoRepository;
import br.com.mtonon.siagen.services.exceptions.DataIntegrityException;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class ServicoService {
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	public List<Servico> findAll() {
		List<Servico> obj = servicoRepository.findAll();
		return obj;
	}
	
	public Servico findById(Integer id) {
		Optional<Servico> obj = servicoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Servico.class.getName()));
	}
	
	public Servico update(Servico obj) {
		Servico newObj = findById(obj.getId());
		updateData(newObj, obj);
		return servicoRepository.save(newObj);
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			servicoRepository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					"Não é possível excluir um Serviço que esteja sendo usado por outra tabela."
					);
		}
		
	}
	
	public Servico fromDTO(ServicoDTO objDTO) {
		return new Servico(null, objDTO.getDescricao(), objDTO.getTempoExecucao(), objDTO.getIdadeMinima(), 
				objDTO.getIdadeMaxima(), objDTO.getObservacoes(), null, 
				null, null);
	}
	
	private void updateData(Servico newObj, Servico obj) {
		newObj.setDescricao(obj.getDescricao());
		newObj.setTempoExecucao(obj.getTempoExecucao());
		newObj.setIdadeMinima(obj.getIdadeMinima());
		newObj.setIdadeMaxima(obj.getIdadeMaxima());
		newObj.setObservacoes(obj.getObservacoes());
	}

}
