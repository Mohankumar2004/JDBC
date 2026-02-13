package JDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Display {
	private static String url="jdbc:postgresql://localhost:5432/school";
	private static String username="postgres";
	private static String password="4321";
	public static void main(String[] args) {
	try {
        Class.forName("org.postgresql.Driver");
        System.out.println("Driver load attempt finished.");
        Connection con=DriverManager.getConnection(url,username,password);
        System.out.println("Connected to DB");
       
 
        //String sql="SELECT * from student where age=?";
        String sql="SELECT * from student";
        PreparedStatement pstm=con.prepareStatement(sql);
        
        //pstm.setInt(1, 22);
        
        ResultSet rs=pstm.executeQuery();
        
        while(rs.next()) {
        	System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
        }
       
        con.close();
        
    } catch (ClassNotFoundException e) {
    	
        e.printStackTrace();
    
    } catch (SQLException e) {
		
		e.printStackTrace();
		
	}


}
}
