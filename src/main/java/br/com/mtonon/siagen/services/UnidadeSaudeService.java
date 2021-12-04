package br.com.mtonon.siagen.services;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mtonon.siagen.domain.Cidade;
import br.com.mtonon.siagen.domain.DiaSemana;
import br.com.mtonon.siagen.domain.EnderecoUnidadeSaude;
import br.com.mtonon.siagen.domain.Especialidade;
import br.com.mtonon.siagen.domain.Servico;
import br.com.mtonon.siagen.domain.UnidadeSaude;
import br.com.mtonon.siagen.dto.UnidadeSaudeDTO;
import br.com.mtonon.siagen.dto.UnidadeSaudeNewDTO;
import br.com.mtonon.siagen.repositories.EnderecoUnidadeSaudeRepository;
import br.com.mtonon.siagen.repositories.UnidadeSaudeRepository;
import br.com.mtonon.siagen.services.exceptions.DataIntegrityException;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class UnidadeSaudeService {

	@Autowired
	private UnidadeSaudeRepository unidadeSaudeRepository;

	@Autowired
	private EnderecoUnidadeSaudeRepository enderecoUnidadeSaudeRepository;


	public UnidadeSaude findById(Integer id) {
		Optional<UnidadeSaude> obj = unidadeSaudeRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + UnidadeSaude.class.getName()));
	}

	public List<UnidadeSaude> findAll() {
		List<UnidadeSaude> lista = unidadeSaudeRepository.findAll();
		return lista;
	}

	@Transactional
	public UnidadeSaude save(UnidadeSaude obj) {
		obj.setId(null);
		enderecoUnidadeSaudeRepository.saveAll(obj.getEnderecos());
		
		for(Especialidade esp : obj.getEspecialidades()) {
			esp.setUnidadesSaude(Arrays.asList(obj));
		}
		
		for(Servico serv : obj.getServicos()) {
			serv.setUnidadesSaude(Arrays.asList(obj));
		}
		
		for(DiaSemana ds : obj.getDiasFuncionamento()) {
			ds.setUnidadesSaude(Arrays.asList(obj));
		}
		
		return unidadeSaudeRepository.save(obj);
	}

	public UnidadeSaude update(UnidadeSaude obj) {
		findById(obj.getId());
		return unidadeSaudeRepository.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			unidadeSaudeRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					"Não é possível excluir uma Unidade de Saúde que esteja sendo usada por outra tabela!");
		}
	}

	public UnidadeSaude fromDTO(UnidadeSaudeDTO objDTO) {
		return new UnidadeSaude(objDTO.getId(), objDTO.getNome(), objDTO.getDataCadastro(), objDTO.getDataAlteracao(),
				objDTO.getAtivo());
	}

	public UnidadeSaude fromDTO(UnidadeSaudeNewDTO objDTO) {

		UnidadeSaude unidadeSaude = new UnidadeSaude(null, objDTO.getNome(), LocalDateTime.now(), null,
				objDTO.getAtivo());

		unidadeSaude.getTelefones().add(objDTO.getTelefone1());

		if (objDTO.getTelefone2() != null) {
			unidadeSaude.getTelefones().add(objDTO.getTelefone2());
		}
		if (objDTO.getTelefone3() != null) {
			unidadeSaude.getTelefones().add(objDTO.getTelefone3());
		}

		Cidade cidade = new Cidade(objDTO.getCidadeId(), null, null, null, null);
		EnderecoUnidadeSaude endereco = new EnderecoUnidadeSaude(null, objDTO.getLogradouro(), objDTO.getNumero(),
				objDTO.getComplemento(), objDTO.getBairro(), objDTO.getCep(), cidade, unidadeSaude);

		unidadeSaude.getEnderecos().add(endereco);
		endereco.setUnidadeSaude(unidadeSaude);
		
		unidadeSaude.setEspecialidades(objDTO.getEspecialidades());
		unidadeSaude.setServicos(objDTO.getServicos());
		unidadeSaude.setDiasFuncionamento(objDTO.getDiasFuncionamento());

		return unidadeSaude;
	}

}
