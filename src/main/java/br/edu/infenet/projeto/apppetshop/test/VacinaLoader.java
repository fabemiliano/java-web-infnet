package br.edu.infenet.projeto.apppetshop.test;

import br.edu.infenet.projeto.apppetshop.domain.Vacina;
import br.edu.infenet.projeto.apppetshop.service.VacinaService;
import br.edu.infenet.projeto.apppetshop.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Order(5)
@Component
public class PolpaLoader implements ApplicationRunner {

	@Autowired
    VacinaService vacinaService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<Vacina> vacinas = new ArrayList<Vacina>();
		vacinas.add(new Vacina(true, 350f, "Vacina 1", "Maracuja", 4.50f, 1L));
		vacinas.add(new Vacina(false, 50f, "Vacina 2", "Goiaba", 20.0f, 2L));
		vacinas.add(new Vacina(true, 350f, "Vacina 3", "manga", 10.00f, 3L));

		for(Vacina vacina : vacinas) {
			vacina.setUsuario(new Usuario("TesteUsuario1", "testeusuario1@teste.com", "1234"));
			vacina.getUsuario().setId(1L);
			vacinaService.incluir(vacina);
		}
	}
}
