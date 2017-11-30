package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Atracao;
import utill.ConnectionUtil;

public class AtracaoDAO {
	
	public static AtracaoDAO instancia;
	public ArrayList<Atracao> listaAtracoes;
	private Connection com = ConnectionUtil.getConnection();

	
	public static AtracaoDAO instanciaSigleton(){
		if(instancia ==null){
			instancia = new AtracaoDAO();
		}
		
		return instancia;
	}
	
	public void salvar(Atracao atracao){
		try {
			String comandoSql = "INSERT INTO atracao(nome,dataatracao,horainicio,horafim,descricao) VALUES (?,?,?,?,?)";
			PreparedStatement prest= com.prepareStatement(comandoSql,Statement.RETURN_GENERATED_KEYS);
			prest.setString(1, atracao.getNome());
			prest.setDate(2, atracao.getData());
			prest.setTime(3, atracao.getHoraInicio());
			prest.setTime(4, atracao.getHorarioTermino());
			prest.setString(5, atracao.getDescricao());
			
			int key = prest.executeUpdate();
			int idatracao;
			
			if(key>0){
				ResultSet rs = prest.getGeneratedKeys();
				rs.next();
				idatracao = rs.getInt(1);
				
				String sql = "INSERT INTO evento_atracao(idevento,idatracao) VALUES(?,?)";
				PreparedStatement pst = com.prepareStatement(sql);
				pst.setInt(1, atracao.getIdEvento());
				pst.setInt(2, idatracao);
				
				pst.execute();
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public List<Atracao> listarAtracoesEvento(int idEvento){
		try {
			listaAtracoes = new ArrayList<>();
			String sql = "SELECT * FROM atracao a INNER JOIN evento_atracao as ea ON a.idatracao = ea.idatracao WHERE ea.idevento =?";
			PreparedStatement pstmt = com.prepareStatement(sql);
			pstmt.setInt(1, idEvento);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				Atracao atracao = new Atracao();
				atracao.setNome(rs.getString("nome"));
				atracao.setId(rs.getInt("idatracao"));
				atracao.setData(rs.getDate("dataAtracao"));
				atracao.setHoraInicio(rs.getTime("horainicio"));
				atracao.setHorarioTermino(rs.getTime("horafim"));
				atracao.setDescricao(rs.getString("descricao"));
				
				
				listaAtracoes.add(atracao);
				
			}	
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return listaAtracoes;
		
	}
	

	public void editar(Atracao atracao){
		try {
			String sql = "UPDATE atracao SET nome =?,dataAtracao=? ,horainicio=?,horafim=?,descricao=? WHERE idatracao=? ";
			PreparedStatement st = com.prepareStatement(sql);
			st.setString(1, atracao.getNome());
			st.setDate(2, atracao.getData());
			st.setTime(3, atracao.getHoraInicio());
			st.setTime(4, atracao.getHorarioTermino());
			st.setString(5, atracao.getDescricao());
			st.setInt(6, atracao.getId());
			
			st.execute();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public void excluir(int id){
		try {
			String comandoSql = "DELETE FROM atracao WHERE idatracao =?";
			PreparedStatement prest = com.prepareStatement(comandoSql);
			prest.setInt(1, id);
			
			prest.execute();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}
