package mylab.bank.exception;

// 계좌를 찾을 수 없을 때 발생하는 예외 클래스
// Exception 클래스를 상속하며 오류 메시지 전달
public class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) {
        super(message);
    }
}