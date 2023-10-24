SELECT count(student.Id) FROM web_1.student
	INNER JOIN results ON results.Id_Student = student.Id
    INNER JOIN subject ON subject.Id = results.Id_Subject
WHERE subject.Name = "Math";