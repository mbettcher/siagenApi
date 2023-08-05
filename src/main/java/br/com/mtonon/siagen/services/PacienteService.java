package br.com.mtonon.siagen.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mtonon.siagen.domain.Cidade;
import br.com.mtonon.siagen.domain.Endereco;
import br.com.mtonon.siagen.domain.Paciente;
import br.com.mtonon.siagen.domain.enums.Emissor;
import br.com.mtonon.siagen.domain.enums.EstadoCivil;
import br.com.mtonon.siagen.domain.enums.Etnia;
import br.com.mtonon.siagen.domain.enums.Perfil;
import br.com.mtonon.siagen.domain.enums.Sexo;
import br.com.mtonon.siagen.domain.enums.Status;
import br.com.mtonon.siagen.dto.PacienteDTO;
import br.com.mtonon.siagen.dto.PacienteNewDTO;
import br.com.mtonon.siagen.repositories.EnderecoRepository;
import br.com.mtonon.siagen.repositories.PacienteRepository;
import br.com.mtonon.siagen.security.UserSS;
import br.com.mtonon.siagen.services.exceptions.AuthorizationException;
import br.com.mtonon.siagen.services.exceptions.DataIntegrityException;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class PacienteService {

	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public Paciente findById(Integer id) {
		
		UserSS user = UserService.authenticated();
		
		if(user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado!");
		}
		
		Optional<Paciente> obj = pacienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado. Id " + id + ", Tipo: " + Paciente.class.getName()));
	}

	public List<Paciente> findAll() {
		List<Paciente> lista = pacienteRepository.findAll();
		return lista;
	}
	
	public Paciente findByCpf(String cpf) {
		UserSS user = UserService.authenticated();
		if(user == null || !user.hasRole(Perfil.ADMIN) && !cpf.equals(user.getUsername())) {
			throw new AuthorizationException("Acesso negado!");
		}
		
		Paciente obj = pacienteRepository.findByCpf(cpf);
		if(obj == null) {
			throw new ObjectNotFoundException("Usuário não localizado! CPF: " + user.getUsername());
		}
		
		return obj;
		
	}
	
	public Page<Paciente> findPage(Integer page, Integer linesPerPage, String direction, String orderBy){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return pacienteRepository.findAll(pageRequest);
	}

	@Transactional
	public Paciente save(Paciente obj) {
		obj.setId(null);
		obj = pacienteRepository.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			pacienteRepository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					"Não é possível excluir um Paciente que esteja sendo usado por outra tabela!"
					);
		}
		
	}
	
	public Paciente update(Paciente obj) {
		Paciente newObj = findById(obj.getId());
		updateData(newObj, obj);
		return pacienteRepository.save(newObj);
	}
	
	private void updateData(Paciente newObj, Paciente obj) {
		newObj.setNome(obj.getNome());
		newObj.setCartaoSus(obj.getCartaoSus());
		newObj.setDataNascimento(obj.getDataNascimento());
		newObj.setSexo(obj.getSexo());
		newObj.setEstadoCivil(obj.getEstadoCivil());
		newObj.setEmail(obj.getEmail());
		newObj.setDataAlteracao(obj.getDataAlteracao());
		newObj.setStatus(obj.getStatus());
		newObj.setIpAddrAlteracao(obj.getIpAddrAlteracao());
		newObj.setEtnia(obj.getEtnia());
	}

	public Paciente fromDTO(PacienteDTO objDTO) {
		Paciente paciente = new Paciente(objDTO.getId(), objDTO.getNome(), null, null,
				null, objDTO.getCartaoSus(), objDTO.getDataNascimento(),
				Sexo.toEnum(objDTO.getSexo()), EstadoCivil.toEnum(objDTO.getEstadoCivil()), objDTO.getEmail(), null,
				LocalDateTime.now(), Status.toEnum(objDTO.getStatus()), null, Etnia.toEnum(objDTO.getEtnia()), null);
		return paciente;
	}

	public Paciente fromDTO(PacienteNewDTO objDTO) {
		Paciente paciente = new Paciente(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getRg(),
				Emissor.toEnum(objDTO.getEmissor()), objDTO.getCartaoSus(), objDTO.getDataNascimento(),
				Sexo.toEnum(objDTO.getSexo()), EstadoCivil.toEnum(objDTO.getEstadoCivil()), objDTO.getEmail(),
				LocalDateTime.now(), null, Status.toEnum(objDTO.getStatus()), null,
				Etnia.toEnum(objDTO.getEtnia()), pe.encode(objDTO.getSenha()));

		Cidade cidade = new Cidade(objDTO.getCidadeId(), null, null, null, null);

		Endereco endereco = new Endereco(null, objDTO.getLogradouro(), objDTO.getNumero(), objDTO.getComplemento(),
				objDTO.getBairro(), objDTO.getCep(), paciente, cidade);
		
		paciente.getEnderecos().add(endereco);

		paciente.getTelefones().add(objDTO.getTelefone1());

		if (objDTO.getTelefone2() != null) {
			paciente.getTelefones().add(objDTO.getTelefone2());
		}
		if (objDTO.getTelefone3() != null) {
			paciente.getTelefones().add(objDTO.getTelefone3());
		}
		return paciente;
	}
	
}
