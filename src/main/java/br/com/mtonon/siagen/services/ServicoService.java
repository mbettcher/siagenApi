package br.com.mtonon.siagen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mtonon.siagen.domain.NomeVacina;
import br.com.mtonon.siagen.domain.Servico;
import br.com.mtonon.siagen.domain.TipoServico;
import br.com.mtonon.siagen.domain.UnidadeSaude;
import br.com.mtonon.siagen.domain.enums.Dose;
import br.com.mtonon.siagen.dto.ServicoDTO;
import br.com.mtonon.siagen.dto.ServicoNewDTO;
import br.com.mtonon.siagen.repositories.ServicoRepository;
import br.com.mtonon.siagen.repositories.UnidadeSaudeRepository;
import br.com.mtonon.siagen.services.exceptions.DataIntegrityException;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class ServicoService {
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private UnidadeSaudeRepository unidadeSaudeRepository;

	
	public List<Servico> findAll() {
		List<Servico> obj = servicoRepository.findAll();
		return obj;
	}
	
	public Servico findById(Integer id) {
		Optional<Servico> obj = servicoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Servico.class.getName()));
	}
	
	@Transactional
	public Servico save(Servico obj) {
		obj.setId(null);
		obj = servicoRepository.save(obj);
		unidadeSaudeRepository.saveAll(obj.getUnidadesSaude());
		return obj;
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
				objDTO.getIdadeMaxima(), objDTO.getObservacoes(), Dose.toEnum(objDTO.getDose()), null, null);
	}
	
	
	public Servico fromDTO(ServicoNewDTO objDTO) {
		
		Servico servico = new Servico(null, objDTO.getDescricao(), objDTO.getTempoExecucao(), objDTO.getIdadeMinima(), 
				objDTO.getIdadeMaxima(), objDTO.getObservacoes(), Dose.toEnum(objDTO.getDose()), null, 
				null);
		
		TipoServico tipoServico = new TipoServico(objDTO.getTipoServicoId(), null);
		NomeVacina nomeVacina = new NomeVacina(objDTO.getNomeVacina(), null, null);
		UnidadeSaude unidadeSaude = new UnidadeSaude(objDTO.getUnidadeSaudeId(), null, null, null, null);
		
		servico.setNomeVacina(nomeVacina);
		servico.setTipoServico(tipoServico);
		servico.getUnidadesSaude().add(unidadeSaude);
		return servico;
	}

	
	private void updateData(Servico newObj, Servico obj) {
		newObj.setDescricao(obj.getDescricao());
		newObj.setTempoExecucao(obj.getTempoExecucao());
		newObj.setIdadeMinima(obj.getIdadeMinima());
		newObj.setIdadeMaxima(obj.getIdadeMaxima());
		newObj.setObservacoes(obj.getObservacoes());
		newObj.setDose(obj.getDose());
	}

}
