package utill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	private static Connection con;
	
	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/controlepi";
			con = DriverManager.getConnection(url,"root","1234");
			con.setAutoCommit(true);
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void closeConnection(){
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
