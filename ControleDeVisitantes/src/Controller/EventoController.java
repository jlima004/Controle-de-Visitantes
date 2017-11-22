package Controller;

import java.util.List;

import dao.EventoDAO;
import model.Evento;

public class EventoController {
	
	
	public void salvar(Evento evento){
		EventoDAO.instanciaSingleton().salvar(evento);
	}
	
	
	public List<Evento> listar(){
		return EventoDAO.instanciaSingleton().listaEvento();
	}
	
	public void editar(Evento evento){
		EventoDAO.instanciaSingleton().editar(evento);
	}
	
	public void remover(Evento evento){
		EventoDAO.instanciaSingleton().excluir(evento.getId());
	}

}
