package br.edu.infenet.projeto.apppetshop.test;

import br.edu.infenet.projeto.apppetshop.service.RacaoService;
import br.edu.infenet.projeto.apppetshop.vo.Racao;
import br.edu.infenet.projeto.apppetshop.vo.Produto;
import br.edu.infenet.projeto.apppetshop.vo.Usuario;
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
public class FrutaLoader implements ApplicationRunner {

	@Autowired
	RacaoService racaoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<Racao> racaos = new ArrayList<Racao>();
		racaos.add(new Racao(350f, true, LocalDateTime.now().plusDays(10), "fruta 1", 15.50f, 4L));
		racaos.add(new Racao(800f, false, LocalDateTime.now().plusDays(10), "fruta 2", 20.0f, 5L));
		racaos.add(new Racao(600f, false, LocalDateTime.now().plusDays(10), "fruta 3", 50.00f, 6L));

		System.out.println(Produto.buscarSaudacaoAtual());

		for(Racao racao : racaos) {
			racao.setUsuario(new Usuario("user1", "user1@gmail.com", "123"));
			racao.getUsuario().setId(1L);
			System.out.println("racao" + racao.toString() + "\n");
			racaoService.incluir(racao);
		}
	}
}
