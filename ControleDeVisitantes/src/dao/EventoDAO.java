package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Evento;
import utill.utill.ConnectionUtil;

public class EventoDAO {
	
	
	public static EventoDAO instancia;
	public ArrayList<Evento> listaEventos;
	private Connection con = ConnectionUtil.getConnection();
	

	
	
	
	
	
	public static  EventoDAO instanciaSingleton(){
		if(instancia == null){
			instancia= new EventoDAO();
		}
		return instancia;
	}
	
	
	public void salvar (Evento evento){
		try {
			String comandoSql = "INSERT INTO  evento(nomeevento,datainicio,datatermino,horainicio,horatermino,responsavel,area)VALUES(?,?,?,?,?,?,?)";
			PreparedStatement prest = con.prepareStatement(comandoSql);
			prest.setString(1, evento.getNome());
			prest.setDate(2, new Date(evento.getDataInicio().getTime()));//transforma o localdate em date para salvar no banco de dados.
			prest.setDate(3, new Date(evento.getDataTermino().getTime()));//transforma o localdate em date para salvar no banco de dados.
			prest.setTime(4, new Time(evento.getHoraInicio().getTime()));//transforma o localtime em time para salvar no banco de dados.
			prest.setTime(5, new Time(evento.getHoraTermino().getTime()));//transforma o localtime em time para salvar no banco de dados.
			prest.setString(6,evento.getResponsavel());
			prest.setString(7, evento.getAreaRelacionada());
			
			prest.execute();
			
		} catch (SQLException e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
	}
	
	
	public List<Evento> listaEvento(){
		listaEventos = new ArrayList<>();
		try {
			
			Statement st = con.createStatement();
			String sql = "SELECT * FROM evento";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){
				Evento evento = new Evento();
				evento.setId(rs.getInt("idevento"));
				evento.setNome(rs.getString("nomeevento"));
				evento.setDataInicio(rs.getDate("datainicio"));// transforma de date para localdade e depois em String para aceitar no set;
				evento.setDataTermino(rs.getDate("datatermino"));// transforma de date para localdade e depois em String para aceitar no set;
				evento.setHoraInicio(rs.getTime("horainicio"));// transforma de time para localtime e depois em String para aceitar no set;
				evento.setHoraTermino(rs.getTime("horatermino"));// transforma de time para localtime e depois em String para aceitar no set;
				evento.setResponsavel(rs.getString("responsavel"));
				evento.setAreaRelacionada(rs.getString("area"));
				
				
				
				listaEventos.add(evento);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaEventos;
		
		
	}
	
	
	public void editar (Evento evento){
		try {
			String comandoSql = "UPDATE evento SET  nomeevento = ?,datainicio=?,datatermino=?,horainicio=?,horatermino=?,responsavel=?,area=?";
			PreparedStatement prest = con.prepareStatement(comandoSql);
			prest.setString(1, evento.getNome());
			prest.setDate(2,evento.getDataInicio());//transforma o localdate em date para salvar no banco de dados.
			prest.setDate(3, evento.getDataTermino());//transforma o localdate em date para salvar no banco de dados.
			prest.setTime(4, evento.getHoraInicio());//transforma o localtime em time para salvar no banco de dados.
			prest.setTime(5, evento.getHoraTermino());//transforma o localtime em time para salvar no banco de dados.
			prest.setString(6,evento.getResponsavel());
			prest.setString(7, evento.getAreaRelacionada());
			
			prest.execute();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void excluir(int id){
		try {
			String comandoSql = "DELETE FROM evento WHERE idevento =?";
			PreparedStatement prest = con.prepareStatement(comandoSql);
			prest.setInt(1, id);
			
			prest.execute();
			
			listaEvento();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	

}
