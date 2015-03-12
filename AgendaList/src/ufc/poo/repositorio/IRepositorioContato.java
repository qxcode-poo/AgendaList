package ufc.poo.repositorio;
import java.util.List;

import ufc.poo.modelo.Contato;

public interface IRepositorioContato {
	public boolean cadastrarContato(Contato contato);
	public Contato buscarContatoPorNome(String nomeContato);
	public boolean atualizarContato(String nomeContato, Contato contato);
	public boolean removerContato(Contato contato);
	public List<Contato> buscarTodosContatos();
}
