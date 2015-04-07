package ufc.poo.favorito;

import java.util.List;

import ufc.poo.contato.IContato;

public interface IFavorito {

	boolean favoritar(int id);
	boolean desfavoritar(int id);
	List<IContato> getFavoritos();
	boolean isFavorited(int id);
}
