package lab3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.crypto.Data;

import com.mysql.cj.xdevapi.Statement;

import lab3.entity.Subject;
import lab3.exept.DAOException;
import lab3.exept.JDBCConnectionException;

public class DAOSubject extends DAO {
	public static final String SELECT_ALL_FROM_SUBJECTS = "select * from subject";
	public static final String TEACHER_OF_TEACHNG_MULTIPLE_SUBJECTS = "SELECT subject.Teacher FROM subject \n" +
			"\tGROUP BY teacher HAVING count(id)>1";
	public static final String SELECT_MAX_ID = "SELECT max(id) FROM Subject";
	public static final String CREATE_NEW_SUBJECT = "INSERT INTO subject (id,name,teacher,Start_Date) \n" +
			"VALUES (?,?,?,?)";
	public static final String CHANGE_STAR_DATE = "UPDATE subject\n" +
			"SET Start_Date = ?\n" +
			"WHERE id = ?";
	public static final String DELETE_SUBJECT = "DELETE FROM subject\n" + //
			"WHERE id = ?";


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
				System.out.println("get Teacher Who Multiple Subjects");
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

	public void CreateNewSubject(String nameSubject, String teacher, String startDate) throws SQLException {
		int maxID = 0;
		try {
			cnr.getConnection();
			PreparedStatement ps = cnr.getConnection().prepareStatement(SELECT_MAX_ID);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				System.out.println("Create New Subject");
			}
			while (rs.next()) {
				maxID = rs.getInt(1);
				System.out.println(maxID+1+" "+nameSubject+" "+teacher+" "+startDate);
			}
			ps = cnr.getConnection().prepareStatement(CREATE_NEW_SUBJECT);
			ps.setInt(1, maxID + 1);
			ps.setString(2, nameSubject);
			ps.setString(3, teacher);
			ps.setString(4, startDate); // 设置开始日期
			ps.executeUpdate();
		} 
		catch (JDBCConnectionException e) {
			throw new DAOException("Can't obtain student", e);
		}
		catch (SQLException e) {
			throw e;
		} 
		finally {
			try {
				cnr.close();
			}
			catch (JDBCConnectionException e) {
				throw new DAOException("Can't close conn", e);
			}
		}
	}


	public void ChangeStartDate(int projectId, String newStartDate) throws SQLException {
		
		try (Connection connection = cnr.getConnection();
			 PreparedStatement statement = connection.prepareStatement(CHANGE_STAR_DATE)) {
			
			statement.setString(1, newStartDate);
			statement.setInt(2, projectId);
			
			int rowsAffected = statement.executeUpdate();
			
			if (rowsAffected > 0) {
				System.out.println("The start date has been successfully updated!");
			} else {
				System.out.println("No matching Project ID found. start date not updated。");
			}
		} catch (JDBCConnectionException e) {
			throw new DAOException("Can't obtain student", e);
		} catch (SQLException e) {
			throw e;
		} finally {
			try {
				cnr.close();
			} catch (JDBCConnectionException e) {
				throw new DAOException("Can't close conn", e);
			}
		}
	}


	public void DeleteSubject(int projectId) throws SQLException {
		
		try (Connection connection = cnr.getConnection();
			 PreparedStatement statement = connection.prepareStatement(DELETE_SUBJECT)) {
			
			statement.setInt(1, projectId);
			
			int rowsAffected = statement.executeUpdate();
			
			if (rowsAffected > 0) {
				System.out.println("Item has been successfully deleted!");
			} else {
				System.out.println("No matching Project ID was found. project was not deleted.");
			}
		} catch (JDBCConnectionException e) {
			throw new DAOException("Can't obtain student", e);
		} catch (SQLException e) {
			throw e;
		} finally {
			try {
				cnr.close();
			} catch (JDBCConnectionException e) {
				throw new DAOException("Can't close conn", e);
			}
		}
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
