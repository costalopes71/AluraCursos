package br.com.alura.argentum.testes;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import br.com.alura.argentum.models.Candlestick;
import br.com.alura.argentum.models.CandlestickFactory;
import br.com.alura.argentum.models.Negociacao;

public class TestaCandlestickFactory {

	public static void main(String[] args) {
		
		LocalDateTime hoje = LocalDateTime.now();
		
		Negociacao negociacao = new Negociacao(40.0, 100, hoje);
		Negociacao negociacao2 = new Negociacao(35.0, 100, hoje);
		Negociacao negociacao3 = new Negociacao(45.0, 100, hoje);
		Negociacao negociacao4 = new Negociacao(20.0, 100, hoje);
		
		List<Negociacao> negociacoes = Arrays.asList(negociacao, negociacao2, negociacao3, negociacao4);
		
		CandlestickFactory csf = new CandlestickFactory();
		Candlestick candle = csf.geraCandlestickPorData(negociacoes, hoje);
		
		System.out.println("Abertura: " + candle.getAbertura());
		System.out.println("Fechamento: " + candle.getFechamento());
		System.out.println("Minimo: " + candle.getMinimo());
		System.out.println("Maximo: " + candle.getMaximo());
		System.out.println("Volume: " + candle.getVolume());
		
	}
	
}
