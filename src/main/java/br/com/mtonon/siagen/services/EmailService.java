package br.com.mtonon.siagen.services;

import org.springframework.mail.SimpleMailMessage;

import br.com.mtonon.siagen.domain.Agendamento;
import br.com.mtonon.siagen.domain.Paciente;

public interface EmailService {
	
	void sendSchedulingConfirmationEmail(Agendamento obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Paciente paciente, String newPass);


}
