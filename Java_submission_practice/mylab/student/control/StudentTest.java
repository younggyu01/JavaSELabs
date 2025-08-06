package mylab.student.control;

import mylab.student.entity.Student;
import mylab.student.exception.InvalidGradeException;

public class StudentTest {

	public static void main(String[] args) {
		// Student 객체생성 - 기본생성자 호출
		Student student = new Student();
		
		student.setName("김민수");
		student.setMajor("컴퓨터공학");
		
	try {
		student.setGrade(3);
		System.out.println(student.getName() + "/" + student.getMajor() + "/" + student.getGrade() + "학년");
		student.setGrade(5);
	} catch (InvalidGradeException e) {
		System.out.println(e.getMessage());
	}
	
	}
}
// 김민수 / 컴퓨터공학 / 3학년
// 5학년으로 변경 
// 학년은 1~4 사이여야 합니다.

