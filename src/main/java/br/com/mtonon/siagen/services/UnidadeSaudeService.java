package br.com.mtonon.siagen.services;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mtonon.siagen.domain.DiaSemana;
import br.com.mtonon.siagen.domain.EnderecoUnidadeSaude;
import br.com.mtonon.siagen.domain.Especialidade;
import br.com.mtonon.siagen.domain.Servico;
import br.com.mtonon.siagen.domain.UnidadeSaude;
import br.com.mtonon.siagen.dto.UnidadeSaudeDTO;
import br.com.mtonon.siagen.dto.UnidadeSaudeNewDTO;
import br.com.mtonon.siagen.repositories.EnderecoUnidadeSaudeRepository;
import br.com.mtonon.siagen.repositories.EspecialidadeRepository;
import br.com.mtonon.siagen.repositories.ServicoRepository;
import br.com.mtonon.siagen.repositories.UnidadeSaudeRepository;
import br.com.mtonon.siagen.services.exceptions.DataIntegrityException;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class UnidadeSaudeService {

	@Autowired
	private UnidadeSaudeRepository unidadeSaudeRepository;

	@Autowired
	private EnderecoUnidadeSaudeRepository enderecoUnidadeSaudeRepository;

	@Autowired
	private EspecialidadeRepository especialidadeRepository;

	@Autowired
	private ServicoRepository servicoRepository;

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
		return unidadeSaudeRepository.save(obj);
	}

	@Transactional
	public UnidadeSaude update(UnidadeSaude obj) {
		UnidadeSaude newObj = findById(obj.getId());
		updateData(newObj, obj);
		enderecoUnidadeSaudeRepository.saveAll(obj.getEnderecos());
		servicoRepository.saveAll(obj.getServicos());
		especialidadeRepository.saveAll(obj.getEspecialidades());
		return unidadeSaudeRepository.save(newObj);
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

	private void updateData(UnidadeSaude newObj, UnidadeSaude obj) {
		newObj.setNome(obj.getNome());
		newObj.setAtivo(obj.getAtivo());
		newObj.setTelefones(obj.getTelefones());
		newObj.setEnderecos(obj.getEnderecos());
		newObj.setEspecialidades(obj.getEspecialidades());
		newObj.setServicos(obj.getServicos());
		newObj.setDataAlteracao(obj.getDataAlteracao());
		newObj.setDiasFuncionamento(obj.getDiasFuncionamento());
	}

	public UnidadeSaude fromDTO(UnidadeSaudeDTO objDTO) {

		UnidadeSaude usa = new UnidadeSaude(objDTO.getId(), objDTO.getNome(), null, LocalDateTime.now(),
				objDTO.getAtivo());
		usa.setTelefones(objDTO.getTelefones());

		for (EnderecoUnidadeSaude endereco : objDTO.getEnderecos()) {
			endereco.setUnidadeSaude(usa);
			usa.getEnderecos().add(endereco);
		}

		for (Especialidade especialidade : objDTO.getEspecialidades()) {
			especialidade.setUnidadesSaude(Arrays.asList(usa));
			usa.getEspecialidades().add(especialidade);
		}

		for (Servico servico : objDTO.getServicos()) {
			servico.setUnidadesSaude(Arrays.asList(usa));
			usa.getServicos().add(servico);
		}

		for (DiaSemana diaSemana : objDTO.getDiasFuncionamento()) {
			diaSemana.setUnidadesSaude(Arrays.asList(usa));
			usa.getDiasFuncionamento().add(diaSemana);
		}
		return usa;
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

		for (Especialidade especialidade : objDTO.getEspecialidades()) {
			especialidade.setUnidadesSaude(Arrays.asList(unidadeSaude));
			unidadeSaude.getEspecialidades().add(especialidade);
		}

		for (EnderecoUnidadeSaude endereco : objDTO.getEnderecos()) {
			endereco.setUnidadeSaude(unidadeSaude);
			unidadeSaude.getEnderecos().add(endereco);
		}

		for (Servico servico : objDTO.getServicos()) {
			servico.setUnidadesSaude(Arrays.asList(unidadeSaude));
			unidadeSaude.getServicos().add(servico);
		}

		for (DiaSemana diaSemana : objDTO.getDiasFuncionamento()) {
			diaSemana.setUnidadesSaude(Arrays.asList(unidadeSaude));
			unidadeSaude.getDiasFuncionamento().add(diaSemana);
		}
		return unidadeSaude;
	}
}
