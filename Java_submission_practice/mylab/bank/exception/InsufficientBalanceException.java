package mylab.bank.exception;

// �ܾ��� ������ �� �߻��ϴ� ���� Ŭ����
// Exception Ŭ������ ����ϸ� ���� �޽��� ����
public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}