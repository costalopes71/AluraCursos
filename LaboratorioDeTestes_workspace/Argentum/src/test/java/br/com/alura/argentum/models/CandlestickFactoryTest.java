package br.com.alura.argentum.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import br.com.alura.argentum.models.Candlestick;
import br.com.alura.argentum.models.CandlestickFactory;
import br.com.alura.argentum.models.Negociacao;
import static org.junit.Assert.*;

public class CandlestickFactoryTest {

	@Test
	public void sequenciaDeNegociacoesSimples() {
		LocalDateTime hoje = LocalDateTime.now();

		Negociacao negociacao = new Negociacao(40.0, 100, hoje);
		Negociacao negociacao2 = new Negociacao(35.0, 100, hoje);
		Negociacao negociacao3 = new Negociacao(45.0, 100, hoje);
		Negociacao negociacao4 = new Negociacao(20.0, 100, hoje);

		List<Negociacao> negociacoes = Arrays.asList(negociacao, negociacao2, negociacao3, negociacao4);

		CandlestickFactory csf = new CandlestickFactory();
		Candlestick candle = csf.geraCandlestickPorData(negociacoes, hoje);

		Assert.assertEquals(20.0, candle.getMinimo(), 0.000001);
		Assert.assertEquals(45.0, candle.getMaximo(), 0.000001);
		Assert.assertEquals(40.0, candle.getAbertura(), 0.000001);
		//usando a importacao static nas linhas abaixo
		assertEquals(20.0, candle.getFechamento(), 0.000001);
		assertEquals(14000.0, candle.getVolume(), 0.000001);
	}

	@Test
	public void geraCandleStickComApenasUmaNegociacao() {
		LocalDateTime hoje = LocalDateTime.now();
		Negociacao negociacao = new Negociacao(40.0, 100, hoje);

		List<Negociacao> negociacoes = Arrays.asList(negociacao);

		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.geraCandlestickPorData(negociacoes, hoje);

		//usando import static
		assertEquals(40.0, candle.getMinimo(), 0.000001);
		assertEquals(40.0, candle.getMaximo(), 0.000001);
		assertEquals(40.0, candle.getAbertura(), 0.000001);
		assertEquals(40.0, candle.getFechamento(), 0.000001);
		assertEquals(4000.0, candle.getVolume(), 0.000001);

	}

	@Test
	public void geraCandleStickSemNenhumaNegociacao() {
		LocalDateTime hoje = LocalDateTime.now();
		List<Negociacao> negociacoes = new ArrayList<>();

		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.geraCandlestickPorData(negociacoes, hoje);

		//usando import static
		assertEquals(0.0, candle.getMinimo(), 0.000001);
		assertEquals(0.0, candle.getMaximo(), 0.000001);
		assertEquals(0.0, candle.getAbertura(), 0.000001);
		assertEquals(0.0, candle.getFechamento(), 0.000001);
		assertEquals(0.0, candle.getVolume(), 0.000001);

	}

	@Test
	public void negociacaoDeTresDiasDiferentesGeraTresCandlesDiferentes() {
		LocalDateTime hoje = LocalDateTime.now();
		Negociacao negociacao1 = new Negociacao(50.0, 20, hoje);
		Negociacao negociacao2 = new Negociacao(100.0, 20, hoje);
		Negociacao negociacao3 = new Negociacao(150.0, 20, hoje);
		
		LocalDateTime amanha = hoje.plusDays(1);
		Negociacao negociacao4 = new Negociacao(50.0, 100, amanha);
		Negociacao negociacao5 = new Negociacao(10.0, 20, amanha);
		
		LocalDateTime depois = amanha.plusDays(1);
		Negociacao negociacao6 = new Negociacao(35.0, 20, depois);
		Negociacao negociacao7 = new Negociacao(35.0, 20, depois);
		
		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4, negociacao5, negociacao6, negociacao7);
		
		CandlestickFactory fabrica = new CandlestickFactory();
		List<Candlestick> candlesticks = fabrica.constroiCandles(negociacoes);
		
		Assert.assertEquals(3, candlesticks.size());
		
		Assert.assertEquals(candlesticks.get(0).getData(), hoje);
		Assert.assertEquals(candlesticks.get(1).getData(), amanha);
		Assert.assertEquals(candlesticks.get(2).getData(), depois);
		
		Assert.assertEquals(6000.0, candlesticks.get(0).getVolume(), 0.00001);
		Assert.assertEquals(50.0, candlesticks.get(0).getMinimo(), 0.00001);
		Assert.assertEquals(150.0, candlesticks.get(0).getMaximo(), 0.00001);
		Assert.assertEquals(50.0, candlesticks.get(0).getAbertura(), 0.00001);
		Assert.assertEquals(150.0, candlesticks.get(0).getFechamento(), 0.00001);
		
		Assert.assertEquals(5200.0, candlesticks.get(1).getVolume(), 0.00001);
		Assert.assertEquals(10.0, candlesticks.get(1).getMinimo(), 0.00001);
		Assert.assertEquals(50.0, candlesticks.get(1).getMaximo(), 0.00001);
		Assert.assertEquals(50.0, candlesticks.get(1).getAbertura(), 0.00001);
		Assert.assertEquals(10.0, candlesticks.get(1).getFechamento(), 0.00001);
		
		Assert.assertEquals(1400.0, candlesticks.get(2).getVolume(), 0.00001);
		Assert.assertEquals(35.0, candlesticks.get(2).getMinimo(), 0.00001);
		Assert.assertEquals(35.0, candlesticks.get(2).getMaximo(), 0.00001);
		Assert.assertEquals(35.0, candlesticks.get(2).getAbertura(), 0.00001);
		Assert.assertEquals(35.0, candlesticks.get(2).getFechamento(), 0.00001);
		
	}
	
}
