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
		System.out.println(palavras);

		List<String> outrasPalavras = Arrays.asList("Isadora Giongo", "Veronica Torres", "Pupy Giongo", "Teddy Torres");
		Collections.sort(outrasPalavras);
		System.out.println(outrasPalavras);

		// Utilizando o comparator é possível comparar de outra forma, que não a
		// alfabética. Por exemplo, por tamanho da palavra.
		Comparator<String> comparador = new ComparadorPorTamanho();
		// Collections.sort(palavras, comparador);
		palavras.sort(comparador); // java 8
		System.out.println(palavras);

		System.out.println("Imprimindo através do for: ");
		for (String string : outrasPalavras) {
			System.out.println("-- " + string);
		}

		Consumer<String> consumidor = new ImprimePorLinhas();
		System.out.println("Imprimindo pelo consumer");
		palavras.forEach(consumidor);
	}
}

class ImprimePorLinhas implements Consumer<String> {
	@Override
	public void accept(String s) {
		System.out.println("-- " + s);
	}
}

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
