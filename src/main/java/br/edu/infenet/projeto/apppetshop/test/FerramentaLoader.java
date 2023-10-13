package br.edu.infenet.projeto.apppetshop.test;

import br.edu.infenet.projeto.apppetshop.domain.Ferramenta;
import br.edu.infenet.projeto.apppetshop.service.FerramentaService;
import br.edu.infenet.projeto.apppetshop.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Order(4)
@Component
public class FerramentaLoader implements ApplicationRunner {

	@Autowired
    FerramentaService ferramentaService;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<Ferramenta> ferramentas = new ArrayList<Ferramenta>();
		ferramentas.add(new Ferramenta(1f, LocalDateTime.now().plusDays(10), "Ferramenta 1", "Ferramenta 1", 100.00f, 7L));
		ferramentas.add(new Ferramenta(2f, LocalDateTime.now().plusDays(10), "Ferramenta 2", "Ferramenta 2", 100.0f, 2000L));
		ferramentas.add(new Ferramenta(3f, LocalDateTime.now().plusDays(10), "Ferramenta 3", "Ferramenta 3", 100.00f, 9L));

		for(Ferramenta ferramenta : ferramentas) {
			ferramenta.setUsuario(new Usuario("TesteUsuario1", "testeusuario1@teste.com", "1234"));
			ferramenta.getUsuario().setId(1L);
			ferramentaService.incluir(ferramenta);
		}

		System.out.println("Inserção Ferramenta no banco de dados - Sucesso");
	}
}
