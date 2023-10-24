package by.bsu.lab2.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.bsu.lab2.exept.DAOException;

import by.bsu.lab2.dao.DAOStudent;
import by.bsu.lab2.dao.DAOSubject;
import by.bsu.lab2.entity.Student;
import by.bsu.lab2.entity.Subject;

public class Runner {

	public static void main(String[] args) throws SQLException {

		DAOStudent daoStudent = new DAOStudent();
		System.out.println("____________________________________");
		daoStudent.getStudentCountBySubject("Math");
		System.out.println("____________________________________");
		try {
			ArrayList<Student> studentList = daoStudent.readAll();
			//System.out.println(studentList);
			// printStudentList(studentList);
		} catch (DAOException e) {
			System.err.println(e);
		}

		DAOSubject daoSubject = new DAOSubject();
		System.out.println("____________________________________");
		for (String teacher : daoSubject.getTeacherWhoMultipleSubjects()) {
			System.out.println(teacher);
		}
		System.out.println("____________________________________");
		try {
			ArrayList<Subject> SubjectList = daoSubject.readAll();
			//System.out.println(SubjectList);
			// printSubjectList(SubjectList);
		} catch (DAOException e) {
			System.err.println(e);
		}
	}

	private static void printStudentList(ArrayList<Student> list) {

		for (Student st : list) {
			System.out.println(st.getId() + "   " + st.getName());
		}
	}

	private static void printSubjectList(ArrayList<Subject> list) {

		for (Subject sb : list) {
			System.out
					.println(sb.getId() + "   " + sb.getName() + "   " + sb.getTeacher() + "   " + sb.getStart_Date());
		}
	}
}
