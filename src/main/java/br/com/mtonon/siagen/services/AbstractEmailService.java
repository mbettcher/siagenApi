package br.com.mtonon.siagen.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import br.com.mtonon.siagen.domain.Agendamento;

public abstract class AbstractEmailService implements EmailService {
	
	@Value("${default-sender}")
	private String sender;
	
	@Override
	public void sendSchedulingConfirmationEmail(Agendamento obj) {
		
		SimpleMailMessage sm = prepareSimpleMailMessageFromAgendamento(obj);
		sendEmail(sm);
		
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromAgendamento(Agendamento obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getPacienteAgendamento().getEmail());
		sm.setFrom(sender);
		sm.setSubject("Agendamento confirmado! Código: " + obj.getId());
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());
		return sm;
	}

}
