package br.com.alura.argentum.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CandlestickFactory {

	public Candlestick geraCandlestickPorData(List<Negociacao> negociacoes, LocalDateTime data) {
		
		double abertura = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();
		double fechamento = negociacoes.isEmpty() ? 0 :negociacoes.get(negociacoes.size() - 1).getPreco();
		double volume = 0;
		double minimo = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();
		double maximo = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();;
		
		for (Negociacao negociacao : negociacoes) {
			volume += negociacao.getVolume();
			
			if (negociacao.getPreco() > maximo) {
				maximo = negociacao.getPreco();
			} else if (negociacao.getPreco() < minimo) {
				minimo = negociacao.getPreco();
			}
			
		}
		
		return new Candlestick(abertura, fechamento, maximo, minimo, volume, data);
	}

	public List<Candlestick> constroiCandles(List<Negociacao> negociacoes) {

		List<Candlestick> candlesticks = new ArrayList<>();
		List<Negociacao> negociacoesDoDia = new ArrayList<>();
		LocalDateTime dataAtual = negociacoes.get(0).getData();
		
		for (Negociacao negociacao : negociacoes) {
			if (negociacao.isMesmoDia(dataAtual)) {
				negociacoesDoDia.add(negociacao);
			} else {
				candlesticks.add(geraCandlestickPorData(negociacoesDoDia, dataAtual));
				negociacoesDoDia = new ArrayList<>();
				negociacoesDoDia.add(negociacao);
				dataAtual = negociacao.getData();
			}
		}
		
		candlesticks.add(geraCandlestickPorData(negociacoesDoDia, dataAtual));
		
		return candlesticks;
	}
	
}
