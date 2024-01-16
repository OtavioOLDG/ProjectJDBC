package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbIntegrityException;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			conn = DB.getConnection();
			
			pst = conn.prepareStatement(
					"DELETE FROM Department "
					+"Where "
					+ "Id = ?");
			
			pst.setInt(1, 2);

			
			int rowsAffected = pst.executeUpdate();
			
			System.out.println("Rows affected = " + rowsAffected);
		}
		catch(SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		}
		finally {
			DB.closePrepareStatement(pst);
			DB.closeConnection();
		}
	}
}