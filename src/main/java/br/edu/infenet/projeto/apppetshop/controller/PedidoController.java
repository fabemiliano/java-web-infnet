package br.edu.infenet.projeto.apppetshop.controller;

import br.edu.infenet.projeto.apppetshop.service.ClienteService;
import br.edu.infenet.projeto.apppetshop.service.PedidoService;
import br.edu.infenet.projeto.apppetshop.service.ProdutoService;
import br.edu.infenet.projeto.apppetshop.domain.Pedido;
import br.edu.infenet.projeto.apppetshop.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    @GetMapping(value = "/pedido")
    public String telaCadastro(Model model, @SessionAttribute("user") Usuario usuario) {

        model.addAttribute("clientes", clienteService.obterLista(usuario));

        model.addAttribute("produtos", produtoService.obterLista(usuario));

        return "pedido/cadastro";
    }

    @GetMapping(value = "/pedido/lista")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
        model.addAttribute("listaPedido", pedidoService.obterLista(usuario));

        return "pedido/lista";
    }

    @PostMapping(value = "/pedido/incluir")
    public String incluir(Pedido pedido, @SessionAttribute("user") Usuario usuario) {

        pedido.setUsuario(usuario);

        pedidoService.incluir(pedido);

        return "redirect:/pedido/lista";
    }

    @GetMapping(value = "/pedido/excluir/{id}")
    public String excluir(@PathVariable Long id) {

        pedidoService.excluir(id);

        return "redirect:/pedido/lista";
    }
}
