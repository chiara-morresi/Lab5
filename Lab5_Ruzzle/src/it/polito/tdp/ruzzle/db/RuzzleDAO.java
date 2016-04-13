package it.polito.tdp.ruzzle.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.ruzzle.db.BDConnect; 

public class RuzzleDAO {
	
	public boolean dizionarioContiene(String s) {
		
		Connection conn = BDConnect.getConnection();
		String sql = "select nome from parola where nome=?";
		PreparedStatement st;
		try {
			
			st = conn.prepareStatement(sql);
			st.setString(1, s);
			ResultSet res = st.executeQuery();
			
			if(res.next())
			{
				res.close();
				conn.close();
				return true;
			}
			else
			{
				res.close();
				conn.close();
				return false;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
		
	}

}
