package br.com.mtonon.siagen;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.mtonon.siagen.domain.Cidade;
import br.com.mtonon.siagen.domain.Especialidade;
import br.com.mtonon.siagen.domain.Estado;
import br.com.mtonon.siagen.domain.UnidadeSaude;
import br.com.mtonon.siagen.repositories.CidadeRepository;
import br.com.mtonon.siagen.repositories.EspecialidadeRepository;
import br.com.mtonon.siagen.repositories.EstadoRepository;
import br.com.mtonon.siagen.repositories.UnidadeSaudeRepository;

@SpringBootApplication
public class SiagenApiApplication implements CommandLineRunner{
	
	@Autowired
	private EspecialidadeRepository especialidadeRepository;
	
	@Autowired
	private UnidadeSaudeRepository unidadeSaudeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(SiagenApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Especialidade esp1 = new Especialidade(null, "Atendimento Básico de Saúde");
		Especialidade esp2 = new Especialidade(null, "Imunização Básica (PNI)");
		
		UnidadeSaude usa1 = new UnidadeSaude(null, "Unidade de Sáude Normília Cunha", LocalDateTime.now(), null, true);
		UnidadeSaude usa2 = new UnidadeSaude(null, "Centro Municipal de Especialidades", LocalDateTime.now(), null, true);
		UnidadeSaude usa3 = new UnidadeSaude(null, "Complexo Esportivo Maurice Santos", LocalDateTime.now(), null, true);
		
		esp1.getUnidadesSaude().addAll(Arrays.asList(usa1, usa2, usa3));
		esp2.getUnidadesSaude().addAll(Arrays.asList(usa2));
		
		usa1.getEspecialidades().addAll(Arrays.asList(esp1));
		usa2.getEspecialidades().addAll(Arrays.asList(esp1, esp2));
		usa3.getEspecialidades().addAll(Arrays.asList(esp1));
		
		especialidadeRepository.saveAll(Arrays.asList(esp1, esp2));
		unidadeSaudeRepository.saveAll(Arrays.asList(usa1, usa2, usa3));
		
		Estado est1 = new Estado(null, "Espírito Santo");
		Estado est2 = new Estado(null, "Rio de Janeiro");
		
		Cidade c1 = new Cidade(null, "Guarapari", est1);
		Cidade c2 = new Cidade(null, "Rio de Janeiro", est2);
		Cidade c3 = new Cidade(null, "Petrópolis", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));

		
	}

}
