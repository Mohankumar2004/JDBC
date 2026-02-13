package JDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchExecution {
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
            
            
            String sql="INSERT into student values(?,?,?)";
            //String sql="UPDATE student set age=? where id=?";
            //String sql="DELETE from student where id=?";
            //st.execute(sql);
            
            PreparedStatement pstm=con.prepareStatement(sql);
            
            
            pstm.setInt(1, 105);
            pstm.setString(2, "Hari"); //Insert
            pstm.setInt(3, 22);  //Insert
            pstm.addBatch();
            
            pstm.setInt(1, 106);
            pstm.setString(2, "Manoj"); //Insert
            pstm.setInt(3, 22);  //Insert
            pstm.addBatch();
            
            pstm.setInt(1, 107);
            pstm.setString(2, "Anil"); //Insert
            pstm.setInt(3, 22);  //Insert
            pstm.addBatch();
            
            pstm.executeBatch();
            System.out.println("data saved");
            con.close();
            
        } catch (ClassNotFoundException e) {
        	
            e.printStackTrace();
        
        } catch (SQLException e) {
			
			e.printStackTrace();
			
		}
    

	}
}
