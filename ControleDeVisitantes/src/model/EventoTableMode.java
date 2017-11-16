package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class EventoTableMode extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private static final int COL_NOME_EVENTO=0;
	private static final int COL_DATA_INICIO=1;
	private static final int COL_DATA_TERMINO =2;
	private static final int COL_HORA_INICIO =3;
	private static final int COL_HORA_TERMINO=4;
	private static final int COL_RESPONSAVEL =5;
	private static final int COL_AREA=6;
	
	private List<Evento> valores;   
	
	public EventoTableMode(List<Evento> valores) {
		this.valores = new ArrayList<Evento>(valores);

	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 7;//retorna o numero de colunas da tabela 
	}

	@Override
	public int getRowCount() {
		
		return valores.size();//retorna o numero de linhas da sua tabela
	}


	// vai setar o nome da coluna da nossa tabela 
	public String getColumnName(int colum){
		if(colum == COL_NOME_EVENTO)return "Nome Evento";
		if(colum== COL_DATA_INICIO)return "Data de Inicio";
		if(colum==COL_DATA_TERMINO)return "Data de Termino";
		if(colum == COL_HORA_INICIO)return "Hora de Inicio";
		if(colum == COL_HORA_TERMINO)return "Hora de Termino";
		if(colum == COL_RESPONSAVEL)return "Responsavel";
		if(colum == COL_AREA)return "Area de Conhecimento";
		
		return "";
	}
	
	public Object getValueAt(int row, int column) {
		Evento evento = valores.get(row);

		if(column == COL_NOME_EVENTO)return evento.getNome();
		if(column== COL_DATA_INICIO)return evento.getDataInicio();
		if(column==COL_DATA_TERMINO)return evento.getDataTermino();
		if(column == COL_HORA_INICIO)return evento.getHoraInicio();
		if(column == COL_HORA_TERMINO)return evento.getHoraTermino();
		if(column == COL_RESPONSAVEL)return evento.getResponsavel();
		if(column == COL_AREA)return evento.getAreaRelacionada();
		
		return "";
		
	 }
	
	public void setValueAt(Object aValue,int rowIndex , int columnIndex){
		Evento evento = valores.get(rowIndex);
		if(columnIndex == COL_NOME_EVENTO){
			evento.setNome(aValue.toString());
		}else if(columnIndex ==COL_DATA_INICIO){
			evento.setDataInicio(aValue.toString());
		}else if(columnIndex ==COL_DATA_TERMINO){
			evento.setDataTermino(aValue.toString());
		}else if(columnIndex ==COL_HORA_INICIO){
			evento.setHoraInicio(aValue.toString());
		}else if(columnIndex ==COL_HORA_TERMINO){
			evento.setHoraTermino(aValue.toString());
		}else if(columnIndex == COL_RESPONSAVEL){
			evento.setResponsavel(aValue.toString());
		}else if(columnIndex == COL_AREA){
			evento.setAreaRelacionada(aValue.toString());
		}
	}
	
	public Class<?> getColumnClass(int columnIndex) {
		
		return String.class;
	}
	
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		
		return true;
	}
	
	public Evento get(int row) {
		return valores.get(row);
	}
	

}