import java.util.ArrayList;
import java.util.Scanner;


public class Aluno {
	
	private int matricula;
	private String nome;
	private double multa = 0;
	
	private static ArrayList<Aluno> AlunoArray = new ArrayList<>();
	
	static Scanner scanner = new Scanner(System.in);
	
	public int getMatricula() {
		return this.matricula;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public double getMulta() {
		return this.multa;
	}
	
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setMulta(double multa) {
		this.multa += multa;
	}
	
	public Aluno(ArrayList<Aluno> Alunos){
		AlunoArray = Alunos;
	}
	
	public Aluno(String nome, int matricula) {
		setNome(nome);
		setMatricula(matricula);
	}
	
	public void cadastrarAluno() {
		System.out.println("\n\nCadastro de um novo aluno\nDigite a matricula: ");
		int mat = scanner.nextInt();
		if(Aluno.checarMatricula(AlunoArray, mat) == false) {
			System.out.println("Matricula ja cadastrada!!!");
			return;}
		else {
			scanner.nextLine();
			System.out.println("Digite o nome do aluno: ");
			String nome = scanner.nextLine();
			Aluno aluno0 = new Aluno(nome, mat);
			cadastrar(aluno0);
		}
	}
	
	public static boolean checarMatricula(ArrayList<Aluno> alunoTemp, int mat) {
		int i = 0;
		for (i = 0; i < alunoTemp.size(); i++) {
			if(alunoTemp.get(i).getMatricula() == mat) {
				return false;
			}
		}
		return true;
	}
	
	public void imprimirListaAlunos(){
		System.out.println();
		System.out.format("%1$15s", "Lista de alunos matriculados");
		System.out.println();
		int i = 0;
		boolean check = AlunoArray.isEmpty();
		if(check == false) {
			System.out.println();
			printCabecalho();
			for (i = 0; i < AlunoArray.size(); i++) {
				System.out.format("%1$-30s%2$-15d%3$-15.2f", AlunoArray.get(i).getNome(),
						AlunoArray.get(i).getMatricula(), AlunoArray.get(i).getMulta());
				System.out.println();
			}
		}
		else
			System.out.println("\nNao tem alunos cadastrados");			
	}
	
	public static void printCabecalho() {
		System.out.format("%1$-30s%2$-15s%3$-15s", "Nome", "Matricula", "Multa");
		System.out.println("\n");
	}
	
	public static void cadastrar(Aluno aluno) {
		AlunoArray.add(aluno);
	}
	
	public static void multar(int mat, long multa) {
		for(int i = 0; i < AlunoArray.size(); i++)
			if(AlunoArray.get(i).getMatricula() == mat) {
				AlunoArray.get(i).setMulta(multa * 1.0);
		}
	}	
}
