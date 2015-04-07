package ufc.poo.agenda;

import java.util.List;

import ufc.poo.contato.IContato;

public interface IAgendaChip {

	boolean resetAgenda(int maxContatos);
	Integer adicionarContato(String nome, String telefone);
	IContato getContatoById(int id);
	boolean atualizarContato(int id, String nome, String telefone);
	boolean removerContato(int id);
	List<IContato> getContatos();
	IContato getFirstByName(String texto);
	List<IContato> busca(String texto);
}
	