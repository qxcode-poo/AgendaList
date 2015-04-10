package ufc.poo.armazenamento;

import java.util.ArrayList;


import java.util.List;

import ufc.poo.modelo.Contato;
import ufc.poo.repositorio.IRepositorioContato;

public class ListaContatos implements IRepositorioContato {
	List<Contato> contatos;

	public ListaContatos() {
		contatos = new ArrayList<Contato>();
	}

	public boolean cadastrarContato(Contato contato) {
		if (this.buscarContatoPorNome(contato.getNome()) == null) {
			this.contatos.add(contato);
			System.out.println("Contato cadastrado!");
			return true;
		}
		System.out.println("Contato nao cadastrado!");
		return false;
	}

	public Contato buscarContatoPorNome(String nomeContato) {
		for (int i = 0; i < this.contatos.size(); i++) {
			if (nomeContato.equals(this.contatos.get(i).getNome())) {
				return this.contatos.get(i);
			}
		}
		System.out.println("Contato nao encontrado!");
		return null;
	}

	public boolean atualizarContato(String nomeContato, Contato contato) {
		for (int i = 0; i < this.contatos.size(); i++) {
			if (nomeContato.equals(this.contatos.get(i).getNome())) {
				this.contatos.get(i).setNome(contato.getNome());
				this.contatos.get(i).setEmail(contato.getEmail());
				this.contatos.get(i).setTelefone(contato.getTelefone());
				System.out.println("Contato atualizado!");
				return true;
			}
		}
		System.out.println("Contato nao atualizado!");
		return false;
	}

	public boolean removerContato(Contato contato) {
		for (int i = 0; i < this.contatos.size(); i++) {
			if (contato.getNome().equals(this.contatos.get(i).getNome())) {
				this.contatos.remove(i);
				System.out.println("Contato removido!");
				return true;
			}
		}
		System.out.println("Contato nao removido!");
		return false;
	}

	public List<Contato> buscarTodosContatos() {
		return this.contatos;
	}

}
