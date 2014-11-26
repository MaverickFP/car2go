package it.car2go.servant;

import java.util.List;

import it.car2go.model.Guasto;
import it.car2go.persistance.common.GuastoDAO;
import it.car2go.service.GuastoService;

public class GuastoServant implements GuastoService{
	
	private GuastoDAO guastoDao;
	
	public GuastoServant(){		
	}
	
	
	
	

	public GuastoDAO getGuastoDao() {
		return guastoDao;
	}





	public void setGuastoDao(GuastoDAO guastoDao) {
		this.guastoDao = guastoDao;
	}





	@Override
	public List<Guasto> restituisciGuasti() {
		List<Guasto> lista = guastoDao.getGuasti();
		return lista;
	}

	@Override
	public Guasto restituisciGuastoMacchina(int idMacchina) {
		Guasto guasto = guastoDao.getGuastoMacchina(idMacchina);
		return guasto;
	}





	@Override
	public void salvaGuasto(String nome, int idMacchina) {
		guastoDao.addGuasto(nome, idMacchina);		
	}

}
