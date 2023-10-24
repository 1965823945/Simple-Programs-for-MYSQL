package by.bsu.lab2.connector;

import java.sql.*;
import java.util.ResourceBundle;

import  by.bsu.lab2.exept.JDBCConnectionException;

public class JdbcConnector {
    private Connection conn;
    public Connection getConnection() throws JDBCConnectionException {
        ConfigurationManager cfg = ConfigurationManager.getInstance();
        try {
            Class.forName(cfg.getDriver());
            conn = DriverManager.getConnection(cfg.getURL(),
            		    			cfg.getUser(),	cfg.getPass());
        } catch (ClassNotFoundException e) {
	    throw new JDBCConnectionException("Can't load database driver.", e);
        } catch (SQLException e) {
           throw new JDBCConnectionException("Can't connect to database.", e);
        }
        if(conn==null) {
            throw new JDBCConnectionException("Driver type is not correct in URL " 
            		+ cfg.getURL() + ".");
        }
        return conn;
    }

    public void close() throws JDBCConnectionException{
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {throw new JDBCConnectionException();
            }
        }
    }
   
   
    public Connection getConn() throws SQLException {
    	ResourceBundle resource = ResourceBundle.getBundle("database");
    	String url = resource.getString("url");
    	String driver = resource.getString("driver");
    	String user = resource.getString("user");
    	String pass = resource.getString("password");
    	try {
    		Class.forName(driver);
    	} catch (ClassNotFoundException e) {
    	    throw new SQLException("������� �� ��������!");
    	} 
    return DriverManager.getConnection(url, user, pass);

    }
    
    
}


