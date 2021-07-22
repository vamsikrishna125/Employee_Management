package repositories;
import java.sql.*;
public class DataStore {
private String jdbcURL;
private String jdbcUsername;
private String jdbcPassword;
private Connection jdbcConnection;

public DataStore (String jdbcURL, String jdbcUsername, String jdbcPassword) {
this.jdbcURL = jdbcURL;
this.jdbcUsername = jdbcUsername;
this.jdbcPassword = jdbcPassword;
    }

protected Connection connect() throws SQLException {
if (jdbcConnection == null || jdbcConnection.isClosed()) {
try {
       Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
    	throw new SQLException(e);
        }
    jdbcConnection = DriverManager.getConnection(
    jdbcURL, jdbcUsername, jdbcPassword);
    return jdbcConnection;
 }
else
	return null;
    }

protected void disconnect() throws SQLException {
      if (jdbcConnection != null&& !jdbcConnection.isClosed()) {
           jdbcConnection.close();
        }
    }
}
