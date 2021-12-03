package br.com.mtonon.siagen.services;

import java.time.LocalDateTime;
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
import br.com.mtonon.siagen.domain.UnidadeSaude;
import br.com.mtonon.siagen.dto.UnidadeSaudeDTO;
import br.com.mtonon.siagen.dto.UnidadeSaudeNewDTO;
import br.com.mtonon.siagen.repositories.DiaSemanaRepository;
import br.com.mtonon.siagen.repositories.EnderecoUnidadeSaudeRepository;
import br.com.mtonon.siagen.repositories.EspecialidadeRepository;
import br.com.mtonon.siagen.repositories.UnidadeSaudeRepository;
import br.com.mtonon.siagen.services.exceptions.DataIntegrityException;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class UnidadeSaudeService {

	@Autowired
	private UnidadeSaudeRepository unidadeSaudeRepository;
	
	@Autowired
	private EspecialidadeRepository especialidadeRepository;
	
	@Autowired
	private EnderecoUnidadeSaudeRepository enderecoUnidadeSaudeRepository;
	
	@Autowired
	private DiaSemanaRepository diaSemanaRepository;

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
		//especialidadeRepository.saveAll(obj.getEspecialidades());
		enderecoUnidadeSaudeRepository.saveAll(obj.getEnderecos());
		//diaSemanaRepository.saveAll(obj.getDiasFuncionamento());
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

		/*
		Especialidade especialidade1 = new Especialidade(objDTO.getEspecialidade1(), null);
		especialidade1.getUnidadesSaude().add(unidadeSaude);
		unidadeSaude.getEspecialidades().add(especialidade1);
		

		if (objDTO.getEspecialidade2() != null) {
			Especialidade especialidade2 = new Especialidade(objDTO.getEspecialidade2(), null);
			unidadeSaude.getEspecialidades().add(especialidade2);
			especialidade2.getUnidadesSaude().add(unidadeSaude);
		}
		if (objDTO.getEspecialidade3() != null) {
			Especialidade especialidade3 = new Especialidade(objDTO.getEspecialidade3(), null);
			unidadeSaude.getEspecialidades().add(especialidade3);
			especialidade3.getUnidadesSaude().add(unidadeSaude);
		}
		if (objDTO.getEspecialidade4() != null) {
			Especialidade especialidade4 = new Especialidade(objDTO.getEspecialidade4(), null);
			unidadeSaude.getEspecialidades().add(especialidade4);
			especialidade4.getUnidadesSaude().add(unidadeSaude);
		}
		*/ 

		Cidade cidade = new Cidade(objDTO.getCidadeId(), null, null, null, null);

		EnderecoUnidadeSaude endereco = new EnderecoUnidadeSaude(null, objDTO.getLogradouro(), objDTO.getNumero(),
				objDTO.getComplemento(), objDTO.getBairro(), objDTO.getCep(), cidade, unidadeSaude);

		unidadeSaude.getEnderecos().add(endereco);
		endereco.setUnidadeSaude(unidadeSaude);

		/*
		DiaSemana diaFuncionamento1 = new DiaSemana(objDTO.getDiaFuncionamento1(), null, false, null);
		unidadeSaude.getDiasFuncionamento().add(diaFuncionamento1);
		diaFuncionamento1.getUnidadesSaude().add(unidadeSaude);

		if (objDTO.getDiaFuncionamento2() != null) {
			DiaSemana diaFuncionamento2 = new DiaSemana(objDTO.getDiaFuncionamento2(), null, false, null);
			unidadeSaude.getDiasFuncionamento().add(diaFuncionamento2);
			diaFuncionamento2.getUnidadesSaude().add(unidadeSaude);
		}
		if (objDTO.getDiaFuncionamento3() != null) {
			DiaSemana diaFuncionamento3 = new DiaSemana(objDTO.getDiaFuncionamento3(), null, false, null);
			unidadeSaude.getDiasFuncionamento().add(diaFuncionamento3);
			diaFuncionamento3.getUnidadesSaude().add(unidadeSaude);
		}
		if (objDTO.getDiaFuncionamento4() != null) {
			DiaSemana diaFuncionamento4 = new DiaSemana(objDTO.getDiaFuncionamento4(), null, false, null);
			unidadeSaude.getDiasFuncionamento().add(diaFuncionamento4);
			diaFuncionamento4.getUnidadesSaude().add(unidadeSaude);
		}
		if (objDTO.getDiaFuncionamento5() != null) {
			DiaSemana diaFuncionamento5 = new DiaSemana(objDTO.getDiaFuncionamento5(), null, false, null);
			unidadeSaude.getDiasFuncionamento().add(diaFuncionamento5);
			diaFuncionamento5.getUnidadesSaude().add(unidadeSaude);
		}
		if (objDTO.getDiaFuncionamento6() != null) {
			DiaSemana diaFuncionamento6 = new DiaSemana(objDTO.getDiaFuncionamento6(), null, false, null);
			unidadeSaude.getDiasFuncionamento().add(diaFuncionamento6);
			diaFuncionamento6.getUnidadesSaude().add(unidadeSaude);
		}
		if (objDTO.getDiaFuncionamento7() != null) {
			DiaSemana diaFuncionamento7 = new DiaSemana(objDTO.getDiaFuncionamento7(), null, false, null);
			unidadeSaude.getDiasFuncionamento().add(diaFuncionamento7);
			diaFuncionamento7.getUnidadesSaude().add(unidadeSaude);
		}
		*/

		
		return unidadeSaude;
	}

}
