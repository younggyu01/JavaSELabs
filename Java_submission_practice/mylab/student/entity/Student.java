package mylab.student.entity;

import mylab.student.exception.InvalidGradeException;

public class Student extends Object {
	private String studentId;
	private String name;
	private String major;
	private int grade;

	public Student() {
		System.out.println("기본 생성자 호출됨");
	}

	// Constructor Overloading (생성자 중복정의)
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
		//학년 범위 오류
		if (1 > grade || grade > 4) {
			String errMessage = String.format("학년은 1~4 사이여야 합니다. (입력 학년: %d)", grade);
			// Exception 강제로 발생 시킴
			throw new InvalidGradeException(errMessage);
		}
		this.grade = grade;
	}		
}
