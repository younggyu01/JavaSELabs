package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

public abstract class Account {
    // ���¹�ȣ(�Һ�)
    private final String accountNumber;
    // ������ �̸�(�Һ�)
    private final String ownerName;
    // ���� �ܾ�(����, ���� Ÿ�Կ��� ���� ����)
    protected double balance;

    protected Account(String accountNumber, String ownerName, double initialBalance) {
        // �ĺ���,�̸� null �Ұ�
        if (accountNumber == null || ownerName == null) {
            throw new IllegalArgumentException("���¹�ȣ/������ �̸��� null�� �� �����ϴ�.");
        }
        // �ʱ� �ܾ� ���� �Ұ�
        if (initialBalance < 0) {
            throw new IllegalArgumentException("�ʱ� �ܾ��� ������ �� �����ϴ�.");
        }
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    // @return ���¹�ȣ(�Һ�)
    public String getAccountNumber() { return accountNumber; }

    // @return ������ �̸�(�Һ�)
    public String getOwnerName() { return ownerName; }

    // @return ���� �ܾ� 
    public double getBalance() { return balance; }

    
    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("�Աݾ��� 0���� Ŀ�� �մϴ�.");
        balance += amount;
        System.out.printf("%.1f���� �ԱݵǾ����ϴ�. ���� �ܾ�: %.1f��%n", amount, balance);
    }

    
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) throw new IllegalArgumentException("��ݾ��� 0���� Ŀ�� �մϴ�.");
        if (balance < amount) {
            throw new InsufficientBalanceException(
                String.format("�ܾ��� �����մϴ�. ���� �ܾ�: %.1f��", balance)
            );
        }
        balance -= amount;
        System.out.printf("%.1f���� ��ݵǾ����ϴ�. ���� �ܾ�: %.1f��%n", amount, balance);
    }

    @Override
    public String toString() {
        return String.format("���¹�ȣ: %s, ������: %s, �ܾ�: %.1f��", accountNumber, ownerName, balance);
    }
}