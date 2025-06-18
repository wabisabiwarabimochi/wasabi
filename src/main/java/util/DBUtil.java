package util;

public class DBUtil {
	protected final String JDBC_URL ="jdbc:mysql://localhost/kadai1";
	protected final String DB_USER = "root";
	protected final String DB_PASS = "password";{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	}
}
