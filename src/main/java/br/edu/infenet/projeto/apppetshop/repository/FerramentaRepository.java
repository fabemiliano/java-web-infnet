package br.edu.infenet.projeto.apppetshop.repository;

import br.edu.infenet.projeto.apppetshop.domain.Ferramenta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FerramentaRepository extends CrudRepository<Ferramenta, Long> {
    @Query("from Ferramenta f where f.usuario.id = :userid")
    public List<Ferramenta> obterLista(Long userid);
}
