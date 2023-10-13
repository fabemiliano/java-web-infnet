package br.edu.infenet.projeto.apppetshop.controller;

import br.edu.infenet.projeto.apppetshop.service.RacaoService;
import br.edu.infenet.projeto.apppetshop.vo.Racao;
import br.edu.infenet.projeto.apppetshop.vo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class FrutaController {

    @Autowired
    private RacaoService racaoService;

    @GetMapping(value = "/fruta/lista")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

        model.addAttribute("listaFruta", racaoService.obterLista(usuario));

        return "fruta/lista";
    }

    @GetMapping(value = "/fruta/cadastro")
    public String telaCadastro() {

        return "fruta/cadastro";
    }

    @PostMapping(value = "/fruta/incluir")
    public String incluir(Racao racao, @SessionAttribute("user") Usuario usuario) {

        racao.setUsuario(usuario);

        racaoService.incluir(racao);

        return "redirect:/fruta/lista";
    }

    @GetMapping(value = "/fruta/excluir/{id}")
    public String exclusao(@PathVariable Long id) {

        racaoService.excluir(id);

        return "redirect:/fruta/lista";
    }
}
