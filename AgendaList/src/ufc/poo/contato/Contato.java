package ufc.poo.contato;


public class Contato implements IContato {
	
	private int id;
	private String nome;
	private String telefone;
	
	private boolean favorito;

	public Contato(int id, String nome, String telefone) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.favorito = false;
	}
	
	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return this.nome;
	}

	@Override
	public String getTelefone() {
		// TODO Auto-generated method stub
		return this.telefone;
	}

	@Override
	public void setNome(String nome) {
		// TODO Auto-generated method stub
		this.nome = nome;
		
	}

	@Override
	public void setTelefone(String telefone) {
		// TODO Auto-generated method stub
		this.telefone = telefone;
	}
	
	public boolean isFavorito() {
		return this.favorito;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}
}
