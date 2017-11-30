package Controller;

import java.util.List;

import dao.RelatorioDAO;

import model.Visitante;

public class RelatorioController {
	
	public int totalEventos(String area){
		return RelatorioDAO.instanciaSingleton().totalEventos(area);
	}
	
	public List<Visitante> listarPorArea(String area) {
		return RelatorioDAO.instanciaSingleton().listaPorArea(area);

	}

}
