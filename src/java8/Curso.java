package java8;

public class Curso {

	private Integer id;
	private String nome;
	private int alunos;
	
	public Curso(Integer id, String nome, int alunos) {
		this.id = id;
		this.nome = nome;
		this.alunos = alunos;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getAlunos() {
		return alunos;
	}
}
