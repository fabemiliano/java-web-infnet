package br.edu.infenet.projeto.apppetshop.repository;

import br.edu.infenet.projeto.apppetshop.domain.Ferramenta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EncomendaRepository extends CrudRepository<Ferramenta, Long> {
    @Query("from Ferramenta e where e.usuario.id = :userid")
    public List<Ferramenta> obterLista(Long userid);
}
