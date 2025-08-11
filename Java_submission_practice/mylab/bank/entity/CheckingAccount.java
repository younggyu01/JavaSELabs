package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class CheckingAccount extends Account {
    // 1ȸ ��� �ѵ�, ���� �Ұ�, ���� �� ���� 
    private final double withdrawalLimit;

    // ������
    public CheckingAccount(String accountNumber, String ownerName, double initialBalance, double withdrawalLimit) {
        super(accountNumber, ownerName, initialBalance);
        if (withdrawalLimit < 0) throw new IllegalArgumentException("��� �ѵ��� ������ �� �����ϴ�.");
        this.withdrawalLimit = withdrawalLimit;
    }

    // @return 1ȸ ��� �ѵ� 
    public double getWithdrawalLimit() { return withdrawalLimit; }

    //���(�ѵ� �˻� + �ܾ� �˻�)
    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > withdrawalLimit) {
            throw new WithdrawalLimitExceededException(
                String.format("��� �ѵ��� �ʰ��߽��ϴ�. �ѵ�: %.1f��", withdrawalLimit)
            );
        }
        // �ѵ� �̳��̸� ���� ��� ������ �θ𿡰�
        super.withdraw(amount);
    }

    // ���
    @Override
    public String toString() {
        return String.format("%s, ��� �ѵ�: %.1f��", super.toString(), withdrawalLimit);
    }
}