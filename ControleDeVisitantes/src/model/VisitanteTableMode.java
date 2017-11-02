package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class VisitanteTableMode extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private static final int COL_NOME=0;
	private static final int COL_SEXO=1;
	private static final int COL_BAIRRO =2;
	private static final int COL_TELEFONE =3;
	private static final int COL_EMAIL=4;
	
	private List<Visitante> valores;   
	
	public VisitanteTableMode(List<Visitante> valores) {
		this.valores = new ArrayList<Visitante>(valores);

	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;//retorna o numero de colunas da tabela 
	}

	@Override
	public int getRowCount() {
		
		return valores.size();//retorna o numero de linhas da sua tabela
	}


	// vai setar o nome da coluna da nossa tabela 
	public String getColumnName(int colum){
		if(colum == COL_NOME)return "Nome";
		if(colum== COL_BAIRRO)return "Bairro";
		if(colum==COL_SEXO)return "Sexo";
		if(colum == COL_TELEFONE)return "Telefone";
		if(colum == COL_EMAIL)return "E-mail";
		
		return "";
	}
	
	public Object getValueAt(int row, int column) {
		Visitante visitante = valores.get(row);
		if(column == COL_NOME)return visitante.getNome();
		if(column == COL_BAIRRO)return visitante.getBairro();
		if(column == COL_SEXO)return visitante.getSexo();
		if(column == COL_TELEFONE)return visitante.getTelefone();
		if(column == COL_EMAIL)return visitante.getEmail();
		
		return "";
		
	 }
	
	public void setValueAt(Object aValue,int rowIndex , int columnIndex){
		Visitante visitante = valores.get(rowIndex);
		if(columnIndex == COL_NOME){
			visitante.setNome(aValue.toString());
		}else if(columnIndex ==COL_BAIRRO){
			visitante.setBairro(aValue.toString());
		}else if(columnIndex ==COL_SEXO){
			visitante.setSexo(aValue.toString());
		}else if(columnIndex ==COL_TELEFONE){
			visitante.setTelefone(aValue.toString());
		}else if(columnIndex ==COL_EMAIL){
			visitante.setEmail(aValue.toString());
		}
	}
	
	public Class<?> getColumnClass(int columnIndex) {
		
		return String.class;
	}
	
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		
		return true;
	}
	
	public Visitante get(int row) {
		return valores.get(row);
	}
	

}
