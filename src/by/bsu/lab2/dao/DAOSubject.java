package by.bsu.lab2.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Statement;

import by.bsu.lab2.entity.Subject;
import by.bsu.lab2.exept.DAOException;
import by.bsu.lab2.exept.JDBCConnectionException;

public class DAOSubject extends DAO {
	public static final String SELECT_ALL_FROM_SUBJECTS = "select * from subject";
	public static final String TEACHER_OF_TEACHNG_MULTIPLE_SUBJECTS = "SELECT subject.Teacher FROM subject \n" +
			"\tGROUP BY teacher HAVING count(id)>1";

	public DAOSubject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<String> getTeacherWhoMultipleSubjects() throws DAOException {
		ArrayList<String> res = new ArrayList<String>();
		try {
			cnr.getConnection();
			ResultSet rs = getStatement().executeQuery(TEACHER_OF_TEACHNG_MULTIPLE_SUBJECTS);

			if (rs != null)
				System.out.println("Query3 executed");
			while (rs.next()) {
				res.add(rs.getString(1));

			}

		} catch (JDBCConnectionException e) {
			throw new DAOException("Can't obtain student", e);
		} catch (SQLException e) {
			throw new DAOException("Can't parse result set", e);
		} finally {
			try {
				cnr.close();
			}

			catch (JDBCConnectionException e)

			{
				throw new DAOException("Can't close conn", e);
			}

		}
		return res;
	}

	public ArrayList<Subject> readAll() throws DAOException {

		ArrayList<Subject> res = new ArrayList<Subject>();
		try {
			cnr.getConnection();

			ResultSet rs = getStatement().executeQuery(SELECT_ALL_FROM_SUBJECTS);

			if (rs != null)
				// System.out.println("Query executed\n");
				while (rs.next()) {
					Subject user = new Subject();
					;
					user.setId(rs.getInt(1));
					user.setName(rs.getString(2));
					user.setTeacher(rs.getString(3));
					user.setStart_Date(rs.getString(4));
					res.add(user);
					// System.out.println(rs.getString(2) + "\n");

				}

		} catch (JDBCConnectionException e) { // int key= id;
			throw new DAOException("Can't obtain subject", e);
		} catch (SQLException e) {
			throw new DAOException("Can't parse result set", e);
		} finally {
			try {
				cnr.close();
			} catch (JDBCConnectionException e) {
				throw new DAOException("Can't  close  conn", e);
			}
		}
		return res;
	}

}
