package it.car2go.persistance.common;

import java.util.List;

import javax.ejb.Remote;

import it.car2go.model.Ruolo;
import it.car2go.model.Utente;

@Remote
public interface UtenteDAO {
	
	void addUtente(Utente utente);
	void delUtente(int id);	
	void updateUtente(Utente utente);
	Utente getUtente(int id);
	List<Utente> getUtenti();
	Ruolo getRuoloUtente(int idUtente);

}
