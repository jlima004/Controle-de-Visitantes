package Controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.VisitanteDAO;
import model.Visitante;

public class VisitanteController {

	public void salvar(Visitante visitante) throws Exception {

		String msg = "";

		if (visitante.getNome().trim().equals("") || visitante.getNome().trim().length() < 3) {
			msg += "Nome inválido\n";
		}

		String email = visitante.getEmail();
		String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern p = Pattern.compile(emailPattern);

		Matcher m = p.matcher(email);

		if (!m.matches()) {
			msg += "Email inválido\n";
		}
		if (visitante.getSexo().trim().equals("Selecione")) {
			msg += "Sexo inválido\n";
		}

		if (!msg.equals("")) {
			throw new Exception(msg);
		}

		VisitanteDAO.instanciaSingleton().salvar(visitante);
	}

	public List<Visitante> listar() {
		return VisitanteDAO.instanciaSingleton().listarVisitantes();
	}

	public List<Visitante> listarVisitantePorEvento(int idEvento) {
		return VisitanteDAO.instanciaSingleton().listarVisitantePorEvento(idEvento);
	}

	public void editar(Visitante visitante) throws Exception {

		String msg = "";

		if (visitante.getNome().trim().equals("") || visitante.getNome().trim().length() < 3) {
			msg += "Nome inválido\n";
		}

		String email = visitante.getEmail();
		String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern p = Pattern.compile(emailPattern);

		Matcher m = p.matcher(email);

		if (!m.matches()) {
			msg += "Email inválido\n";
		}
		if (visitante.getSexo().trim().equals("Selecione")) {
			msg += "Sexo inválido\n";
		}

		if (!msg.equals("")) {
			throw new Exception(msg);
		}

		VisitanteDAO.instanciaSingleton().editar(visitante);
	}

	public void remover(Visitante visitante) {
		VisitanteDAO.instanciaSingleton().excluir(visitante.getId());
	}

	public List<Visitante> listarPorArea(String area) {
		return VisitanteDAO.instanciaSingleton().listaPorArea(area);

	}

}
