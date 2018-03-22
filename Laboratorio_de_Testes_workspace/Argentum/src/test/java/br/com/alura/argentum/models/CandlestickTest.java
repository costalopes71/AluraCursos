package br.com.alura.argentum.models;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

public class CandlestickTest {

	@Test(expected=IllegalArgumentException.class)
	public void maximoNaoDeveSerMenorQueMinimo() {
		
		CandleBuilder builder = new CandleBuilder();
		Candlestick candle = builder.comAbertura(10.0).comFechamento(30.0).comMaximo(15.0).comMinimo(25.0)
				.comVolume(200.0).comData(LocalDateTime.now()).geraCandle();
		
	}

	@Test
	public void ehAltaSeFechamentoForIgualAbertura() {
		
		CandleBuilder builder = new CandleBuilder();
		Candlestick candle = builder.comAbertura(10.0).comFechamento(10.0).comMaximo(50.0).comMinimo(25.0)
				.comVolume(200.0).comData(LocalDateTime.now()).geraCandle();
		
		Assert.assertTrue(candle.isAlta());
	}
	
}
