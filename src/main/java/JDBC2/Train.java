package JDBC2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Train {
	private static String url="jdbc:postgresql://localhost:5432/Railways";
	private static String username="postgres";
	private static String password="4321";
	public static void main(String[] args) {
		
		Connection con;
    
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver load attempt finished.");
            con=DriverManager.getConnection(url,username,password);
            System.out.println("Connected to DB");
            con.setAutoCommit(false);
            String sql="INSERT into passenger values(3,'kavi',121,'BLR','DPJ')";
            Statement stm=con.createStatement();
            stm.execute(sql);
            
            
            String sql1="INSERT into traindetail values(3,68678,'IR','BLR','DPJ')";
            stm.execute(sql1);
            
           
            String sql2="INSERT into payment Values(3,'mmm',4324)";
            stm.execute(sql2);
            if(payment.isSucess()){
            	System.out.println("Payment Successful");
                con.commit();
                }
                else
                {
                	System.out.println("Payment Failed");
                	con.rollback();
                }
        } catch (ClassNotFoundException e) {
        	
            e.printStackTrace();
        
        } catch (SQLException e) {
			
			e.printStackTrace();
			
		}
}
}
