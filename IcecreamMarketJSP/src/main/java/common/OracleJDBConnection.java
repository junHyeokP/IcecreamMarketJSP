package common;

public class OracleJDBConnection extends JDBConnection {

	public OracleJDBConnection() {
		
		final String jdbcDriverClassName = "oracle.jdbc.OracleDriver";
		final String url = "jdbc:oracle:thin:@14.36.91.107:1521:xe";
		final String userID = "c##JAVA";
		final String pwd = "1234";
				
		connectJDB(jdbcDriverClassName, url, userID, pwd);
			
	}
	
	
}
