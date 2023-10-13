package br.edu.infenet.projeto.apppetshop.controller;

import br.edu.infenet.projeto.apppetshop.service.RacaoService;
import br.edu.infenet.projeto.apppetshop.domain.Racao;
import br.edu.infenet.projeto.apppetshop.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class RacaoController {

    @Autowired
    private RacaoService racaoService;

    @GetMapping(value = "/racao/lista")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

        model.addAttribute("listaRacao", racaoService.obterLista(usuario));

        return "racao/lista";
    }

    @GetMapping(value = "/racao/cadastro")
    public String telaCadastro() {

        return "racao/cadastro";
    }

    @PostMapping(value = "/racao/incluir")
    public String incluir(Racao racao, @SessionAttribute("user") Usuario usuario) {

        racao.setUsuario(usuario);

        racaoService.incluir(racao);

        return "redirect:/racao/lista";
    }

    @GetMapping(value = "/racao/excluir/{id}")
    public String exclusao(@PathVariable Long id) {

        racaoService.excluir(id);

        return "redirect:/racao/lista";
    }
}
