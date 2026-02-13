package JDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.sql.Statement;

public class CRUD {
	private static String url="jdbc:postgresql://localhost:5432/school";
	private static String username="postgres";
	private static String password="4321";
	public static void main(String[] args) {
    
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver load attempt finished.");
            Connection con=DriverManager.getConnection(url,username,password);
            System.out.println("Connected to DB");
            
            //Statement st=con.createStatement();
            
            
            //String sql="INSERT into student values(?,?,?)";
            //String sql="SELECT * from student";
            String sql="UPDATE student set age=? where id=?";
            //String sql="DELETE from student where id=?";
            //st.execute(sql);
            
            PreparedStatement pstm=con.prepareStatement(sql);
            
            //ResultSet rs=pstm.executeQuery();
            //while(rs.next()) {
            //System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
            //}
            
            pstm.setInt(2, 104);
            //pstm.setString(2, "MMK"); //Insert
            pstm.setInt(1, 22);  //Insert
            
            pstm.execute();
            System.out.println("data saved");
            con.close();
            
        } catch (ClassNotFoundException e) {
        	
            e.printStackTrace();
        
        } catch (SQLException e) {
			
			e.printStackTrace();
			
		}
    

	}
}
