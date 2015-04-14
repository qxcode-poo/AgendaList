package aluno;
import interfaces.IContato;

public class Contato implements IContato {
	private int id;
	private String nome;
	private String telefone;

	public Contato(int id, String nome, String telefone) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
	}
	
	public boolean isValid(){
		if (this.nome.equals(""))
			return false;
		try{
			Long.parseLong(this.telefone);
		}catch(Exception e){
			return false;
		}
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String toString() {
		return "Contato [nome=" + nome + ", telefone=" + telefone + "]";
	}

}
