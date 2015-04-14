package aluno;

import interfaces.IAgenda;
import testes.AbsAgendaTestes;

public class AgendaTestes extends AbsAgendaTestes {
	public IAgenda getInstance(){
		return new Agenda();
	}
	
}
