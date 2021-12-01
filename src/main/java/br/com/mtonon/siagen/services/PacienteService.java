package br.com.mtonon.siagen.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mtonon.siagen.domain.Cidade;
import br.com.mtonon.siagen.domain.Endereco;
import br.com.mtonon.siagen.domain.Paciente;
import br.com.mtonon.siagen.domain.enums.Emissor;
import br.com.mtonon.siagen.domain.enums.EstadoCivil;
import br.com.mtonon.siagen.domain.enums.Etnia;
import br.com.mtonon.siagen.domain.enums.Sexo;
import br.com.mtonon.siagen.domain.enums.Status;
import br.com.mtonon.siagen.dto.PacienteDTO;
import br.com.mtonon.siagen.dto.PacienteNewDTO;
import br.com.mtonon.siagen.repositories.PacienteRepository;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;

	public Paciente findById(Integer id) {
		Optional<Paciente> obj = pacienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado. Id " + id + ", Tipo: " + Paciente.class.getName()));
	}

	public List<Paciente> findAll() {
		List<Paciente> lista = pacienteRepository.findAll();
		return lista;
	}

	@Transactional
	public Paciente save(Paciente obj) {
		obj.setId(null);
		return pacienteRepository.save(obj);
	}

	public Paciente fromDTO(PacienteDTO objDTO) {

		Paciente paciente = new Paciente(objDTO.getId(), objDTO.getNome(), objDTO.getCpf(), objDTO.getRg(),
				Emissor.toEnum(objDTO.getEmissor()), objDTO.getCartaoSus(), objDTO.getDataNascimento(),
				Sexo.toEnum(objDTO.getSexo()), EstadoCivil.toEnum(objDTO.getEstadoCivil()), objDTO.getEmail(), null,
				LocalDateTime.now(), Status.toEnum(objDTO.getStatus()), objDTO.getIpAddrAlteracao(),
				Etnia.toEnum(objDTO.getEtnia()));

		return paciente;
	}

	public Paciente fromDTO(PacienteNewDTO objDTO) {

		Paciente paciente = new Paciente(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getRg(),
				Emissor.toEnum(objDTO.getEmissor()), objDTO.getCartaoSus(), objDTO.getDataNascimento(),
				Sexo.toEnum(objDTO.getSexo()), EstadoCivil.toEnum(objDTO.getEstadoCivil()), objDTO.getEmail(),
				LocalDateTime.now(), null, Status.toEnum(objDTO.getStatus()), objDTO.getIpAddrAlteracao(),
				Etnia.toEnum(objDTO.getEtnia()));

		Cidade cidade = new Cidade(objDTO.getCidadeId(), null, null, null, null);

		Endereco endereco = new Endereco(null, objDTO.getLogradouro(), objDTO.getNumero(), objDTO.getComplemento(),
				objDTO.getBairro(), objDTO.getCep(), paciente, cidade);

		paciente.getTelefones().add(objDTO.getTelefone1());

		if (objDTO.getTelefone2() != null) {
			paciente.getTelefones().add(objDTO.getTelefone2());
		}
		if (objDTO.getTelefone3() != null) {
			paciente.getTelefones().add(objDTO.getTelefone3());
		}

		paciente.getEnderecos().add(endereco);

		return paciente;
	}

}
