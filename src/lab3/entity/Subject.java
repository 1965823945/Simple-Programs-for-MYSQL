package lab3.entity;

public class Subject {
	private int id;
	private String name;
	private String teacher;
	private String Start_Date;

	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subject(int id, String name, String teacher, String Start_Date) {
		super();
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.Start_Date = Start_Date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getStart_Date() {
		return Start_Date;
	}

	public void setStart_Date(String Start_Date) {
		this.Start_Date = Start_Date;
	}
}
