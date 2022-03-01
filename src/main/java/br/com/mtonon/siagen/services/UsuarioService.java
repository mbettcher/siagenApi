package br.com.mtonon.siagen.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.Usuario;
import br.com.mtonon.siagen.domain.enums.Status;
import br.com.mtonon.siagen.dto.UsuarioDTO;
import br.com.mtonon.siagen.dto.UsuarioNewDTO;
import br.com.mtonon.siagen.repositories.UsuarioRepository;
import br.com.mtonon.siagen.services.exceptions.DataIntegrityException;
import br.com.mtonon.siagen.services.exceptions.ObjectExistsException;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public Usuario findById(Integer id) {
		Optional<Usuario> obj = usuarioRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
	
	public Usuario findByLoginAndSenha(String login, String senha) {
		Optional<Usuario> obj = usuarioRepository.findByLoginAndSenha(login, senha);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Nenhum usuário localizado para o login = " + login + " e senha = " + senha));
	}


	public void existsCpf(String cpf) {
		boolean exist = usuarioRepository.existsByCpf(cpf);
		if(exist) {
			throw new ObjectExistsException("O CPF informado já está cadastrado para um usuário!");
		}
	}
	
	public List<Usuario> findAll() {
		List<Usuario> lista = usuarioRepository.findAll();
		return lista;
	}
	
	public Usuario save(Usuario obj) {
		obj.setId(null);
		return usuarioRepository.save(obj);
	}

	public Usuario update(Usuario obj) {
		Usuario newObj = findById(obj.getId());
		updateData(newObj, obj);
		return usuarioRepository.save(newObj);
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			usuarioRepository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					"Não é possível excluir um usuário que esteja sendo usado por outra tabela!"
					);
		}
	}
	
	public Usuario fromDTO(UsuarioDTO objDTO) {
		return new Usuario(null, objDTO.getNome(), null, objDTO.getLogin(), null, 
				objDTO.getEmail(), objDTO.getDataCadastramento(), Status.toEnum(objDTO.getStatus()), 
				objDTO.isEmailVerificado(), objDTO.getCodigoValidacao(), objDTO.getDataUltimoAcesso(), 
				objDTO.getDataAlteracao());
	}
	
	public Usuario fromDTO(UsuarioNewDTO objDTO) {
		return new Usuario(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getLogin(), pe.encode(objDTO.getSenha()) , 
				objDTO.getEmail(), LocalDateTime.now(), Status.toEnum(objDTO.getStatus()), 
				false, objDTO.getCodigoValidacao(), null, null);
	}
	
	private void updateData(Usuario newObj, Usuario obj) {
		newObj.setNome(obj.getNome());
		newObj.setLogin(obj.getLogin());
		newObj.setEmail(obj.getEmail());
		newObj.setStatus(obj.getStatus());
	}
}
