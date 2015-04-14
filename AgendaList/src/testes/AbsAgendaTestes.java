package testes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import interfaces.IAgenda;
import interfaces.IContato;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public abstract class AbsAgendaTestes {
	
	//você deve extender AbsAgendaTestes e implementar getInstance
	//retornando sua Agenda. Se quiser pode adicionar também novos
	//testes na sua classe de testes.
	public abstract  IAgenda getInstance();
	
	@Test
	public void aParteUm(){
		IAgenda agenda = getInstance();
		agenda.resetarAgenda(3);

		//testando inserção
		assertTrue(agenda.getContatos().size() == 0);
		Integer num0 = agenda.adicionarContato("Marcos", "32259607");
		assertTrue(agenda.getContatos().size() == 1);
		assertTrue(num0 != null);
		
		//testando inserção de dados invalida
		Integer err1 = agenda.adicionarContato("", "000000");//nome vazio
		Integer err2 = agenda.adicionarContato("Fulano", "322asdb");//tel invalido
		assertTrue(err1 == null);
		assertTrue(err2 == null);
		assertTrue(agenda.getContatos().size() == 1);
		
		//testando limite de inserção
		Integer num1 = agenda.adicionarContato("Cesaro", "32259606");
		Integer num2 = agenda.adicionarContato("Marian", "32259605");
		Integer num3 = agenda.adicionarContato("Catarina", "32259605");
		
		assertTrue(num1 != null);
		assertTrue(num2 != null);
		assertTrue(num3 == null);
		assertTrue(agenda.getContatos().size() == 3);
		
		//testando busca por id e remoção
		assertTrue(agenda.buscarContatoPorId(num2).getNome().equals("Marian"));
		assertTrue(agenda.removerContato(num2) == true);
		assertTrue(agenda.removerContato(num2) == false);
		assertTrue(agenda.buscarContatoPorId(num2) == null);
		
		//testando classe contato e atualizacao
		IContato contato = agenda.buscarContatoPorId(num1);
		int ind = contato.getId();
		assertTrue(ind == num1);
		
		//atualizando com dados inválidos
		assertFalse(agenda.atualizarContato(ind, "", "32222222"));
		assertFalse(agenda.atualizarContato(ind, "Fulano", "3222222XZY"));
		
		//atualizando com dados válidos
		assertTrue(agenda.atualizarContato(ind, "Marquinhos", "32222222"));
		contato = agenda.buscarContatoPorId(ind);
		assertTrue(contato.getNome().equals("Marquinhos"));
		assertTrue(contato.getTelefone().equals("32222222"));
		
	}

	@Test
	public void bBuscar() {
		IAgenda agenda = getInstance();

		agenda.resetarAgenda(3);
		agenda.adicionarContato("Cesaro", "32259606");
		agenda.adicionarContato("Cesareia", "92259606");
		agenda.adicionarContato("Cezarino", "88259606");
		
		assertTrue(agenda.buscarPrimeiro("Cesar").getNome().equals("Cesaro"));
		assertTrue(agenda.buscarPrimeiro("Cezar").getNome().equals("Cezarino"));
		
		assertTrue(agenda.buscar("Cesar").size() == 2);
		assertTrue(agenda.buscar("9606").size() == 3);
		assertTrue(agenda.buscar("9606").get(0).getNome().equals("Cesaro"));
		assertTrue(agenda.buscar("8825").get(0).getNome().equals("Cezarino"));
	}

	@Test
	public void cFavoritar() {		
		IAgenda agenda = getInstance();

		agenda.resetarAgenda(6);
		Integer num1 = agenda.adicionarContato("Curio",    "12259606");
		Integer num2 = agenda.adicionarContato("Carmem",   "22259606");
		Integer num3 = agenda.adicionarContato("Cesaro",   "32259606");
		Integer num4 = agenda.adicionarContato("Cesareia", "42259606");
		Integer num5 = agenda.adicionarContato("Cezarino", "58259606");

		assertTrue(agenda.getFavoritos().size() == 0);
		assertTrue(agenda.favoritar(num1));
		assertFalse(agenda.favoritar(num1));
		assertTrue(agenda.isFavoritado(num1));
		assertFalse(agenda.isFavoritado(num2));
		
		assertTrue(agenda.favoritar(num2));
		assertTrue(agenda.favoritar(num5));
		
		assertTrue(agenda.isFavoritado(num5));
		assertFalse(agenda.isFavoritado(num4));
		
		assertTrue(agenda.getFavoritos().size() == 3);
		
		assertTrue(agenda.desfavoritar(num5));
		assertFalse(agenda.desfavoritar(num3));
		assertTrue(agenda.getFavoritos().size() == 2);
		
		assertTrue(agenda.removerContato(num1));
		assertTrue(agenda.getFavoritos().size() == 1);
		assertTrue(agenda.getFavoritos().get(0).getNome().equals("Carmem"));
		
	}
}
