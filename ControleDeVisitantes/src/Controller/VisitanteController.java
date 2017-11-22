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

	public void editar(Visitante visitante) {
		VisitanteDAO.instanciaSingleton().editar(visitante);
	}

	public void remover(Visitante visitante) {
		VisitanteDAO.instanciaSingleton().excluir(visitante.getId());
	}

}
=======
package Controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.VisitanteDAO;
import model.Visitante;

public class VisitanteController {

	public void salvar(Visitante visitante) throws Exception {
		if (visitante.getNome().trim().equals("") || visitante.getNome().trim().length() < 3) {
			throw new Exception("Nome inválido");
		}

		String email = visitante.getEmail();
		String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern p = Pattern.compile(emailPattern);

		Matcher m = p.matcher(email);

		if (!m.matches()) {
			throw new Exception("Email inválido");
		}
		if (visitante.getSexo().trim().equals("Selecione")) {
			throw new Exception("Sexo inválido");
		}

		VisitanteDAO.instanciaSingleton().salvar(visitante);
	}

	public List<Visitante> listar() {
		return VisitanteDAO.instanciaSingleton().listarVisitantes();
	}

	public void editar(Visitante visitante) {
		VisitanteDAO.instanciaSingleton().editar(visitante);
	}

	public void remover(Visitante visitante) {
		VisitanteDAO.instanciaSingleton().excluir(visitante.getId());
	}

}
