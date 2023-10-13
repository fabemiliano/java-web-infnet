package br.edu.infenet.projeto.apppetshop.test;

import br.edu.infenet.projeto.apppetshop.service.ProdutoService;
import br.edu.infenet.projeto.apppetshop.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Order(6)
@Component
public class ProdutoLoader implements ApplicationRunner {

	@Autowired
	ProdutoService produtoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		List<Produto> produtoList = new ArrayList<>();
		produtoList.add(new Racao(350f, true, LocalDateTime.now().plusDays(10), "Ração - Produto 1", 16.00f, 4L));
		produtoList.add(new Ferramenta(800f, LocalDateTime.now().plusDays(10),"------", "Ferramenta - Produto 2", 14.0f, 5L));
		produtoList.add(new Vacina(true, 300f, "Manter em Local temperatura baixa", "Vacina - Produto 3", 30.00f, 6L));

		for(Produto produto : produtoList) {
			produto.setUsuario(new Usuario("TesteUsuario1", "testeusuario1@teste.com", "1234"));
			produto.getUsuario().setId(1L);
			produtoService.incluir(produto);
		}

		System.out.println("Inserção Produto no banco de dados - Sucesso");
	}
}