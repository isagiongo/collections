package java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestaCurso {

	public static void main(String[] args) {
		List<Curso> cursos = Arrays.asList(new Curso(1, "Java 8", 45), new Curso(2, "Lambdas", 23),
				new Curso(3, "MongoDB", 29));
		cursos.sort(Comparator.comparing(Curso::getAlunos));
		// cursos.forEach(c -> System.out.println(c.getNome()));

		cursos.stream().filter(c -> c.getAlunos() > 25).forEach(c -> System.out.println(c.getNome()));

		List<Integer> cursos1 = cursos.stream().filter(c -> c.getAlunos() > 50).map(Curso::getAlunos)
				.collect(Collectors.toList());
		System.out.println(cursos1);

		cursos.stream().filter(c -> c.getAlunos() > 200).findFirst().ifPresent(c -> System.out.println(c.getNome()));

		Map mapa = cursos.stream().filter(c -> c.getAlunos() > 40)
				.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()));
		System.out.println(mapa);

	}
}