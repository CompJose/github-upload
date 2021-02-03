import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void menu(int n) {
		if(n > 0) {
			for(int i = 0; i < n; i++)
				System.out.print("-");
		}
		System.out.println();
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		ArrayList<Livro> livros = new ArrayList<>();
		ArrayList<LivroEmprestado> livrosEmp = new ArrayList<>();
		ArrayList<Aluno> alunos = new ArrayList<>();
		
		Livro livro1 = new Livro(50, "Aprender Java", "Leao, Adalberto", 2);
		Livro livro2 = new Livro(25, "Sistema de Banco de Dados", "Bonner, William", 2);
		Livro livro3 = new Livro(32, "2001 Uma odisseia no espaco", "Arthur C. Clarke", 4);
		Livro livro4 = new Livro(44, "Calculo 1", "Styles, Harry", 4);
 		Livro livro5 = new Livro(80, "Simbolo Perdido", "Brown, Dan", 9);
		Livro livro6 = new Livro(70, "Calculo 2", "Merc, Maria", 1);
		Livro livro7 = new Livro(223, "Logica", "Ryu, Ken", 8);
		Livro livro8 = new Livro(55, "Brasil 90", "Maria, Jose", 7);
		
		LivroEmprestado emprestimo1 = new LivroEmprestado
				(livro1.getIdLivro(),livro1.getTitulo(), livro1.getAutor(), livro1.getEdicao(), 2020, "19/12/2020");
		LivroEmprestado emprestimo2 = new LivroEmprestado
				(livro2.getIdLivro(),livro2.getTitulo(), livro2.getAutor(), livro2.getEdicao(), 2021, "10/11/2020");
		LivroEmprestado emprestimo3  = new LivroEmprestado
				(livro4.getIdLivro(),livro4.getTitulo(), livro4.getAutor(), livro4.getEdicao(), 2022, "22/12/2020");
		LivroEmprestado emprestimo4 = new LivroEmprestado
				(livro8.getIdLivro(),livro8.getTitulo(), livro8.getAutor(), livro8.getEdicao(), 2022, "23/12/2020");
		LivroEmprestado emprestimo5 = new LivroEmprestado
				(livro3.getIdLivro(),livro3.getTitulo(), livro3.getAutor(), livro3.getEdicao(), 2024, "12/07/2020");
		
		Aluno aluno1 = new Aluno("Jose Maria Campos", 2020);
		Aluno aluno2 = new Aluno("Maria Jose Araujo", 2021);
		Aluno aluno3 = new Aluno("Fausto Silva", 2022);
		Aluno aluno4 = new Aluno("Priscila Silva", 2024);
			
		
		livros.add(livro1);
		livros.add(livro2);
		livros.add(livro3);
		livros.add(livro4);
		livros.add(livro5);
		livros.add(livro6);
		livros.add(livro7);
		livros.add(livro8);
		
		livrosEmp.add(emprestimo1);
		livrosEmp.add(emprestimo2);
		livrosEmp.add(emprestimo3);
		livrosEmp.add(emprestimo4);
		livrosEmp.add(emprestimo5);
		
		alunos.add(aluno1);
		alunos.add(aluno2);
		alunos.add(aluno3);
		alunos.add(aluno4);
		
		Livro colecaoLivros = new Livro(livros);
		LivroEmprestado livrosEmprestados = new LivroEmprestado(livrosEmp);
		Aluno alunosMatriculados = new Aluno(alunos);
		
		
		
		
		try {
			
		livrosEmprestados.checkEmprestimo();
		
		}catch(ParseException e)
		
		{
			e.printStackTrace();
		}
		System.out.println("Qual funcao deseja usar?\n");
		System.out.println("1 - Fazer emprestimo");
		System.out.println("2 - Devolucao");
		System.out.println("3 - Listar livros emprestados");
		System.out.println("4 - Listar todos os livros");
		System.out.println("5 - Cadastrar um novo livro");
		System.out.println("6 - Listar Alunos");
		System.out.println("7 - Cadastrar novo aluno");
		
		System.out.println("-1 - Encerra o programa");
		
		Scanner scanner = new Scanner(System.in);
		int numero;
		
		do {
		numero = scanner.nextInt();
		
		switch(numero) {
			case 1:
				menu(30);
				livrosEmprestados.fazerEmprestimo();
				break;
			case 2:
				menu(30);
				livrosEmprestados.devolucao();
				break;
			case 3:
				menu(30);
				livrosEmprestados.imprimirListaDeEmprestimo();
				break;
			case 4:
				menu(30);
				colecaoLivros.imprimirListaDeLivros();
				break;
			case 5:
				menu(30);
				colecaoLivros.cadastrarNovoLivro();
				break;
			case 6:
				menu(30);
				alunosMatriculados.imprimirListaAlunos();
				break;
			case 7:
				menu(30);
				alunosMatriculados.cadastrarAluno();
				break;
			case -1:
				menu(30);
				System.out.println("\n\nPrograma Encerrado");
				System.exit(0);
			default:
				menu(30);
				System.out.println("\n\nValor Invalido!!!");
				break;
				
			}
		menu(30);
		System.out.println("\n\n\nQual funcao deseja usar?\n");
		
		}while(numero != -1);
		
		
	
	}
	
	
}
