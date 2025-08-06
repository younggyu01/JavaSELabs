package mylab.student.entity;

import mylab.student.exception.InvalidGradeException;

public class Student extends Object {
	private String studentId;
	private String name;
	private String major;
	private int grade;

	public Student() {
		System.out.println("�⺻ ������ ȣ���");
	}

	// Constructor Overloading (������ �ߺ�����)
	public Student(String studentId, String name, String major, int grade) {
		//this.studentId = studentId;
		//this.name = name;
		//this.major = major;
		setStudentId(studentId);
		setName(name);
		setMajor(major);
		this.grade = grade;
	}

	public String getStudentId() {
		return studentId;
	}

	public String getName() {
		return name;
	}

	public String getMajor() {
		return major;
	}

	public int getGrade() {
		return grade;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public void setGrade(int grade) throws InvalidGradeException {
		//�г� ���� ����
		if (1 > grade || grade > 4) {
			String errMessage = String.format("�г��� 1~4 ���̿��� �մϴ�. (�Է� �г�: %d)", grade);
			// Exception ������ �߻� ��Ŵ
			throw new InvalidGradeException(errMessage);
		}
		this.grade = grade;
	}		
}
