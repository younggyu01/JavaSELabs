package mylab.bank.exception;

// ��� �ѵ��� �ʰ��� �� �߻��ϴ� ���� Ŭ����
// InsufficientBalanceException Ŭ������ ����ϸ� ���� �޽��� ����
public class WithdrawalLimitExceededException extends InsufficientBalanceException {
 public WithdrawalLimitExceededException(String message) {
     super(message);
 }
}