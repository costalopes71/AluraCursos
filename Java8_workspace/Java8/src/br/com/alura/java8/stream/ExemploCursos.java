package br.com.alura.java8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ExemploCursos {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		
		cursos.sort((c1, c2) -> Integer.compare(c1.getAlunos(), c2.getAlunos()));
		// ou
		cursos.sort(Comparator.comparing(curso -> curso.getAlunos()));
		// ou
		cursos.sort(Comparator.comparing(Curso::getAlunos));
		// ou 
		cursos.sort(Comparator.comparingInt(Curso::getAlunos)); // usando o metodo comparingInt eu evito o autoboxing do java pois trabalho com o tipo primitivo
		
		cursos.forEach(System.out::println);
		
		// Metodo filter
		System.out.println("\nCursos com mais de 100 alunos");
		cursos.stream().filter(c -> c.getAlunos() >= 100).
			forEach(c -> System.out.println(c.getNome()));
		
		// Metodo MAP
		// depois de filtrar quero saber quantos alunos tem cada um desses cursos:
		System.out.println("\nAlunos em cursos com mais de 100 alunos");
		cursos.stream().filter(curso -> curso.getAlunos() >=100).
			map(Curso::getAlunos).
			forEach(System.out::println);
		
		// posso mapear o mesmo Stream de cima para um Stream de int (primitivo), o de cima retorna um Stream<Integer> e por isso tem as desvantagens do
		// box e unboxing (autoboxing). Um IntStream (Stream de int) tambem eh mais vantajoso pois tem varios metodos especificos para se trabalhar com inteiros. Existe tbm
		// Streams para os tipos primitivos double e long
		int sum = cursos.stream().filter(c -> c.getAlunos() >=100)
			.mapToInt(Curso::getAlunos)
			.sum();
		System.out.println("\nA soma de alunos nos cursos com mais de 100 alunos: " + sum);
		
		System.out.println("\nMetodos findAny e findFirst");
		// Metodos findAny e findFirst
		Optional<Curso> optionalCurso = cursos.stream().filter(c -> c.getAlunos() > 100).
				findAny();
		
		optionalCurso.ifPresent(System.out::println);
		
		// pega o valor do optional
		Curso curso1 = optionalCurso.get();
		
		// o metodo orElse evita que uma exception (NoSuchElementException) seja lancada caso nao existir valor para o Curso 
		Curso curso = optionalCurso.orElse(null);
		
		//geralmente eh usado dessa maneira
		cursos.stream().filter(c -> c.getAlunos() > 100).
				findAny()
				.ifPresent(System.out::println);
		
		// optional aparece em varios outros lugares da API
		OptionalDouble media = cursos.stream().filter(c -> c.getAlunos() > 100).mapToInt(Curso::getAlunos).average();
		
		System.out.println("\nMetodo collect e classe Collectors");
		// METODO COLLECT
		// se eu quiser alterar minha colecao posso usar o metodo collect, ou tbm se a partir dela quiser coletar os dados em uma nova colecao
		cursos = cursos.stream().filter(c -> c.getAlunos() >= 100)
			.collect(Collectors.toList());
		System.out.println("Tamanho da lista de cursos filtrada: " + cursos.size());
		
		List<Curso> cursosFiltrados = cursos.stream().filter(c -> c.getAlunos() >= 100)
				.collect(Collectors.toList());
		
		Map<String, Integer> map = cursos.stream().filter(c -> c.getAlunos() > 100).
			collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()));
		
		System.out.println("\nMapa de cursos (nome -> alunos): ");
		cursos.stream().filter(c -> c.getAlunos() > 100).
				collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos())).
				forEach((key, value) -> System.out.println(key + " tem " + value));;
		
	}

}