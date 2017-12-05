package model;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class AtracaoTableMode extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private static final int COL_NOME=0;
	private static final int COL_DATA=1;
	private static final int COL_HORA_INICIO =2;
	private static final int COL_HORA_FIM =3;
	private static final int COL_DESCRICAO=4;
	
	private List<Atracao> valores;   
	
	SimpleDateFormat sp =new SimpleDateFormat("dd/MM/yyyy");
	
	SimpleDateFormat sph =new SimpleDateFormat("HH:mm");
	
	public AtracaoTableMode(List<Atracao> valores) {
		this.valores = new ArrayList<Atracao>(valores);

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
		if(colum== COL_DATA)return "Data";
		if(colum==COL_HORA_INICIO)return "Hora início";
		if(colum == COL_HORA_FIM)return "Hora término";
		if(colum == COL_DESCRICAO)return "Descrição";
		
		return "";
	}
	
	public Object getValueAt(int row, int column) {
		Atracao atracao = valores.get(row);
		if(column == COL_NOME)return atracao.getNome();
		if(column== COL_DATA)return sp.format(atracao.getData());
		if(column==COL_HORA_INICIO)return sph.format(atracao.getHoraInicio());
		if(column == COL_HORA_FIM)return sph.format(atracao.getHorarioTermino());
		if(column == COL_DESCRICAO)return atracao.getDescricao();
		
		return "";
		
	 }
	
	public void setValueAt(Object aValue,int rowIndex , int columnIndex){
		Atracao atracao = valores.get(rowIndex);
		if(columnIndex == COL_NOME){
			atracao.setNome(aValue.toString());
		}else if(columnIndex ==COL_DATA){
			try {
				atracao.setData(new Date(sp.parse(aValue.toString()).getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(columnIndex ==COL_HORA_INICIO){
			try {
				atracao.setHoraInicio(new Time(sph.parse(aValue.toString()).getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(columnIndex ==COL_HORA_FIM){
			try {
				atracao.setHorarioTermino(new Time(sph.parse(aValue.toString()).getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(columnIndex ==COL_DESCRICAO){
			atracao.setDescricao(aValue.toString());
		}
	}
	
	public Class<?> getColumnClass(int columnIndex) {
		
		return String.class;
	}
	
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		
		return true;
	}
	
	public Atracao get(int row) {
		return valores.get(row);
	}
	

}
