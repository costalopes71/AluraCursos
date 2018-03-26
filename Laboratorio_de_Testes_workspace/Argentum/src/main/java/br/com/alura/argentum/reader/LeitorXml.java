package br.com.alura.argentum.reader;

import java.time.LocalDateTime;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.alura.argentum.models.Negociacao;
import br.com.alura.argentum.xstream.LocalDateTimeConverter;

public class LeitorXml {

	public static void main(String[] args) {
		
		Negociacao n = new Negociacao(10.0, 2, LocalDateTime.now());
		
		XStream xtream = new XStream(new DomDriver());
		xtream.registerLocalConverter(Negociacao.class, "data", new LocalDateTimeConverter());
		String xml = xtream.toXML(n);
		
		System.out.println(xml);
		
	}
	
}
