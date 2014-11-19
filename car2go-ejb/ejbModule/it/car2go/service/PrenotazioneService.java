package it.car2go.service;

import java.util.List;

import javax.ejb.Remote;

import it.car2go.model.Prenotazione;

@Remote
public interface PrenotazioneService {

	List<Prenotazione> getPrenotazioniByUserId(int idUser);
	List<Prenotazione> getPrenotazioni();
	Prenotazione getPrenotazione(int idPrenotazione);
	void addPrenotazione(Prenotazione prenotazione);
	void delPrenotazione(int idPrenotazione);
	int getLastIdPrenotazione(int idUser, int idMacchina);
	void updatePrenotazione(Prenotazione p);
	
}
