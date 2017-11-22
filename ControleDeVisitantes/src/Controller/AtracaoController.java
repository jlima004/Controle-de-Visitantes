package Controller;

import dao.AtracaoDAO;
import model.Atracao;

public class AtracaoController {

	public void salvar(Atracao atracao) {
		AtracaoDAO.instanciaSingleton().salvar(atracao);
	}

}
