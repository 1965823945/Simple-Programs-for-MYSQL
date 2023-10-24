SELECT subject.Teacher FROM subject 
	GROUP BY teacher HAVING count(id)>1;