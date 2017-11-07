package Controller;

import java.util.List;

import dao.VisitanteDAO;
import model.Visitante;

public class VisitanteController {

	public void salvar(Visitante visitante) {
		VisitanteDAO.instanciaSingleton().salvar(visitante);
	}

	public List<Visitante> listar() {
		return VisitanteDAO.instanciaSingleton().listarVisitantes();
	}

	public void remover(Visitante visitante) {
		VisitanteDAO.instanciaSingleton().excluir(visitante.getId());
	}

}
