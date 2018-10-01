package br.com.alura.argentum.ws;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import br.com.alura.argentum.models.Negociacao;
import br.com.alura.argentum.reader.LeitorXml;

public class ClientWebService {

	private static final String URL_WS = "http://argentumws.caelum.com.br/negociacoes";
	
	public List<Negociacao> getNegociacoes() {
		
		HttpURLConnection connection = null;
		try {
			URL url = new URL(URL_WS);
			connection = (HttpURLConnection) url.openConnection();
			InputStream content = connection.getInputStream();
			return new LeitorXml().carrega(content);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			connection.disconnect();
		}
		
	}

	public static void main(String[] args) {
		
		ClientWebService ws = new ClientWebService();
		List<Negociacao> lista = ws.getNegociacoes();
		
		for (Negociacao negociacao : lista) {
			System.out.println(negociacao.getPreco());
		}
		
	}
	
}
