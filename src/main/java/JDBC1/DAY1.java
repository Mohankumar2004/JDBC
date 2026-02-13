package JDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DAY1 {
	private static String url="jdbc:postgresql://localhost:5432/school";
	private static String username="postgres";
	private static String password="4321";
	public static void main(String[] args) {
    
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver load attempt finished.");
            Connection con=DriverManager.getConnection(url,username,password);
            System.out.println("Connected to DB");
            Statement st=con.createStatement();
            //String sql="INSERT into student values(102,'Kavi')";
            //String sql="DELETE from student where id=102";
            String sql="UPDATE student set age=19 where id=102";
            st.execute(sql);
            System.out.println("data saved");
            con.close();
            
        } catch (ClassNotFoundException e) {
        	
            e.printStackTrace();
        
        } catch (SQLException e) {
			
			e.printStackTrace();
			
		}
    

	}
}