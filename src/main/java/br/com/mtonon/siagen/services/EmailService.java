package br.com.mtonon.siagen.services;

import org.springframework.mail.SimpleMailMessage;

import br.com.mtonon.siagen.domain.Agendamento;

public interface EmailService {
	
	void sendSchedulingConfirmationEmail(Agendamento obj);
	
	void sendEmail(SimpleMailMessage msg);

}
