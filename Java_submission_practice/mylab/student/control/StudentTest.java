package mylab.student.control;

import mylab.student.entity.Student;
import mylab.student.exception.InvalidGradeException;

public class StudentTest {

	public static void main(String[] args) {
		// Student ��ü���� - �⺻������ ȣ��
		Student student = new Student();
		
		student.setName("��μ�");
		student.setMajor("��ǻ�Ͱ���");
		
	try {
		student.setGrade(3);
		System.out.println(student.getName() + "/" + student.getMajor() + "/" + student.getGrade() + "�г�");
		student.setGrade(5);
	} catch (InvalidGradeException e) {
		System.out.println(e.getMessage());
	}
	
	}
}
// ��μ� / ��ǻ�Ͱ��� / 3�г�
// 5�г����� ���� 
// �г��� 1~4 ���̿��� �մϴ�.

