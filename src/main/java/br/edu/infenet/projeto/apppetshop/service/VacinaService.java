package br.edu.infenet.projeto.apppetshop.service;

import br.edu.infenet.projeto.apppetshop.domain.Vacina;
import br.edu.infenet.projeto.apppetshop.repository.VacinaRepository;
import br.edu.infenet.projeto.apppetshop.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class VacinaService {

    @Autowired
    private VacinaRepository vacinaRepository;

    public Collection<Vacina> obterLista(){

        return (Collection<Vacina>) vacinaRepository.findAll();
    }

    public Collection<Vacina> obterLista(Usuario usuario){

        return vacinaRepository.obterLista(usuario.getId());
    }

    public void incluir(Vacina vacina) {

        vacinaRepository.save(vacina);
    }

    public void excluir(Long id) {

        vacinaRepository.deleteById(id);
    }
}
