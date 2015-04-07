package ufc.poo.agenda;

import java.util.ArrayList;
import java.util.List;

import ufc.poo.favorito.IFavorito;
import ufc.poo.contato.Contato;
import ufc.poo.contato.IContato;

public class AgendaChip implements IAgendaChip, IFavorito {

	private int maxContatos;
	private List<IContato> listaContatos;
	
	boolean validaTelefone(String telefone){
		if (telefone.matches("[0-9]+"))
			return true;
		return false;
	}
	
	@Override
	public boolean resetAgenda(int maxContatos) {
		// TODO Auto-generated method stub
		this.maxContatos = maxContatos;
		this.listaContatos = new ArrayList<IContato>();
		this.listaContatos.removeAll(listaContatos);
		return true;
	}

	@Override
	public Integer adicionarContato(String nome, String telefone) {
		// TODO Auto-generated method stub
		if (validaTelefone(telefone)){
			if (this.listaContatos.size() < this.maxContatos) {
			this.listaContatos.add(new Contato(listaContatos.size()+1, nome, telefone));
				return listaContatos.size();			
			}
		}
		return null;
		
	}

	@Override
	public IContato getContatoById(int id) {
		// TODO Auto-generated method stub
		for (IContato iContato : listaContatos) {
			if(iContato.getId() == id){
				return iContato;
			}
		}
		return null;
	}

	@Override
	public boolean atualizarContato(int id, String nome, String telefone) {
		// TODO Auto-generated method stub
		if (getContatoById(id) != null){ 
			getContatoById(id).setNome(nome);
				if (validaTelefone(telefone)) {
					getContatoById(id).setTelefone(telefone);
				}			
			return true;
		}
		return false;
	}

	@Override
	public boolean removerContato(int id) {
		// TODO Auto-generated method stub
		if (getContatoById(id) != null) {
			this.listaContatos.remove(getContatoById(id));
			return true;
		}
		return false;
	}

	@Override
	public List<IContato> getContatos() {
		// TODO Auto-generated method stub
		return listaContatos;
	}

	@Override
	public IContato getFirstByName(String texto) {
		// TODO Auto-generated method stub
		for (IContato iContato : listaContatos) {
			if (iContato.getNome().toLowerCase().
					subSequence(0, texto.length()).
					equals(texto.toLowerCase())) {
				return iContato;
			}
		}
		return null;
	}

	@Override
	public List<IContato> busca(String texto) {
		// TODO Auto-generated method stub
		List<IContato> listaAux = new ArrayList<IContato>();
		for (IContato iContato : listaContatos) {
			if (iContato.getNome().toLowerCase().contains(texto.toLowerCase())){
				listaAux.add(iContato);
			}			
		}
		return listaAux;
	}

	/*PARTE 2*/
	@Override
	public boolean favoritar(int id) {
		// TODO Auto-generated method stub
		if (getContatoById(id) != null) {
			Contato c = (Contato)getContatoById(id);
			c.setFavorito(true);
			return true;
		}
		return false;
	}

	@Override
	public boolean desfavoritar(int id) {
		// TODO Auto-generated method stub
		if (getContatoById(id) != null) {
			Contato c = (Contato)getContatoById(id);
			c.setFavorito(false);
			return true;
		}
		return false;
	}

	@Override
	public List<IContato> getFavoritos() {
		// TODO Auto-generated method stub
		List<IContato>listaFiltro = new ArrayList<IContato>();
		for (IContato iContato : listaContatos) {
			Contato c = (Contato)iContato;
			if (c.isFavorito()) {
				listaFiltro.add(c);
			}
		}
		return listaFiltro;
	}

	@Override
	public boolean isFavorited(int id) {
		// TODO Auto-generated method stub
		if (getContatoById(id) != null) {
			Contato c = (Contato)getContatoById(id);
			return c.isFavorito();
		}
		return false;
	}

}
