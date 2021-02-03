import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class LivroEmprestado extends Livro {
		
	private static ArrayList<LivroEmprestado> livroEmpArray = new ArrayList<>();
	
	private String dataDevo;
	private int matricula;

	
	public int getMatricula() {
		return this.matricula;
	}
	
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public String getDataDevo() {
		return this.dataDevo;
	}
	
	public void setDataDevo(String dataDevo) {
		this.dataDevo = dataDevo; 
	}

	public LivroEmprestado(int idLivro,String title, String autor, int edicao, int matricula, String dataDevo2) {
		super(idLivro, title, autor, edicao);
		setMatricula(matricula);
		setDataDevo(dataDevo2);
	}
	
	public LivroEmprestado(ArrayList<LivroEmprestado> livrosEmp) {
		livroEmpArray = livrosEmp;
	}
	
	static Scanner scanner = new Scanner(System.in);
	
	public void fazerEmprestimo() {
		System.out.println();
		System.out.format("%1$30s", "Solicitar Emprestimo\n\n");
		System.out.println("Digite o idLivro:");
		int idTemp = scanner.nextInt();
		if(checarExistencia(livroTemp, idTemp) == true) {
			System.out.println("\nLivro nao cadastrado!");
			return;
			}
		else {
			Livro temp = new Livro();
			temp = pegarInformacaoLivro(idTemp);
			System.out.println("\nDigite a matricula do aluno: ");
			int matricula = scanner.nextInt();
			String dataDevo = dataDevolucao();
			LivroEmprestado livroTemp = new LivroEmprestado(idTemp,temp.getTitulo(), temp.getAutor(), temp.getEdicao(), matricula, dataDevo);
			emprestimo(livroTemp);
			System.out.println("\nEmprestimo feito com sucesso!!!");
			System.out.println("Data de devolucao: " + livroTemp.getDataDevo());
		}
	}
	
	public static void emprestimo(LivroEmprestado livroTemp) {
		livroEmpArray.add(livroTemp);		
		}
	
	public static void imprimirEmprestimo(ArrayList<LivroEmprestado> emp, int ind) {
		System.out.format("%-15d", livroEmpArray.get(ind).getIdLivro());
		System.out.format("%1$-30s%2$-25s%3$-15d%4$-15d%5$-15s", livroEmpArray.get(ind).getTitulo(),
		livroEmpArray.get(ind).getAutor(), livroEmpArray.get(ind).getEdicao(),
		livroEmpArray.get(ind).getMatricula() , livroEmpArray.get(ind).getDataDevo());
		System.out.println();
	}
	
	public void imprimirListaDeEmprestimo() {
		System.out.format("%1$35s", "Lista de livros emprestados\n\n");
		printCabecalho();
		boolean imp = livroEmpArray.isEmpty();
		if(imp == false) {
			for(int i = 0; i< livroEmpArray.size(); i++) {
				imprimirEmprestimo(livroEmpArray, i);
			}
		}
		else
			System.out.println("Lista de Emprestimo Vazia");
	}
	
	public static String dataDevolucao() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + 8);
		Date data = c.getTime();
		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
		return formatar.format(data);
	}
	
	
	public void checkEmprestimo() throws ParseException{
		int i = 0;
		Calendar c = Calendar.getInstance();
		for (i = 0; i < livroEmpArray.size() ; i++) {			
			Date data2 = new SimpleDateFormat("dd/MM/yyyy").parse(livroEmpArray.get(i).getDataDevo());
			Date data1 = c.getTime();
			long diferenca = data1.getTime() - data2.getTime();
			long diffInDays = TimeUnit.MILLISECONDS.toDays(diferenca);
			if(diffInDays > 0)
				Aluno.multar(livroEmpArray.get(i).getMatricula(), diffInDays);
		}
	}

	
	public void devolucao() {
		System.out.println("\nQual o id do livro que deseja devolver?");
		int id = scanner.nextInt();
		for(int i = 0; i< livroEmpArray.size(); i++) {
			if(livroEmpArray.get(i).getIdLivro() == id) {
				System.out.println();
				printCabecalho();
				imprimirEmprestimo(livroEmpArray, i);
				System.out.println("\n\nDevolucao concluida");
				livroEmpArray.remove(i);
				return;				
			}
		}
		System.out.println("\n\nLivro nao encontrado.");
		
	}
	
	public static void printCabecalho() {
		System.out.format("%1$-15s%2$-30s%3$-25s%4$-15s%5$-15s%6$-15s",
				"Identificao", "Titulo", "Autor", "Edicao", "Matricula", "Data Devolucao");
		System.out.println("\n");
	}
	
}

	

