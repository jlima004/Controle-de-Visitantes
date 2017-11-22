package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.Atracao;
import utill.ConnectionUtil;

public class AtracaoDAO {
	
	public static AtracaoDAO instancia;
	public ArrayList<Atracao> listaAtracao;
	private Connection con = ConnectionUtil.getConnection();
	
	DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	DateTimeFormatter formataHora = DateTimeFormatter.ofPattern("HH:mm");
	
	public static AtracaoDAO instanciaSingleton() {
		if(instancia == null) {
			instancia = new AtracaoDAO();
		}
		return instancia;
	}
	
	public void salvar (Atracao atracao){
		try {
			String comandoSql = "INSERT INTO atracao(nome,dataAtracao,horainicio,horafim,tipo)VALUES(?,?,?,?,?)";
			PreparedStatement prest = con.prepareStatement(comandoSql);
			prest.setString(1, atracao.getNome());
			prest.setDate(2, Date.valueOf(atracao.getData()));
			prest.setTime(3, Time.valueOf(atracao.getHoraInicio()));
			prest.setTime(4, Time.valueOf(atracao.getHorarioTermino()));
			prest.setString(5, atracao.getTipo());
			
			prest.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
