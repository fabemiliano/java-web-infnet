package br.edu.infenet.projeto.apppetshop.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "racao")
public class Racao extends Produto{

	private Float peso;

	private boolean pacote;

	private LocalDateTime validade;

	public Racao() {
	}
	
	public Racao(Float peso, boolean pacote, LocalDateTime validade, String descricao, Float valor, Long codigo) {
		super(descricao, valor, codigo);
		this.peso = peso;
		this.pacote = pacote;
		this.validade = validade;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public boolean isPacote() {
		return pacote;
	}

	public void setPacote(boolean pacote) {
		this.pacote = pacote;
	}

	public LocalDateTime getValidade() {
		return validade;
	}

	public void setValidade(LocalDateTime validade) {
		this.validade = validade;
	}

	@Override
	public String toString() {
		return String.format("%s - Peso: %.2f - Pacote: %s - Validade: %s", super.toString(), peso, pacote, validade);
	}

}
