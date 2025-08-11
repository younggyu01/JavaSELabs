package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;

import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

public class Bank {
    // ������ �����ϴ� ���� ��� (�ռ� ����)
    private final List<Account> accounts = new ArrayList<>();
    // �� ���¿� �ο��� ���� ��ȣ
    private int nextAccountNumber = 1000;

    private boolean firstSavingsPrinted = false;


    // ���� ���¹�ȣ ���� ��ƿ��Ƽ
    // @return "AC" + ���� ��ȣ
    private String nextNumber() {
        return "AC" + (nextAccountNumber++);
    }

    //����(Savings) ���� ����
    public String createSavingsAccount(String ownerName, double initialBalance, double interestRate) {
        String no = nextNumber();
        SavingsAccount acc = new SavingsAccount(no, ownerName, initialBalance, interestRate);
        accounts.add(acc);

        String prefix;
        if (!firstSavingsPrinted) {
            prefix = "Saving(����) ���°� �����Ǿ����ϴ�: ";
            firstSavingsPrinted = true;
        } else {
            prefix = "���� ���°� �����Ǿ����ϴ�: ";
        }
        System.out.println(prefix + acc);

        return no;
    }

    //üŷ(Checking) ���� ����
    public String createCheckingAccount(String ownerName, double initialBalance, double withdrawalLimit) {
        String no = nextNumber();
        CheckingAccount acc = new CheckingAccount(no, ownerName, initialBalance, withdrawalLimit);
        accounts.add(acc);
        System.out.println("üŷ ���°� �����Ǿ����ϴ�: " + acc);
        return no;
    }

    // ���¹�ȣ�� ���� ��ȸ
    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        for (Account a : accounts) {
            if (a.getAccountNumber().equals(accountNumber)) return a;
        }
        throw new AccountNotFoundException(
            String.format("���¹�ȣ %s�� �ش��ϴ� ���¸� ã�� �� �����ϴ�.", accountNumber)
        );
    }


    // �Ա�
    public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
        findAccount(accountNumber).deposit(amount);
    }

    // ���
    public void withdraw(String accountNumber, double amount)
            throws AccountNotFoundException, InsufficientBalanceException {
        findAccount(accountNumber).withdraw(amount);
    }

    // ��ü
    public void transfer(String fromAccount, String toAccount, double amount)
            throws AccountNotFoundException, InsufficientBalanceException {
        Account src = findAccount(fromAccount);
        Account dst = findAccount(toAccount);
        src.withdraw(amount);
        dst.deposit(amount);
        System.out.printf("%.1f���� %s���� %s�� �۱ݵǾ����ϴ�.%n", amount, fromAccount, toAccount);
    }

    // ��� ���� ���� ���
    public void printAllAccounts() {
        for (Account a : accounts) {
            System.out.println(a);
        }
        System.out.println("===================");
    }
}