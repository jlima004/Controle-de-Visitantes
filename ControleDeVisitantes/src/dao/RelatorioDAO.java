package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Evento;

import model.Visitante;
import utill.ConnectionUtil;

public class RelatorioDAO {

	public static RelatorioDAO instancia;
	public ArrayList<Visitante> listaVisitantes;
	private Connection con = ConnectionUtil.getConnection();
	

	
	
	
	
	
	public static  RelatorioDAO instanciaSingleton(){
		if(instancia == null){
			instancia= new RelatorioDAO();
		}
		return instancia;
	}
	
	
	public List<Visitante> listaPorArea(String area){
		try {
			listaVisitantes = new ArrayList<>();
			String comandoSql = "SELECT *  FROM visitante v INNER JOIN evento_visitante AS ev ON ev.idvisitante = v.idvisitante  INNER JOIN evento AS e ON e.idevento = ev.idevento  WHERE e.area = ?";
			PreparedStatement pstmt = con.prepareStatement(comandoSql);
			pstmt.setString(1, area );
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				Visitante visitante = new Visitante();
				visitante.setId(rs.getInt("idvisitante"));
				visitante.setNome(rs.getString("nomeVisitante"));
				visitante.setBairro(rs.getString("bairro"));
				visitante.setEmail(rs.getString("email"));
				visitante.setTelefone(rs.getString("telefone"));
				visitante.setSexo(rs.getString("sexo"));
				
				listaVisitantes.add(visitante);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return listaVisitantes;
			
			
			
	}
	
	
	public int totalEventos(String area){
		try {
			String sql = "SELECT COUNT(idEvento) as totalEventos FROM evento WHERE area = ?";
			PreparedStatement prest  = con.prepareStatement(sql);
			prest.setString(1, area);
			
			ResultSet rs = prest.executeQuery();
			
			int aux = 0;
			
			if(rs.next()){
				  aux = rs.getInt("totalEventos");
				
			}
			
			return aux;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
		
		
	}
	
}
