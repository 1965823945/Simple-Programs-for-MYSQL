package lab3.exept;

import java.sql.SQLException;

public class JDBCConnectionException extends SQLException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JDBCConnectionException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JDBCConnectionException(String err, Throwable arg1) {
		super(err, arg1);
		// TODO Auto-generated constructor stub
	}

	public JDBCConnectionException(String err) {
		super(err);
		// TODO Auto-generated constructor stub
	}
	
	
	

}
