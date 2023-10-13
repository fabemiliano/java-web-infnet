package br.edu.infenet.projeto.apppetshop.controller;

import br.edu.infenet.projeto.apppetshop.domain.Vacina;
import br.edu.infenet.projeto.apppetshop.service.VacinaService;
import br.edu.infenet.projeto.apppetshop.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class VacinaController {

    @Autowired
    private VacinaService vacinaService;

    @GetMapping(value = "/vacina/lista")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

        model.addAttribute("listaVacina", vacinaService.obterLista(usuario));

        return "vacina/lista";
    }

    @GetMapping(value = "/vacina/cadastro")
    public String telaCadastro() {

        return "vacina/cadastro";
    }

    @PostMapping(value = "/vacina/incluir")
    public String incluir(Vacina vacina, @SessionAttribute("user") Usuario usuario) {

        vacina.setUsuario(usuario);

        vacinaService.incluir(vacina);

        return "redirect:/vacina/lista";
    }

    @GetMapping(value = "/vacina/excluir/{id}")
    public String exclusao(@PathVariable Long id) {

        vacinaService.excluir(id);

        return "redirect:/vacina/lista";
    }
}
