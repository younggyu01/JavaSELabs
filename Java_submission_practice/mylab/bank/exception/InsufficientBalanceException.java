package mylab.bank.exception;

// 잔액이 부족할 때 발생하는 예외 클래스
// Exception 클래스를 상속하며 오류 메시지 전달
public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}