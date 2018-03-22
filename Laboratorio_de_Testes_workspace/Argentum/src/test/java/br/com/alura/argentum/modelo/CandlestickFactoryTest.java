package br.com.alura.argentum.modelo;

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

}
