package java8;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Data {
	
	public static void main(String[] args) {
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		
		System.out.println(hoje.format(formatador));
		
		LocalDate proximasOlimpiadas = LocalDate.of(2020, Month.JUNE, 10);
		int anosRestantes = proximasOlimpiadas.getYear() - hoje.getYear();
		System.out.println(anosRestantes);
		
		//metodo factory estático (between)
		Period periodoRestante = Period.between(hoje, proximasOlimpiadas);
		System.out.println(periodoRestante);
		
	}

}
