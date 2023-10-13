package br.edu.infenet.projeto.apppetshop.domain;

import javax.persistence.*;

@Entity
@Table(name = "vacina")
public class Vacina extends Produto {

    private boolean receita;

    private Float quantidade;

    private String informacoes;

    public Vacina() {
    }

    public Vacina(boolean receita, Float tamanho, String informacoes, String descricao, Float valor, Long codigo) {
        super(descricao, valor, codigo);
        this.receita = receita;
        this.quantidade = tamanho;
        this.informacoes = informacoes;
    }

    public Vacina(Long id) {
        super(id);
    }

    public boolean isReceita() {
        return receita;
    }

    public void setReceita(boolean receita) {
        this.receita = receita;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }

    public String getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }

    @Override
    public String toString() {
        return String.format("%s - receita: %s - quantidade: %.2f - Marca: %s", super.toString(), receita, quantidade, informacoes);
    }

}
