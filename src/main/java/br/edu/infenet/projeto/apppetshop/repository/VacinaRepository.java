package br.edu.infenet.projeto.apppetshop.repository;

import br.edu.infenet.projeto.apppetshop.domain.Vacina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolpaRepository extends CrudRepository<Vacina, Long> {
    @Query("from Vacina p where p.usuario.id = :userid")
    public List<Vacina> obterLista(Long userid);
}
