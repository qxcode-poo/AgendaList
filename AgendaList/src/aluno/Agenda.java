package aluno;

import interfaces.IAgenda;
import interfaces.IContato;

import java.util.ArrayList;
import java.util.List;


public class Agenda implements IAgenda {
	private List<IContato> contatos;
	private List<Integer> favoritos;
	private int next_code = 0;
	private int maxSize;
	private final int defaultMaxSize = 5;
	
	public Agenda() {
		this.next_code = 0;
		this.maxSize = defaultMaxSize;
		this.contatos = new ArrayList<IContato>();
		this.favoritos = new ArrayList<Integer>();
	}

	public void resetarAgenda(int maxContatos) {
		this.next_code = 0;
		this.maxSize = maxContatos;
		this.contatos = new ArrayList<IContato>();
		this.favoritos = new ArrayList<Integer>();
	}
	
	public Integer adicionarContato(String nome, String telefone) {
		if (this.getEspacoLivre() > 0) {
			int code = next_code;
			Contato contato = new Contato(code, nome, telefone);
			if (!contato.isValid())
				return null;
			
			next_code++;
			contatos.add(contato);
			return code;
		}
		return null;
	}

	public List<IContato> getContatos() {
		return contatos;
	}

	public boolean atualizarContato(int id, String nome, String telefone) {
		Contato contato = new Contato(id, nome, telefone);
		if (!contato.isValid())
			return false;
		
		for (int i = 0; i < contatos.size(); i++) {
			if (contatos.get(i).getId() == id) {
				contatos.set(i, contato);
				return true;
			}
		}
		return false;
	}

	public boolean removerContato(int id) {
		for (int i = 0; i < contatos.size(); i++) {
			if (contatos.get(i).getId() == id) {
				desfavoritar(id);
				contatos.remove(i);
				return true;
			}
		}
		return false;
	}

	public List<IContato> buscar(String texto) {
		List<IContato> encontrados = new ArrayList<IContato>();
		for (IContato iContato : contatos) {
			if (iContato.getNome().contains(texto)
					|| iContato.getTelefone().contains(texto)) {
				encontrados.add(iContato);
			}
		}
		return encontrados;
	}

	public IContato buscarContatoPorId(int id) {
		for (IContato contato : contatos) {
			if (contato.getId() == id)
				return contato;
		}
		return null;
	}

	public int getEspacoLivre() {
		return maxSize - contatos.size();
	}

	public boolean favoritar(int id) {
		if (favoritos.contains(id))
			return false;
		for (IContato contato : getContatos()) {
			if (contato.getId() == id) {
				favoritos.add(id);
				return true;
			}
		}
		return false;
	}

	public boolean desfavoritar(int id) {
		for (int i = 0; i < favoritos.size(); i++) {
			if (favoritos.get(i) == id) {
				favoritos.remove(i);
				return true;
			}
		}
		return false;
	}

	public List<IContato> getFavoritos() {
		List<IContato> cfavoritos = new ArrayList<IContato>();
		for (Integer i : favoritos) {
			IContato contato = buscarContatoPorId(i);
			if (contato == null)
				this.desfavoritar(i);
			else
				cfavoritos.add(contato);
		}
		return cfavoritos;
	}

	public IContato buscarPrimeiro(String texto) {
		for(IContato contato : contatos)
			if(contato.getNome().startsWith(texto))
				return contato;
		return null;
	}

	public boolean isFavoritado(int id) {
		for(Integer integer : favoritos)
			if(integer == id)
				return true;
		return false;
	}

}
