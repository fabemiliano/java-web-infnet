package br.edu.infenet.projeto.apppetshop.service;

import br.edu.infenet.projeto.apppetshop.repository.FrutaRepository;
import br.edu.infenet.projeto.apppetshop.vo.Racao;
import br.edu.infenet.projeto.apppetshop.vo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FrutaService {

    @Autowired
    private FrutaRepository frutaRepository;

    public Collection<Racao> obterLista(){

        return (Collection<Racao>) frutaRepository.findAll();
    }

    public Collection<Racao> obterLista(Usuario usuario){

        return frutaRepository.obterLista(usuario.getId());
    }

    public void incluir(Racao polpa) {

        frutaRepository.save(polpa);
    }

    public void excluir(Long id) {

        frutaRepository.deleteById(id);
    }
}
