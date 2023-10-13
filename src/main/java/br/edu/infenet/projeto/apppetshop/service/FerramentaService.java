package br.edu.infenet.projeto.apppetshop.service;

import br.edu.infenet.projeto.apppetshop.repository.FerramentaRepository;
import br.edu.infenet.projeto.apppetshop.domain.Ferramenta;
import br.edu.infenet.projeto.apppetshop.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FerramentaService {

    @Autowired
    private FerramentaRepository ferramentaRepository;

    public Collection<Ferramenta> obterLista(){

        return (Collection<Ferramenta>) ferramentaRepository.findAll();
    }

    public Collection<Ferramenta> obterLista(Usuario usuario){

        return ferramentaRepository.obterLista(usuario.getId());
    }

    public void incluir(Ferramenta ferramenta) {

        ferramentaRepository.save(ferramenta);
    }

    public void excluir(Long id) {

        ferramentaRepository.deleteById(id);
    }
}
