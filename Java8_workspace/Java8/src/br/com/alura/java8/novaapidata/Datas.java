package br.com.alura.java8.novaapidata;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Datas {

	public static void main(String[] args) {
		
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje); // imprime aaaa-mm-dd
		
		LocalDate olimpiadas = LocalDate.of(2022, Month.JULY, 1);
		
		int anos = olimpiadas.getYear() - hoje.getYear();
		System.out.println("Faltam " + anos + " anos para as olimpiadas.");
		
		Period periodo = Period.between(hoje, olimpiadas);
		System.out.println(periodo.getDays());
		
		//proxima olimpiada
		LocalDate proximaOlimpiada = olimpiadas.plusYears(4);
		System.out.println(proximaOlimpiada);
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("Proxima olimpiada com data formatada: " + formatador.format(proximaOlimpiada));
		
		// para usar data E tempo LocalDateTime
		DateTimeFormatter formatador2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:MM");
		LocalDateTime agora = LocalDateTime.now();
		System.out.println("Agora: " + agora.format(formatador2));
		
		// para pegar so a data de um LocalDateTime
		agora.toLocalDate();
		
		// LocalTime representa apenas o horario
		LocalTime intervalo = LocalTime.of(14, 30);
		System.out.println("Intervalo: " + intervalo); // imprime 14:30
		
		// Classe que me permite trabalhar apenas com o ano e o mes
		YearMonth anoEMes = YearMonth.of(2015, Month.JANUARY);
		
		// incrementando e decrementando datas
		System.out.println(hoje.minusYears(1));
		System.out.println(hoje.minusMonths(4));
		System.out.println(hoje.minusDays(2));
		System.out.println(hoje.plusYears(1));
		System.out.println(hoje.plusMonths(4));
		System.out.println(hoje.plusDays(2));
		
	}
	
}
