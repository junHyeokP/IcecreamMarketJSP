package common;

public class OracleJDBConnection extends JDBConnection {

	public OracleJDBConnection() {
		
		final String jdbcDriverClassName = "oracle.jdbc.OracleDriver";
		final String url = "jdbc:oracle:thin:@211.184.35.213:1521:xe";
		final String userID = "c##JAVA";
		final String pwd = "1234";
				
		connectJDB(jdbcDriverClassName, url, userID, pwd);
			
	}
	
	
}
