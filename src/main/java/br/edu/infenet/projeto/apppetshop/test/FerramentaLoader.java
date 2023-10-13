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
public class EncomendaLoader implements ApplicationRunner {

	@Autowired
    FerramentaService ferramentaService;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<Ferramenta> ferramentas = new ArrayList<Ferramenta>();
		ferramentas.add(new Ferramenta(150f, LocalDateTime.now().plusDays(10), "Safra 1", "Ferramenta 1", 1000.00f, 7L));
		ferramentas.add(new Ferramenta(300f, LocalDateTime.now().plusDays(10), "Safra 2", "Ferramenta 2", 10.0f, 2000L));
		ferramentas.add(new Ferramenta(300f, LocalDateTime.now().plusDays(10), "Safra 3", "Ferramenta 3", 2000.00f, 9L));

		for(Ferramenta ferramenta : ferramentas) {
			ferramenta.setUsuario(new Usuario("TesteUsuario1", "testeusuario1@teste.com", "1234"));
			ferramenta.getUsuario().setId(1L);
			ferramentaService.incluir(ferramenta);
		}
	}
}
