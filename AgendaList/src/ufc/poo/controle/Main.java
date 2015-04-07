package ufc.poo.controle;

import ufc.poo.agenda.AgendaChip;
import ufc.poo.contato.IContato;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AgendaChip agenda = new AgendaChip();
		agenda.resetAgenda(10);
		agenda.adicionarContato("Antonio", "97049400");
		agenda.adicionarContato("Bruna", "97049401");
		agenda.adicionarContato("Brutus", "97049001");
		agenda.adicionarContato("Claucio", "97049402");
		agenda.adicionarContato("Damares", "p7049403");
		//agenda.adicionarContato("Edivan", "97049404");
		agenda.adicionarContato("Fabiane", "97049405");
		agenda.adicionarContato("Gláucia", "97049406");
		agenda.adicionarContato("Heitor", "97049407");
		agenda.adicionarContato("Italo", "97049408");
		agenda.adicionarContato("José", "97049409");
		agenda.adicionarContato("Kléber", "97049410");
//		System.out.println(agenda.getContatos().size());
		agenda.atualizarContato(4, "JuJoel", "90oiu563488");
		
		agenda.removerContato(5);
		for (IContato contato : agenda.getContatos()) {
			System.out.println(contato.getNome()+"\t"+
							   contato.getTelefone()+"\t"+
							   contato.getId());
		}
		
		System.out.println(agenda.getContatoById(2).getNome());
//		System.out.println("Ok");
		
		if (agenda.getFirstByName("bru") != null) {
			System.out.println(agenda.getFirstByName("bru").getNome());
		}else{
			System.out.println("NADA ENCONTRADO");
		}
		
		for (IContato iContato : agenda.busca("au")) {
			System.out.println("\t"+iContato.getNome()+"\t");
		}		
		
		String text = "1"; 
		if (text.matches("[0-9]+")) {
			System.out.println("so numero");
		}
		

	}

}
