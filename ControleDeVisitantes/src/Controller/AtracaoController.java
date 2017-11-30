package Controller;

import java.util.List;

import dao.AtracaoDAO;
import model.Atracao;

public class AtracaoController {
	
	
	public void salvar(Atracao atracao){
		AtracaoDAO.instanciaSigleton().salvar(atracao);
	}
	
	
	public List<Atracao> listarAtracoesEvento(int idEvento){
		return AtracaoDAO.instanciaSigleton().listarAtracoesEvento(idEvento);
	}
	
	
	public void editar(Atracao atracao){
		AtracaoDAO.instanciaSigleton().editar(atracao);
	}
	
	public void remover(int id){
		AtracaoDAO.instanciaSigleton().excluir(id);
	}
	
	

}
