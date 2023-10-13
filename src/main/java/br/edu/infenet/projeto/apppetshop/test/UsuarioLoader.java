package br.edu.infenet.projeto.apppetshop.test;

import br.edu.infenet.projeto.apppetshop.service.UsuarioService;
import br.edu.infenet.projeto.apppetshop.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Order(1)
@Component
public class UsuarioLoader implements ApplicationRunner {

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		List<Usuario> usuarioList = new ArrayList<>();
		usuarioList.add(new Usuario("TesteUsuario1", "testeusuario1@teste.com", "1234"));
		usuarioList.add(new Usuario("TesteUsuario2", "testeusuario2@teste.com", "1234"));
		usuarioList.add(new Usuario("TesteUsuario3", "testeusuario3@teste.com", "1234"));

		for (Usuario usuario : usuarioList) {
			usuarioService.incluir(usuario);
		}

		System.out.println("Inserção Usuário no banco de dados - Sucesso");
	}
}