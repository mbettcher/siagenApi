package br.com.mtonon.siagen;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.mtonon.siagen.domain.Cidade;
import br.com.mtonon.siagen.domain.Endereco;
import br.com.mtonon.siagen.domain.EnderecoUnidadeSaude;
import br.com.mtonon.siagen.domain.Especialidade;
import br.com.mtonon.siagen.domain.Estado;
import br.com.mtonon.siagen.domain.Paciente;
import br.com.mtonon.siagen.domain.UnidadeSaude;
import br.com.mtonon.siagen.domain.enums.Emissor;
import br.com.mtonon.siagen.domain.enums.EstadoCivil;
import br.com.mtonon.siagen.domain.enums.Etnia;
import br.com.mtonon.siagen.domain.enums.Sexo;
import br.com.mtonon.siagen.domain.enums.Status;
import br.com.mtonon.siagen.repositories.CidadeRepository;
import br.com.mtonon.siagen.repositories.EnderecoRepository;
import br.com.mtonon.siagen.repositories.EnderecoUnidadeSaudeRepository;
import br.com.mtonon.siagen.repositories.EspecialidadeRepository;
import br.com.mtonon.siagen.repositories.EstadoRepository;
import br.com.mtonon.siagen.repositories.PacienteRepository;
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
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private EnderecoUnidadeSaudeRepository enderecoUnidadeSaudeRepository;

	public static void main(String[] args) {
		SpringApplication.run(SiagenApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Estado est1 = new Estado(null, "Espírito Santo");
		Estado est2 = new Estado(null, "Rio de Janeiro");
		
		Cidade c1 = new Cidade(null, "Guarapari", est1);
		Cidade c2 = new Cidade(null, "Rio de Janeiro", est2);
		Cidade c3 = new Cidade(null, "Petrópolis", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
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
		
		EnderecoUnidadeSaude eus1 = new EnderecoUnidadeSaude(null, "Rodovia do Sol", "120", null, "Perocão", "29200000", c1, usa1);
		EnderecoUnidadeSaude eus2 = new EnderecoUnidadeSaude(null, "Rua das Flores", "321", null, "Muquiçaba", "29200000", c1, usa2);
		EnderecoUnidadeSaude eus3 = new EnderecoUnidadeSaude(null, "Rua dos Atletas", "100", "Complexo", "Muquiçaba", "29200000", c1, usa3);
		
		usa1.getEnderecos().addAll(Arrays.asList(eus1));
		usa2.getEnderecos().addAll(Arrays.asList(eus2));
		usa3.getEnderecos().addAll(Arrays.asList(eus3));
		
		especialidadeRepository.saveAll(Arrays.asList(esp1, esp2));
		unidadeSaudeRepository.saveAll(Arrays.asList(usa1, usa2, usa3));
		enderecoUnidadeSaudeRepository.saveAll(Arrays.asList(eus1, eus2, eus3));
		
		
		

		Paciente pac1 = new Paciente(null, "José das Couves", "79709365045", "1052231", Emissor.SSP, 
				"74125873214", LocalDate.of(1978, 4, 12), Sexo.MASCULINO, EstadoCivil.SOLTEIRO, 
				"jose@gmail.com", LocalDateTime.now(), null, Status.ATIVO, "192.168.0.10", Etnia.BRANCO);
		pac1.getTelefones().addAll(Arrays.asList("2733618200", "27999321234"));
		
		Endereco e1 = new Endereco(null, "Avenida Santa Cruz", "123", "Casa", "Santa Mônica", "29220970", pac1, c1);
		Endereco e2 = new Endereco(null, "Rua das Orquídeas", "478", "Apto 504", "Centro", "28220970", pac1, c3);
		
		pac1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		pacienteRepository.saveAll(Arrays.asList(pac1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
	}

}
