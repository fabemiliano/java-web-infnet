package br.edu.infenet.projeto.apppetshop.repository;

import br.edu.infenet.projeto.apppetshop.domain.Racao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RacaoRepository extends CrudRepository<Racao, Long> {
    @Query("from Racao r where r.usuario.id = :userid")
    public List<Racao> obterLista(Long userid);
}
