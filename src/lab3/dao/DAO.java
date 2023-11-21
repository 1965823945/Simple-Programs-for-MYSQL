package lab3.dao;

//import igilab2.db.connectionpool.ConnectionPool;

import java.sql.*;

import lab3.connector.JdbcConnector;
import lab3.exept.*;

public class DAO {
private Statement statement;
protected JdbcConnector cnr;

  

public DAO()
       // throws JDBCConnectionException 
{
	super();
	try{
		this.cnr=new JdbcConnector();
		this.statement= this.cnr.getConnection().createStatement();
	//	statement = cn.createStatement();
	}
	catch (SQLException e){
		System.out.println("Error Statement" +e);
		//throw new JDBCConnectionException("Can't create statement", e);
							}
}

/*protected Connection getConnection() throws SQLException, ClassNotFoundException {
//    ConnectionPool pool = ConnectionPool.getInstance();
    return .getConnection();
}
*/

public Statement getStatement() {
	return statement;
}
public void close() {
    if (statement != null) {
        try {
        	statement.close();
        } catch (SQLException e) {
        }
    }
}
}