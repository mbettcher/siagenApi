package br.com.mtonon.siagen.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.Paciente;
import br.com.mtonon.siagen.repositories.PacienteRepository;
import br.com.mtonon.siagen.services.exceptions.ObjectNotFoundException;

@Service
public class AuthService {

	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private BCryptPasswordEncoder pe;

	@Autowired
	private EmailService emailService;

	private Random rand = new Random();

	public void sendNewPassword(String email) {

		Paciente paciente = pacienteRepository.findByEmail(email);

		if (paciente == null) {
			throw new ObjectNotFoundException("E-mail não encontrado!");
		}

		String newPass = newPassword();
		paciente.setSenha(pe.encode(newPass));

		pacienteRepository.save(paciente);
		emailService.sendNewPasswordEmail(paciente, newPass);

	}

	private String newPassword() {

		char[] vet = new char[10];

		for (int i = 0; i < 10; i++) {
			vet[i] = randomChar();
		}

		return new String(vet);
	}

	private char randomChar() {

		int opt = rand.nextInt(4);

		if (opt == 0) {
			
			return (char) (rand.nextInt(10) + 48);

		} else if (opt == 1) {
			
			return (char) (rand.nextInt(26) + 65);

		} else if (opt == 2) {

			return (char) (rand.nextInt(26) + 97);
			
		} else {

			return (char) (rand.nextInt(14) + 33);
			
		}
	}

}
