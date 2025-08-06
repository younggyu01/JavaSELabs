package mylab.student.exception;

public class InvalidGradeException extends Exception{
	public InvalidGradeException(String errMessage) {
		//부모클래스 (Exception)의 생성자를 호출하기
		super(errMessage);
	}

}
