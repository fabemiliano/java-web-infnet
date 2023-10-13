package br.edu.infenet.projeto.apppetshop.service;

import br.edu.infenet.projeto.apppetshop.repository.RacaoRepository;
import br.edu.infenet.projeto.apppetshop.domain.Racao;
import br.edu.infenet.projeto.apppetshop.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RacaoService {

    @Autowired
    private RacaoRepository racaoRepository;

    public Collection<Racao> obterLista(){

        return (Collection<Racao>) racaoRepository.findAll();
    }

    public Collection<Racao> obterLista(Usuario usuario){

        return racaoRepository.obterLista(usuario.getId());
    }

    public void incluir(Racao racao) {

        racaoRepository.save(racao);
    }

    public void excluir(Long id) {

        racaoRepository.deleteById(id);
    }
}
