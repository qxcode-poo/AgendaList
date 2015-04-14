package interfaces;

import java.util.List;


/*
	Esse trabalho é a implementação de uma agenda telefonica como
	dos chips dos celulares antigos.

	Devem ser implementadas as operações de inserção, atualização 
	e remoção. Também a busca por começo e por padrão.

	Os métodos contém explicações do que deve ser efetuado.

	A segunda parte envolve um serviço de favoritar contatos.
*/


public interface IAgenda {

//Parte 1	

	//Inicia a agenda apagando qualquer contato que nela possua.
	//Também configura o limite da memória para adicionar contatos.
	void resetarAgenda(int maxContatos);

	
	// Adiciona um contato à agenda passando nome e telefone.
	// Podem existir múltiplos contatos com o mesmo nome.
	
	// O telefone deve ser composto apenas de digitos.
	// O nome não pode estar vazio.
	
	// Se o contato foi adiciona com sucesso, retorne o id do
	// registro do contato. Retorne null caso contrário.
	// Deve ser gerado um novo id para cada contato.
	Integer adicionarContato(String nome, String telefone);

	//Retorna o contato baseado neste id.
	//Se o id não for valido retorne null.
	IContato buscarContatoPorId(int id);

	//Atualiza o contato com esse id.
	//Retorne null caso id não seja válido ou nome e telefone
	//não estejam de acordo com os requisitos para adicionar um novo contato
	boolean atualizarContato(int id, String nome, String telefone);

	//Remove o contato desse id.
	boolean removerContato(int id);

	//Devolve todos os contatos em um formato de Lista
	List<IContato> getContatos();

	//Retorna o primeiro contato que cujo nome inicia com o texto passado. 
	//Exemplo: "Carlos Matheus" combina com "Car".
	//Se mais de um contato bater com o padrão, retorne apenas o primeiro.
	IContato buscarPrimeiro(String texto);

	//Retorna os contatos cujo nome ou telefone contenha parte do texto passado.
	//Neste casso "Carlos Matheus" também combina com "theu".
	//Pois nesta busca o texto pode estar em qualquer posição do nome ou telefone.
	//Retorne todos os contatos que conferem com o padrão.
	List<IContato> buscar(String texto);

//Parte 2

	//Favorita o contato com esse id.
	//Retorna falso se o contato já for favorito ou 
	//se não existir contato para esse id.
	boolean favoritar(int id);

	//Desvaforita o contato com esse id.
	//Retorna falso se o contato não for favorito ou se não
	//existir contato para esse id.
	boolean desfavoritar(int id);

	//Retorna os contatos favoritados em forma de lista.
	List<IContato> getFavoritos();

	//Retorna true se o contato com este id está favoritado.
	//Falso se não está ou esse contato não existir.
	boolean isFavoritado(int id);
}
