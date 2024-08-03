import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conn {

	public static void main(String[] args) {
		
		try {
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/minphyo","minminphyo","minminphyo!@#$%^&*");
			System.out.println(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
