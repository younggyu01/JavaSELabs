package mylab.bank.exception;

// ���¸� ã�� �� ���� �� �߻��ϴ� ���� Ŭ����
// Exception Ŭ������ ����ϸ� ���� �޽��� ����
public class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String message) {
        super(message);
    }
}