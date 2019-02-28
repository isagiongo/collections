package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("Isadora Giongo");
		palavras.add("Veronica Torres");
		palavras.add("Pupy Giongo");
		palavras.add("Teddy Torres");
		Collections.sort(palavras);
		System.out.println("Adiciona na lista com add " + palavras);

		List<String> outrasPalavras = Arrays.asList("Isadora Giongo", "Veronica Torres", "Pupy Giongo", "Teddy Torres");
		Collections.sort(outrasPalavras);
		System.out.println("Adiciona com arrays.asList " + outrasPalavras);

		// Utilizando o comparator é possível comparar de outra forma, que não a
		// alfabética. Por exemplo, por tamanho da palavra.
		Comparator<String> comparador = new ComparadorPorTamanho();
		// Collections.sort(palavras, comparador);
		palavras.sort(comparador); // java 8
		System.out.println("Utiliza comparator e método para comparar palavras por tamanho " + palavras);
		
		//substitui o código acima e o método ComparadorPorTamanho
		palavras.sort((s1, s2)-> Integer.compare(s1.length(), s2.length()));

		System.out.println("Imprimindo através do for: ");
		for (String string : palavras) {
			System.out.println("-- " + string);
		}

		//classe anonima => Para implementar interfaces muito curtas, 
		//e não ter que criar uma nova classe para fazer pouca coisa e que não será reaproveitada
		Consumer<String> consumidor = new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		};
		System.out.println("----Imprimindo pelo consumer");
		palavras.forEach(consumidor);
		
		//faz mesma coisa que todo o código acima -- forEach => default method de Iterable - interface que fornece comportamento
		System.out.println("----for each com lambda");
		palavras.forEach(s -> System.out.println(s));
		
		
	}
}
									//Interface funcional => só tem um método abstrato
class ComparadorPorTamanho implements Comparator<String> {
	@Override
	public int compare(String s1, String s2) {
		if (s1.length() < s2.length())
			return -1;
		if (s1.length() > s2.length())
			return 1;
		return 0;
	}
}
