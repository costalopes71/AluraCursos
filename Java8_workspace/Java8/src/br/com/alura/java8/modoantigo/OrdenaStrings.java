package br.com.alura.java8.modoantigo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {

	public static void main(String[] args) {
		
		List<String> palavras = Arrays.asList("alura online", "editora casa do código", "caelum");
		
		Collections.sort(palavras);
		System.out.println(palavras);
		
		Comparator<String> comparador = new ComparadorPorTamanho();
		Collections.sort(palavras, comparador);
		System.out.println(palavras);
	
		// java 8
		palavras.sort(comparador);
		System.out.println("\nJava 8: " + palavras);
		
		// foreach no java < 8
		System.out.println("\nForeach antes do java 8");
		for (String p : palavras) {
			System.out.println(p);
		}
		
		// foreach no java 8
		System.out.println("\nForeache no java 8");
		Consumer<String> consumer = new ImprimeNaLinha();
		palavras.forEach(consumer);
	
		// usando metodo antigo de classe anonima
		palavras.forEach(new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		});
		
		// no java 8 interfaces que tem apenas 1 metodo a ser implementado podem usar lambda
		palavras.forEach((String s) -> {
			System.out.println(s);
		});
		
		// como recebe apenas um argumento, nao sou obrigado a dizer o tipo
		palavras.forEach(s -> {
			System.out.println(s);
		});
		
		// como dentro das chaves tem apenas 1 comando, posso tirar as chaves e o ponto e virgula do comando
		palavras.forEach(s -> System.out.println(s));
		
		// antes do java8 usando classe anonima pro Comparator
		palavras.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() < o2.length()) {
					return -1;
				} else if (o1.length() > o2.length()) {
					return 1;
				} else {
					return 0;
				}
			}
		});
		
		// usando java 8 lambda
		palavras.sort((String s1, String s2) -> {
			if (s1.length() < s2.length()) {
				return -1;
			} else if (s1.length() > s2.length()) {
				return 1;
			} else {
				return 0;
			}
		});
		
		//melhorando 
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
	
		// exemplos
		Consumer<String> impressor = s -> System.out.println(s);
		palavras.forEach(impressor); // apenas um exemplo pra deixar mais claro oq esta acontecendo
	
		// exercicio com Runnable
		new Thread(() -> System.out.println("executando thread 1")).start();
		
	}
	
}

class ImprimeNaLinha implements Consumer<String> {

	@Override
	public void accept(String s) {
		System.out.println(s);
	}
	
}

class ComparadorPorTamanho implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		
		if (o1.length() < o2.length()) {
			return -1;
		} else if (o1.length() > o2.length()) {
			return 1;
		} else {
			return 0;
		}
		
	}
	
}
