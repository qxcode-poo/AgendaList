package ufc.poo.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import ufc.poo.agenda.AgendaChip;

public class Testador {

	AgendaChip agendachip = new AgendaChip();
	@Test
	public void test() {
		
		assertTrue(agendachip.resetAgenda(10)==true);
		assertTrue(agendachip.adicionarContato("Ronildo", "97049490")==1);
		assertTrue(agendachip.adicionarContato("Oliveira", "97049490")==2);
		assertTrue(agendachip.adicionarContato("Oliveira", "97049490")==3);
		assertTrue(agendachip.getContatoById(1)!=null);
		assertTrue(agendachip.atualizarContato(1, "Ronildo Oliveira", "94701234")==true);
		
		assertTrue(agendachip.removerContato(3)==true);
		
		assertTrue(agendachip.favoritar(2)==true);
		assertTrue(agendachip.favoritar(1)==true);
		
		assertTrue(agendachip.getFavoritos()!=null);
	}

}
