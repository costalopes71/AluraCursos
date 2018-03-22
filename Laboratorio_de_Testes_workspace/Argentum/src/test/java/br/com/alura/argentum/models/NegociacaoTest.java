package br.com.alura.argentum.models;

import java.time.LocalDateTime;
import org.junit.Test;

public class NegociacaoTest {

	@Test(expected=IllegalArgumentException.class)
	public void naoDeveCriarNegociacaoComPrecoNegativo() {
		new Negociacao(-20.0, 3, LocalDateTime.now());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoDeveCriarNegociacaoComDataNula() {
		new Negociacao(10, 2, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoDeveCriarNegociacaoComQtdNegativa() {
		new Negociacao(10, 0, LocalDateTime.now());
	}
	
}
