package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class AtracaoTableMode extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private static final int COL_NOME_ATRACAO = 0;
	private static final int COL_DATA = 1;
	private static final int COL_HORA_INICIOO = 2;
	private static final int COL_HORA_TERMINO_ = 3;
	private static final int COL_TIPO = 4;

	private List<Atracao> valores;

	DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	DateTimeFormatter formataHora = DateTimeFormatter.ofPattern("HH:mm");

	public AtracaoTableMode(List<Atracao> valores) {
		this.valores = new ArrayList<Atracao>(valores);
	}

	@Override
	public int getColumnCount() {
		return 5; // retorna o numero de colunas da tabela
	}

	@Override
	public int getRowCount() {
		return valores.size(); // retorna o numero de linhas da sua tabela
	}

	// vai setar o nome da coluna da nossa tabela
	public String getColumnName(int colum) {
		if (colum == COL_NOME_ATRACAO)
			return "Nome Atracao";
		if (colum == COL_DATA)
			return "";
		if (colum == COL_HORA_INICIOO)
			return "";
		if (colum == COL_HORA_TERMINO_)
			return "";
		if (colum == COL_TIPO)
			return "";
		return "";
	}

	@Override
	public Object getValueAt(int row, int column) {
		Atracao atracao = valores.get(row);

		if (column == COL_NOME_ATRACAO)
			return atracao.getNome();
		if (column == COL_DATA)
			return atracao.getData();
		if (column == COL_HORA_INICIOO)
			return atracao.getHoraInicio();
		if (column == COL_HORA_TERMINO_)
			return atracao.getHorarioTermino();
		if (column == COL_TIPO)
			return atracao.getTipo();

		return "";
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Atracao atracao = valores.get(rowIndex);

		if (columnIndex == COL_NOME_ATRACAO) {
			atracao.setNome(aValue.toString());
		} else if (columnIndex == COL_DATA) {
			atracao.setData(LocalDate.parse(aValue.toString(), formataData));
		} else if (columnIndex == COL_HORA_INICIOO) {
			atracao.setHoraInicio(LocalTime.parse(aValue.toString(), formataHora));
		} else if (columnIndex == COL_HORA_TERMINO_) {
			atracao.setHorarioTermino(LocalTime.parse(aValue.toString(), formataHora));
		} else if (columnIndex == COL_TIPO) {
			atracao.setTipo(aValue.toString());
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
