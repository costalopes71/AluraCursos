package br.com.alura.argentum.reader;

import java.io.InputStream;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.alura.argentum.models.Negociacao;
import br.com.alura.argentum.xstream.LocalDateTimeConverter;

public class LeitorXml {

	public List<Negociacao> carrega(InputStream inputStream) {
		
		XStream xstream = new XStream(new DomDriver());
		xstream.registerLocalConverter(Negociacao.class, "data", new LocalDateTimeConverter());
		xstream.alias("negociacao", Negociacao.class);
		
		return (List<Negociacao>) xstream.fromXML(inputStream);
	}
	
	
	
}
