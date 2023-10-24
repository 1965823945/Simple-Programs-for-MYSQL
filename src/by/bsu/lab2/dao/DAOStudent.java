package by.bsu.lab2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Statement;

import by.bsu.lab2.entity.Student;
import by.bsu.lab2.exept.DAOException;
import by.bsu.lab2.exept.JDBCConnectionException;

public class DAOStudent extends DAO {
	public static final String SELECT_ALL_FROM_STUSENTS = "select * from student";
	public static final String SELECT_COUNT_STUDENT_BY_Subject = "SELECT count(student.Id) FROM web_1.student\n"
			+ "INNER JOIN results ON results.Id_Student = student.Id\n"
			+ "INNER JOIN subject ON subject.Id = results.Id_Subject\n"
			+ "WHERE subject.Name = ?";

	public DAOStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getStudentCountBySubject(String nameSubject) throws SQLException {

		// Вставить свой код!!!

		int countStudent = 0;

		try {

			cnr.getConnection();

			PreparedStatement ps = cnr.getConnection().prepareStatement(SELECT_COUNT_STUDENT_BY_Subject);

			ps.setString(1, nameSubject);

			ResultSet rs = ps.executeQuery();

			if (rs != null)

				System.out.println("Query2 executed");

			while (rs.next()) {

				countStudent = rs.getInt(1);

				System.out.println(rs.getString(1));

			}

		}

		catch (JDBCConnectionException e) {
			throw new DAOException("Can't obtain student", e);
		}

		catch (SQLException e) {
			throw e;

			// new DAOException("Can't parse result set", e);

		}

		finally {

			try {
				cnr.close();
			}

			catch (JDBCConnectionException e)

			{
				throw new DAOException("Can't close conn", e);
			}

		}

		return countStudent;

	}

	public ArrayList<Student> readAll() throws DAOException {

		ArrayList<Student> res = new ArrayList<Student>();
		try {
			cnr.getConnection();

			ResultSet rs = getStatement().executeQuery(SELECT_ALL_FROM_STUSENTS);

			if (rs != null)
				// System.out.println("Query executed\n");
				while (rs.next()) {
					Student user = new Student();
					;
					user.setId(rs.getInt(1));
					user.setName(rs.getString(2));
					res.add(user);
					// System.out.println(rs.getString(2) + "\n");

				}

		} catch (JDBCConnectionException e) { // int key= id;
			throw new DAOException("Can't obtain student", e);
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
