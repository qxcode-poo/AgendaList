package ufc.poo.controle;

import ufc.poo.armazenamento.ListaContatos;
import ufc.poo.modelo.Contato;

public class Controlador {
	public static void main(String[] args) {
		
		ListaContatos listaContatos = new ListaContatos();
		
		listaContatos.cadastrarContato(new Contato("davi","sena.ufc@gmail.com","1234"));
		listaContatos.removerContato(new Contato("davi","sena.ufc@gmail.com","1234"));
		listaContatos.cadastrarContato(new Contato("davi","sena.ufc@gmail.com","1234"));
		listaContatos.cadastrarContato(new Contato("sena","sena.ufc@gmail.com","1234"));
		System.out.println("Contatos encontrados:");
		for (int i = 0; i < listaContatos.buscarTodosContatos().size(); i++) {
			System.out.println(listaContatos.buscarTodosContatos().get(i));
		}
		listaContatos.atualizarContato("davi",new Contato("davi sena","sena.ufc@gmail.com","1234"));
		System.out.println("Contatos encontrados:");
		for (int i = 0; i < listaContatos.buscarTodosContatos().size(); i++) {
			System.out.println(listaContatos.buscarTodosContatos().get(i));
		}
	}
}
