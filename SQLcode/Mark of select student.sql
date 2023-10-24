SELECT student.name, subject.name, results.Mark
FROM student
INNER JOIN results ON student.id = results.id_student
INNER JOIN subject ON subject.id = results.id_subject
WHERE student.id = 1;