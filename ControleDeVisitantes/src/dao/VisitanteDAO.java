package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.fabric.xmlrpc.base.Array;

import model.Evento;
import model.Visitante;
import utill.ConnectionUtil;

public class VisitanteDAO {

	public static VisitanteDAO instancia;
	public ArrayList<Visitante> listaVisitantes;
	private Connection com = ConnectionUtil.getConnection();

	public static VisitanteDAO instanciaSingleton() {
		if (instancia == null) {
			instancia = new VisitanteDAO();
		}
		return instancia;
	}

	public void salvar(Visitante visitante) {
		try {
			String comandoSql = "INSERT INTO visitante(nomevisitante,sexo,telefone,bairro,email) VALUES(?,?,?,?,?)";
			PreparedStatement prest = com.prepareStatement(comandoSql,Statement.RETURN_GENERATED_KEYS);
			prest.setString(1, visitante.getNome());
			prest.setString(2, visitante.getSexo());
			prest.setString(3, visitante.getTelefone());
			prest.setString(4, visitante.getBairro());
			prest.setString(5, visitante.getEmail());
			
			
			
			int key = prest.executeUpdate();
			int idvisitante;
			
			if(key>0){
				ResultSet rs = prest.getGeneratedKeys();
				rs.next();
				idvisitante = rs.getInt(1);
				
				String sql = "INSERT INTO evento_visitante(idevento,idvisitante) VALUES(?,?)";
				PreparedStatement pst = com.prepareStatement(sql);
				pst.setInt(1, visitante.getIdEvento());
				pst.setInt(2, idvisitante);
				pst.execute();
				
			}
			
			

			
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Visitante> listarVisitantePorEvento(int idEvento){
			try {
				listaVisitantes = new ArrayList<>();
				String comandoSql = "SELECT * FROM visitante v INNER JOIN evento_visitante as ev ON ev.idvisitante = v.idvisitante WHERE ev.idevento = ?";
				PreparedStatement pstmt = com.prepareStatement(comandoSql);
				pstmt.setInt(1, idEvento);
				
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
	
	

	public List<Visitante> listarVisitantes() {
		try {
			listaVisitantes = new ArrayList<>();
			Statement state = com.createStatement();
			String comandoSql = "SELECT * FROM visitante";
			ResultSet res = state.executeQuery(comandoSql);

			while (res.next()) {
				Visitante visitante = new Visitante();
				visitante.setId(res.getInt("idvisitante"));
				visitante.setNome(res.getString("nomeVisitante"));
				visitante.setBairro(res.getString("bairro"));
				visitante.setSexo(res.getString("sexo"));
				visitante.setTelefone(res.getString("telefone"));
				visitante.setEmail(res.getString("email"));

				listaVisitantes.add(visitante);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaVisitantes;
	}

	public void editar(Visitante visitante) {
		try {
			String comandoSql = "UPDATE visitante SET "
					+ "nomeVisitante = ?, "
					+ "sexo = ?,"
					+ "telefone = ?,"
					+ "bairro = ?,"
					+ "email = ?"
					+ "WHERE idvisitante = ?";
			PreparedStatement prest = com.prepareStatement(comandoSql);
			prest.setString(1, visitante.getNome());
			prest.setString(2, visitante.getSexo());
			prest.setString(3, visitante.getTelefone());
			prest.setString(4, visitante.getBairro());
			prest.setString(5, visitante.getEmail());
			prest.setInt(6, visitante.getId());
			
			prest.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		try {
			
			String comandoSql = "DELETE FROM visitante WHERE idvisitante = ?";
			PreparedStatement prest = com.prepareStatement(comandoSql);
			prest.setInt(1, id);

			prest.execute();
			listarVisitantes();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	public List<Visitante> listaPorArea(String area){
		try {
			listaVisitantes = new ArrayList<>();
			String comandoSql = "SELECT *  FROM visitante v INNER JOIN evento_visitante AS ev ON ev.idvisitante = v.idvisitante  INNER JOIN evento AS e ON e.idevento = ev.idevento  WHERE e.area = ?";
			PreparedStatement pstmt = com.prepareStatement(comandoSql);
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
	
	

	
	

}
