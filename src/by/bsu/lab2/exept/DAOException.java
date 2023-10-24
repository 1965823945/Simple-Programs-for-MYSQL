package by.bsu.lab2.exept;

import java.sql.SQLException;

public class DAOException extends SQLException{

	public DAOException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DAOException(String arg0,  int arg2, JDBCConnectionException arg3) {
	//	super(arg0,  arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public DAOException(String arg0, Exception arg3) {
		//super(arg0, arg1, arg2);
		// TODO Auto-generated constructor stub
	}

}
