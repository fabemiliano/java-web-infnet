package br.edu.infenet.projeto.apppetshop.controller;

import br.edu.infenet.projeto.apppetshop.service.FerramentaService;
import br.edu.infenet.projeto.apppetshop.domain.Ferramenta;
import br.edu.infenet.projeto.apppetshop.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class FerramentaController {

    @Autowired
    private FerramentaService ferramentaService;

    @GetMapping(value = "/ferramenta/lista")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

        model.addAttribute("listaFerramenta", ferramentaService.obterLista(usuario));

        return "ferramenta/lista";
    }

    @GetMapping(value = "/ferramenta/cadastro")
    public String telaCadastro() {

        return "ferramenta/cadastro";
    }

    @PostMapping(value = "/ferramenta/incluir")
    public String incluir(Ferramenta ferramenta, @SessionAttribute("user") Usuario usuario) {

        ferramenta.setUsuario(usuario);

        ferramentaService.incluir(ferramenta);

        return "redirect:/ferramenta/lista";
    }

    @GetMapping(value = "/ferramenta/excluir/{id}")
    public String exclusao(@PathVariable Long id) {

        ferramentaService.excluir(id);

        return "redirect:/ferramenta/lista";
    }
}
