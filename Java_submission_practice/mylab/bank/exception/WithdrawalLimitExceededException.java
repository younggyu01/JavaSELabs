package mylab.bank.exception;

// 출금 한도를 초과할 때 발생하는 예외 클래스
// InsufficientBalanceException 클래스를 상속하며 오류 메시지 전달
public class WithdrawalLimitExceededException extends InsufficientBalanceException {
 public WithdrawalLimitExceededException(String message) {
     super(message);
 }
}