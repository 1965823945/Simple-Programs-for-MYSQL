package lab3.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lab3.exept.DAOException;

import lab3.dao.DAOStudent;
import lab3.dao.DAOSubject;
import lab3.entity.Student;
import lab3.entity.Subject;

public class Runner {

	public static void main(String[] args) throws SQLException {

		DAOStudent daoStudent = new DAOStudent();
		System.out.println("##1——————————————————————————————————————");

		daoStudent.getStudentCountBySubject("Math");
		System.out.println("##2——————————————————————————————————————");
		try {
			ArrayList<Student> studentList = daoStudent.readAll();
			// System.out.println(studentList);
			printStudentList(studentList);
		} catch (DAOException e) {
			System.err.println(e);
		}
		daoStudent.selectStudent(1);

		System.out.println("##3——————————————————————————————————————");
		DAOSubject daoSubject = new DAOSubject();
		// for (String teacher : daoSubject.getTeacherWhoMultipleSubjects()) {
		// System.out.println(teacher);
		// }
		daoSubject.CreateNewSubject("Franch", "Bolof", "2023.10.20");
		try {
			ArrayList<Subject> SubjectList = daoSubject.readAll();
			// System.out.println(SubjectList);
			printSubjectList(SubjectList);
		} catch (DAOException e) {
			System.err.println(e);
		}
		System.out.println("##4——————————————————————————————————————");
		daoSubject.ChangeStartDate(7, "2023-10-01");
		try {
			ArrayList<Subject> SubjectList = daoSubject.readAll();
			// System.out.println(SubjectList);
			printSubjectList(SubjectList);
		} catch (DAOException e) {
			System.err.println(e);
		}
		System.out.println("##5——————————————————————————————————————");
		daoSubject.DeleteSubject(7);
		try {
			ArrayList<Subject> SubjectList = daoSubject.readAll();
			// System.out.println(SubjectList);
			printSubjectList(SubjectList);
		} catch (DAOException e) {
			System.err.println(e);
		}
	}
	private static void printStudentList(ArrayList<Student> list) {
		System.out.println("Student List: ");
		for (Student st : list) {
			System.out.println(st.getId() + "   " + st.getName());
		}
	}

	private static void printSubjectList(ArrayList<Subject> list) {
		System.out.println("Subject List: ");
		for (Subject sb : list) {
			System.out
					.println(sb.getId() + "   " + sb.getName() + "   " + sb.getTeacher() + "   " + sb.getStart_Date());
		}
	}
}
