package common;

public class JDBCTest {

	public static void main(String[] args) {
		JDBConnection jdbc = new OracleJDBConnection();
		jdbc.close();

	}

}
