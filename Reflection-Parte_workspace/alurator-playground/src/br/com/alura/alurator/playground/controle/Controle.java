package br.com.alura.alurator.playground.controle;

import java.util.Arrays;
import java.util.List;

public class Controle {
	private List<String> lista = Arrays.asList("item 1", "item 2", "item 3");
	
	public Controle() {

	}
	
	public Controle(String s) {
		
	}
	
	private Controle(String s, String t) {
		
	}
	
	public List<String> getLista() {
		return lista;
	}
	
}
