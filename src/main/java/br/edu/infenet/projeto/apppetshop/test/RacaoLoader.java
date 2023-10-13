package br.edu.infenet.projeto.apppetshop.test;

import br.edu.infenet.projeto.apppetshop.service.RacaoService;
import br.edu.infenet.projeto.apppetshop.domain.Racao;
import br.edu.infenet.projeto.apppetshop.domain.Produto;
import br.edu.infenet.projeto.apppetshop.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Order(3)
@Component
public class RacaoLoader implements ApplicationRunner {

	@Autowired
	RacaoService racaoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<Racao> racaos = new ArrayList<Racao>();
		racaos.add(new Racao(500f, true, LocalDateTime.now().plusDays(10), "Ração 1", 8.50f, 4L));
		racaos.add(new Racao(200f, false, LocalDateTime.now().plusDays(10), "Ração 2", 4.0f, 5L));
		racaos.add(new Racao(1000f, true, LocalDateTime.now().plusDays(10), "Ração 3", 16.50f, 6L));

		for(Racao racao : racaos) {
			racao.setUsuario(new Usuario("TesteUsuario1", "testeusuario1@teste.com", "1234"));
			racao.getUsuario().setId(1L);
			racaoService.incluir(racao);
		}

		System.out.println("Inserção Ração no banco de dados - Sucesso");
	}
}
