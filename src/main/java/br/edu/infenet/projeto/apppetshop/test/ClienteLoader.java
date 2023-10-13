package br.edu.infenet.projeto.apppetshop.test;

import br.edu.infenet.projeto.apppetshop.service.ClienteService;
import br.edu.infenet.projeto.apppetshop.domain.Cliente;
import br.edu.infenet.projeto.apppetshop.domain.Produto;
import br.edu.infenet.projeto.apppetshop.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Order(2)
@Component
public class ClienteLoader implements ApplicationRunner {

	@Autowired
	ClienteService clienteService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(new Cliente("TesteCliente1", "11111111111", "testecliente1@teste.com"));
		clientes.add(new Cliente("TesteCliente2", "22222222222", "testecliente2@teste.com"));
		clientes.add(new Cliente("TesteCliente3", "33333333333", "testecliente3@teste.com"));

		for(Cliente cliente : clientes ) {
			cliente.setUsuario(new Usuario("TesteUsuario1", "testeusuario1@teste.com", "1234"));
			cliente.getUsuario().setId(1L);
			clienteService.incluir(cliente);
		}

		System.out.println("Inserção Cliente no banco de dados - Sucesso");
	}
}
