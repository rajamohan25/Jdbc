import java.sql.*;

public class FetchDatas {

	public static void main(String[] args) {
		
		Connection c = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		    c = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db","root","root");
		    
		    Statement s = c.createStatement();
		    
		    ResultSet rs = s.executeQuery("select * from emp");
		    
		    while(rs.next()) {  	
		    	System.out.println("EMPNO = " + rs.getInt("empno"));
		    	System.out.println("ENAME = " + rs.getString("ename") );
		    	System.out.println("SALARY = " + rs.getDouble(3));
		    	System.out.println("EMAIL = " + rs.getString(4));
		    	System.out.println("PASSWORD = " + rs.getString("password"));
		    	System.out.println("--------------------------");
		    }
        
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
