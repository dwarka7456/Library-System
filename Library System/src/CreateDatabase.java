
import java.sql.*;

public class CreateDatabase {

		public static void main(String[] args) {
			Connection conn = null;
			try {
				String userName = "SYS as sysdba";
				String password = "SYS";
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@//localhost:1521/darkhorse";
				conn = DriverManager.getConnection(url, userName, password);
				System.out.println("Database connection successful.");
				//statement obj to formulate our sql
				Statement stmt = conn.createStatement();
				//stmt.execute("drop table authenticate");
				
				stmt.executeUpdate(
						"create table authenticate(" +
						"username char(10), password char(50)");
				
				conn.close();
				System.out.println("Table created.");
				}
			catch (Exception e) {
				System.out.println("Error creating table." + e.toString());
				e.getStackTrace();
			}
		}
	}

