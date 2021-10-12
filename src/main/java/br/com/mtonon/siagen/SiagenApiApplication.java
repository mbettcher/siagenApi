package br.com.mtonon.siagen;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.mtonon.siagen.domain.Especialidade;
import br.com.mtonon.siagen.repositories.EspecialidadeRepository;

@SpringBootApplication
public class SiagenApiApplication implements CommandLineRunner{
	
	@Autowired
	private EspecialidadeRepository especialidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(SiagenApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Especialidade esp1 = new Especialidade(null, "Atendimento Básico de Saúde");
		Especialidade esp2 = new Especialidade(null, "Clínico Geral");
		Especialidade esp3 = new Especialidade(null, "Imunização Básica (PNI)");
		especialidadeRepository.saveAll(Arrays.asList(esp1, esp2, esp3));
		
	}

}
