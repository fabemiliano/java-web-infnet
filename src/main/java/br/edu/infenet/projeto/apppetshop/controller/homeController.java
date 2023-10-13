package br.edu.infenet.projeto.apppetshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@Controller
public class homeController {

    @GetMapping(value = "/")
    public String telaHome() {
        return "home";
    }

    @GetMapping(value = "/login")
    public String telaLogin() {
        return "login";
    }

    @GetMapping(value = "/logout")
    public String telaLogout(HttpSession session, SessionStatus status) {

        status.setComplete();

        session.removeAttribute("user");

        return "redirect:/";
    }
}
