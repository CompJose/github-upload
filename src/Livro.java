import java.util.ArrayList;
import java.util.Scanner;

public class Livro {

	protected int idLivro;
	private String titulo;
	private String autor;
	private int edicao;
	
	
	protected static ArrayList<Livro> livroTemp = new ArrayList<>();
	
	public int getIdLivro(){
		return this.idLivro;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getAutor() {
		return this.autor;
	}
	
	public int getEdicao() {
		return this.edicao;
	}
	
	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}
	
	public Livro() {
	}

	public Livro(int id) {
		idLivro = id;
	}
	
	public Livro(int id, String titulo, String autor, int edicao) {
		setIdLivro(id);
		setTitulo(titulo);
		setAutor(autor);
		setEdicao(edicao);
	}
	
	public Livro(ArrayList<Livro> book) {
		livroTemp = book;
	}
	
	static Scanner scanner = new Scanner(System.in);
	
	public static boolean checarExistencia(ArrayList<Livro> book, int id) {
		int i = 0;
		for(i = 0; i< book.size() ; i++) {
			if(book.get(i).getIdLivro() == id) {
				System.out.format("%1$30s", "\nLivro encontrado\n\n");
				printCabecalho();
				imprimirLivro(livroTemp, i);
				return false;
				}
		}
		return true;
	}
	
	public static void cadastrar(Livro livroNovo) {
		livroTemp.add(livroNovo);
		int a = livroTemp.size() - 1;
		printCabecalho();
		imprimirLivro(livroTemp, a);
	}
	
	public void cadastrarNovoLivro(){
		System.out.println("\nDigite as informacoes do livro\n");
		System.out.println("Numero de identificação: ");
		int id = scanner.nextInt();
		if(Livro.checarExistencia(livroTemp, id) == false) {
			System.out.println("\nImpossivel efetuar o cadastro.");
			return;}
		else {
			scanner.nextLine();
			System.out.println("Digite o titulo: ");
			String titulo = scanner.nextLine();
			System.out.println("Digite o nome do autor: ");
			String autor = scanner.nextLine();
			System.out.println("Digite a edicao: ");
			int edicao = scanner.nextInt();
			Livro livro0 = new Livro(id, titulo, autor, edicao);
			System.out.println("\nLivro cadastrado com sucesso");
			cadastrar(livro0);
		}
	}
	
	public static void printCabecalho() {
		System.out.format("%1$-15s%2$-30s%3$-25s%4$-15s", "Identificao", "Titulo", "Autor", "Edicao");
		System.out.println("\n");
	}
	
	public static void imprimirLivro(ArrayList<Livro> book, int id) {
		System.out.format("%-15d", livroTemp.get(id).getIdLivro());
		System.out.format("%1$-30s%2$-25s%3$-15d",
		livroTemp.get(id).getTitulo(), livroTemp.get(id).getAutor(), livroTemp.get(id).getEdicao());
		System.out.println();
	}
	
	public void imprimirListaDeLivros() {
		boolean empt = livroTemp.isEmpty();
		if(empt == false) {
			System.out.format("%1$40s", "Lista dos livros disponiveis\n\n");
			printCabecalho();
			for(int i = 0; i< livroTemp.size(); i++) {
				imprimirLivro(livroTemp, i);				
			}
		}
		else
			System.out.println("Nenhum livro cadastrado");
	}
	
	public Livro pegarInformacaoLivro(int id) {
		for(int i = 0; i < livroTemp.size(); i++) 
			if(livroTemp.get(i).getIdLivro() == id){
			Livro copia = new Livro (id, livroTemp.get(i).getTitulo(), livroTemp.get(i).getAutor(), livroTemp.get(i).getEdicao());
			return copia;
		}	
		return null;
	}
	
}
