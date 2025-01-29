import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteData {

	public static void main(String[] args) {
		
		Connection c = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db","root","root");
			
			Statement s = c.createStatement();
			
			s.executeUpdate("delete from emp where empno=6");
			
			System.out.println("Data deleted");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(c!=null) {
				c.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
