package br.com.mtonon.siagen.services;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.mtonon.siagen.domain.Agendamento;
import br.com.mtonon.siagen.domain.Cidade;
import br.com.mtonon.siagen.domain.ConfigAgendamento;
import br.com.mtonon.siagen.domain.ConfigInformacaoAgendamento;
import br.com.mtonon.siagen.domain.Dia;
import br.com.mtonon.siagen.domain.DiaSemana;
import br.com.mtonon.siagen.domain.DiaTemHorario;
import br.com.mtonon.siagen.domain.Endereco;
import br.com.mtonon.siagen.domain.EnderecoUnidadeSaude;
import br.com.mtonon.siagen.domain.Especialidade;
import br.com.mtonon.siagen.domain.Estado;
import br.com.mtonon.siagen.domain.Funcionamento;
import br.com.mtonon.siagen.domain.HistoricoPaciente;
import br.com.mtonon.siagen.domain.Horario;
import br.com.mtonon.siagen.domain.NomeVacina;
import br.com.mtonon.siagen.domain.Paciente;
import br.com.mtonon.siagen.domain.PerguntaResposta;
import br.com.mtonon.siagen.domain.Servico;
import br.com.mtonon.siagen.domain.TipoServico;
import br.com.mtonon.siagen.domain.UnidadeSaude;
import br.com.mtonon.siagen.domain.Versiculo;
import br.com.mtonon.siagen.domain.enums.Dose;
import br.com.mtonon.siagen.domain.enums.Emissor;
import br.com.mtonon.siagen.domain.enums.EstadoCivil;
import br.com.mtonon.siagen.domain.enums.Etnia;
import br.com.mtonon.siagen.domain.enums.Perfil;
import br.com.mtonon.siagen.domain.enums.Sexo;
import br.com.mtonon.siagen.domain.enums.Status;
import br.com.mtonon.siagen.repositories.AgendamentoRepository;
import br.com.mtonon.siagen.repositories.CidadeRepository;
import br.com.mtonon.siagen.repositories.ConfigAgendamentoRepository;
import br.com.mtonon.siagen.repositories.ConfigInformacaoAgendamentoRepository;
import br.com.mtonon.siagen.repositories.DiaRepository;
import br.com.mtonon.siagen.repositories.DiaSemanaRepository;
import br.com.mtonon.siagen.repositories.DiaTemHorarioRepository;
import br.com.mtonon.siagen.repositories.EnderecoRepository;
import br.com.mtonon.siagen.repositories.EnderecoUnidadeSaudeRepository;
import br.com.mtonon.siagen.repositories.EspecialidadeRepository;
import br.com.mtonon.siagen.repositories.EstadoRepository;
import br.com.mtonon.siagen.repositories.FuncionamentoRepository;
import br.com.mtonon.siagen.repositories.HistoricoPacienteRepository;
import br.com.mtonon.siagen.repositories.HorarioRepository;
import br.com.mtonon.siagen.repositories.NomeVacinaRepository;
import br.com.mtonon.siagen.repositories.PacienteRepository;
import br.com.mtonon.siagen.repositories.PerguntaRespostaRepository;
import br.com.mtonon.siagen.repositories.ServicoRepository;
import br.com.mtonon.siagen.repositories.TipoServicoRepository;
import br.com.mtonon.siagen.repositories.UnidadeSaudeRepository;
import br.com.mtonon.siagen.repositories.VersiculoRepository;

@Service
public class DBService {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
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
	
	@Autowired
	private TipoServicoRepository tipoServicoRepository;
	
	@Autowired
	private NomeVacinaRepository nomeVacinaRepository;
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	@Autowired
	private DiaRepository diaRepository;
	
	@Autowired
	private HorarioRepository horarioRepository;
	
	@Autowired
	private DiaTemHorarioRepository diaTemHorarioRepository;
	
	@Autowired
	private PerguntaRespostaRepository perguntaRespostaRepository;
	
	@Autowired
	private VersiculoRepository versiculoRepository;
	
	@Autowired
	private FuncionamentoRepository funcionamentoRepository;
	
	@Autowired
	private DiaSemanaRepository diaSemanaRepository;
	
	@Autowired
	private ConfigAgendamentoRepository configAgendamentoRepository;
	
	@Autowired
	private ConfigInformacaoAgendamentoRepository configInformacaoAgendamentoRepository;
	
	@Autowired
	private HistoricoPacienteRepository historicoPacienteRepository;
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	
	
	public void instantiateTestDatabase() throws ParseException{
		
		Estado est1 = new Estado(null, "Esp??rito Santo");
		Estado est2 = new Estado(null, "Rio de Janeiro");
		
		Cidade c1 = new Cidade(null, "Guarapari", 320240, 3202405, est1);
		Cidade c2 = new Cidade(null, "Rio de Janeiro", 330455, 3304557, est2);
		Cidade c3 = new Cidade(null, "Petr??polis", 330390, 3303906, est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		NomeVacina nva1 = new NomeVacina(null, "Coronavac", "Insituto Butantan");
		TipoServico tse1 = new TipoServico(null, "Vacina????o");
		
		Servico ser1 = new Servico(null, "Vacina????o contra Covid-19", 2, 18, 120, null, Dose.PRIMEIRA, nva1, tse1);
		
		tse1.getServicos().addAll(Arrays.asList(ser1));
		
		nomeVacinaRepository.saveAll(Arrays.asList(nva1));
		tipoServicoRepository.saveAll(Arrays.asList(tse1));
		
		
		Especialidade esp1 = new Especialidade(null, "Atendimento B??sico de Sa??de");
		Especialidade esp2 = new Especialidade(null, "Imuniza????o B??sica (PNI)");
		Especialidade esp3 = new Especialidade(null, "Realiza????o de Curativos");
		Especialidade esp4 = new Especialidade(null, "Realiza????o de Inala????es");
		Especialidade esp5 = new Especialidade(null, "Coleta de Exames Laboratoriais");
		Especialidade esp6 = new Especialidade(null, "Tratamento Odontol??gico");
		Especialidade esp7 = new Especialidade(null, "Fornecimento de Medica????o B??sica");
		Especialidade esp8 = new Especialidade(null, "Encaminhamento para Especialistas");
		Especialidade esp9 = new Especialidade(null, "Acompanhamento Psicol??gico");
		Especialidade esp10 = new Especialidade(null, "Unidade de Sa??de Familiar");
		
		UnidadeSaude usa1 = new UnidadeSaude(null, "Unidade de S??ude Norm??lia Cunha", LocalDateTime.now(), null, true);
		UnidadeSaude usa2 = new UnidadeSaude(null, "Centro Municipal de Especialidades", LocalDateTime.now(), null, true);
		UnidadeSaude usa3 = new UnidadeSaude(null, "Complexo Esportivo Maurice Santos", LocalDateTime.now(), null, true);

		esp1.getUnidadesSaude().addAll(Arrays.asList(usa1, usa2, usa3));
		esp2.getUnidadesSaude().addAll(Arrays.asList(usa2));
		
		usa1.getEspecialidades().addAll(Arrays.asList(esp1));
		usa2.getEspecialidades().addAll(Arrays.asList(esp1, esp2));
		usa3.getEspecialidades().addAll(Arrays.asList(esp1));
		
		EnderecoUnidadeSaude eus1 = new EnderecoUnidadeSaude(null, "Rodovia do Sol", "120", null, "Peroc??o", "29200000", c1, usa1);
		EnderecoUnidadeSaude eus2 = new EnderecoUnidadeSaude(null, "Rua das Flores", "321", null, "Muqui??aba", "29200000", c1, usa2);
		EnderecoUnidadeSaude eus3 = new EnderecoUnidadeSaude(null, "Rua dos Atletas", "100", "Complexo", "Muqui??aba", "29200000", c1, usa3);
		
		usa1.getEnderecos().addAll(Arrays.asList(eus1));
		usa2.getEnderecos().addAll(Arrays.asList(eus2));
		usa3.getEnderecos().addAll(Arrays.asList(eus3));
		
		ser1.getUnidadesSaude().addAll(Arrays.asList(usa1, usa2, usa3));
		
		usa1.getServicos().addAll(Arrays.asList(ser1));
		usa2.getServicos().addAll(Arrays.asList(ser1));
		usa3.getServicos().addAll(Arrays.asList(ser1));
		
		Funcionamento f1 = new Funcionamento(null, LocalTime.of(8, 0), LocalTime.of(16, 0));
		DiaSemana ds1 = new DiaSemana(null, "segunda-feira", true, f1);
		DiaSemana ds2 = new DiaSemana(null, "ter??a-feira", true, f1);
		DiaSemana ds3 = new DiaSemana(null, "quarta-feira", true, f1);
		DiaSemana ds4 = new DiaSemana(null, "quinta-feira", true, f1);
		DiaSemana ds5 = new DiaSemana(null, "sexta-feira", true, f1);
		
		funcionamentoRepository.saveAll(Arrays.asList(f1));
		diaSemanaRepository.saveAll(Arrays.asList(ds1,ds2,ds3,ds4,ds5));
		
		usa1.getDiasFuncionamento().addAll(Arrays.asList(ds1,ds2,ds3,ds4,ds5));
		usa2.getDiasFuncionamento().addAll(Arrays.asList(ds1,ds2,ds3,ds4,ds5));
		usa3.getDiasFuncionamento().addAll(Arrays.asList(ds1,ds2,ds3,ds4));
		
		usa1.getTelefones().addAll(Arrays.asList("2733618200", "2733618201"));
		usa2.getTelefones().addAll(Arrays.asList("2733624512"));
		usa3.getTelefones().addAll(Arrays.asList("2732004210"));
		
		servicoRepository.saveAll(Arrays.asList(ser1));
		especialidadeRepository.saveAll(Arrays.asList(esp1, esp2, esp3, esp4, esp5, esp6, esp7, esp8, esp9, esp10));
		unidadeSaudeRepository.saveAll(Arrays.asList(usa1, usa2, usa3));
		enderecoUnidadeSaudeRepository.saveAll(Arrays.asList(eus1, eus2, eus3));
		
		
		
		Paciente pac1 = new Paciente(null, "Jos?? das Couves", "79709365045", "1052231", Emissor.SSP, 
				"74125873214", LocalDate.of(1978, 4, 12), Sexo.MASCULINO, EstadoCivil.SOLTEIRO, 
				"dalvajavarini@gmail.com", LocalDateTime.now(), null, Status.ATIVO, "192.168.0.10", Etnia.BRANCO, pe.encode("123456"));
		pac1.getTelefones().addAll(Arrays.asList("2733618200", "27999321234"));
		
		Paciente pac2 = new Paciente(null, "Marcelo Tonon Bettcher", "01697339719", "1065523", Emissor.SSP, 
				"00000000000", LocalDate.of(1974, 3, 24), Sexo.MASCULINO, EstadoCivil.CASADO, 
				"mtonon.pmg@gmail.com", LocalDateTime.now(), null, Status.ATIVO, "191.6.43.83", Etnia.BRANCO, pe.encode("123456"));
		pac2.getTelefones().addAll(Arrays.asList("27981499002", "27981517213"));
		pac2.addPerfil(Perfil.ADMIN);
		
		Endereco e1 = new Endereco(null, "Avenida Santa Cruz", "123", "Casa", "Santa M??nica", "29220970", pac1, c1);
		Endereco e2 = new Endereco(null, "Rua das Orqu??deas", "478", "Apto 504", "Centro", "28220970", pac1, c3);
		Endereco e3 = new Endereco(null, "Rua S??o Pedro", "216", "Casa", "Peroc??o", "29220500", pac2, c1);
		
		pac1.getEnderecos().addAll(Arrays.asList(e1, e2));
		pac1.getEnderecos().addAll(Arrays.asList(e1, e2));
		pac2.getEnderecos().addAll(Arrays.asList(e3));
		
		
		HistoricoPaciente his1 = new HistoricoPaciente(null, LocalDateTime.now(), "Teste de Registro de Hist??rico de Paciente 1", pac1);
		HistoricoPaciente his2 = new HistoricoPaciente(null, LocalDateTime.now(), "Teste de Registro de Hist??rico de Paciente 2", pac2);
		
		
		
		pac1.getHistoricosPaciente().addAll(Arrays.asList(his1));
		pac2.getHistoricosPaciente().addAll(Arrays.asList(his2));
		
		pacienteRepository.saveAll(Arrays.asList(pac1,pac2));
		historicoPacienteRepository.saveAll(Arrays.asList(his1,his2));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));
		

		Dia d1 = new Dia(null, LocalDate.now().plusDays(1));
		Dia d2 = new Dia(null, LocalDate.now().plusDays(2));

		
		Horario h1 = new Horario(null, LocalTime.of(8, 0));
		Horario h2 = new Horario(null, LocalTime.of(8, 2));
		Horario h3 = new Horario(null, LocalTime.of(8, 4));
		
		
		DiaTemHorario dth1 = new DiaTemHorario(null, true, d1, h1, ser1, usa1);
		DiaTemHorario dth2 = new DiaTemHorario(null, true, d1, h2, ser1, usa1);
		DiaTemHorario dth3 = new DiaTemHorario(null, true, d1, h3, ser1, usa1);
		DiaTemHorario dth4 = new DiaTemHorario(null, true, d2, h1, ser1, usa2);
		DiaTemHorario dth5 = new DiaTemHorario(null, true, d2, h2, ser1, usa2);
		
		diaRepository.saveAll(Arrays.asList(d1,d2));
		horarioRepository.saveAll(Arrays.asList(h1,h2,h3));
		diaTemHorarioRepository.saveAll(Arrays.asList(dth1,dth2,dth3,dth4,dth5)); 
		

		PerguntaResposta per1 = new PerguntaResposta(null, "Por que a galinha atravessou a rua?", "Pra chegar do outro lado.");
		PerguntaResposta per2 = new PerguntaResposta(null, "O qu?? cai em p?? e corre deitado?", "A chuva.");
		PerguntaResposta per3 = new PerguntaResposta(null, "O qu?? passa dentro da ??gua e n??o se molha?", "A sombra.");
		
		perguntaRespostaRepository.saveAll(Arrays.asList(per1, per2, per3));
		
		Versiculo ver1 = new Versiculo(null, "Jo??o 3:16", "Porque Deus tanto amou o mundo que deu o seu Filho Unig??nito, para que todo o que nele crer n??o pere??a, mas tenha a vida eterna.");
		Versiculo ver2 = new Versiculo(null, "Mateus 28:19-20", "Portanto, v??o e fa??am disc??pulos de todas as na????es, batizando-os em nome do Pai e do Filho e do Esp??rito Santo, ensinando-os a obedecer a tudo o que eu lhes ordenei. E eu estarei sempre com voc??s, at?? o fim dos tempos");
		Versiculo ver3 = new Versiculo(null, "Mateus 6:33", "Busquem, pois, em primeiro lugar o Reino de Deus e a sua justi??a, e todas essas coisas lhes ser??o acrescentadas.");
		Versiculo ver4 = new Versiculo(null, "Filipenses 4:7", "E a paz de Deus, que excede todo o entendimento, guardar?? os seus cora????es e as suas mentes em Cristo Jesus.");
		Versiculo ver5 = new Versiculo(null, "Jeremias 29:11", "Porque sou eu que conhe??o os planos que tenho para voc??s, diz o Senhor, planos de faz??-los prosperar e n??o de causar dano, planos de dar a voc??s esperan??a e um futuro.");
		Versiculo ver6 = new Versiculo(null, "Jo??o 14:6", "Respondeu Jesus: \"Eu sou o caminho, a verdade e a vida. Ningu??m vem ao Pai, a n??o ser por mim.\"");
		
		versiculoRepository.saveAll(Arrays.asList(ver1,ver2,ver3,ver4,ver5,ver6));

		ConfigAgendamento cfa1 = new ConfigAgendamento(null, LocalDate.now().plusDays(1), LocalDate.now().plusDays(1), LocalTime.of(8, 0), LocalTime.of(16, 0), false, false, true);

		ConfigInformacaoAgendamento cfi1 = new ConfigInformacaoAgendamento(null, true, "Agendamento para Pessoas com Comorbidades", "Todas as Pessoas com mais de 18 anos que possuirem laudo m??dico de comorbidade", "RG", "Documentos de Apresenta????o Obrigat??ria", null, null, null, null, null, null, null, null, null, true, false, false, false, false, false, false, false, false, false);
		
		configAgendamentoRepository.saveAll(Arrays.asList(cfa1));
		
		configInformacaoAgendamentoRepository.saveAll(Arrays.asList(cfi1));
		
		Agendamento age1 = new Agendamento(null, LocalDateTime.now(), "192.168.0.100", 
				LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(1), 
				false, Status.ATIVO, "Vacina????o Covid-19", 
				"Pessoas com 18 anos ou mais e portadoras de Comorbidades", 
				"a1b2c3d4", null, pac1, usa3, ser1);
		
		agendamentoRepository.save(age1);
		
		pac1.getAgendamentos().add(age1);
		usa3.getAgendamentos().add(age1);
	}

}
