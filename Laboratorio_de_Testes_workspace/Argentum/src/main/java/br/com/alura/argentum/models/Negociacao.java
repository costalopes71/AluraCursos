package br.com.alura.argentum.models;

import java.time.LocalDateTime;

public final class Negociacao {

	private final double preco;
	private final int quantidade;
	private final LocalDateTime data;

	public Negociacao(double preco, int quantidade, LocalDateTime data) {
		
		if (preco < 0) {
			throw new IllegalArgumentException("O pre�o n�o pode ser negativo.");
		}
		
		if (data == null) {
			throw new IllegalArgumentException("A data n�o pode ser nula.");
		}
		
		if (quantidade < 1) {
			throw new IllegalArgumentException("A quantidade deve ser um valor positivo.");
		}
		
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}

	public double getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public LocalDateTime getData() {
		return data;
	}

	public double getVolume() {
		return this.preco * this.quantidade;
	}
	
}
