package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;

import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

public class Bank {
    // 은행이 관리하는 계좌 목록 (합성 관계)
    private final List<Account> accounts = new ArrayList<>();
    // 새 계좌에 부여할 다음 번호
    private int nextAccountNumber = 1000;

    private boolean firstSavingsPrinted = false;


    // 내부 계좌번호 생성 유틸리티
    // @return "AC" + 증가 번호
    private String nextNumber() {
        return "AC" + (nextAccountNumber++);
    }

    //저축(Savings) 계좌 생성
    public String createSavingsAccount(String ownerName, double initialBalance, double interestRate) {
        String no = nextNumber();
        SavingsAccount acc = new SavingsAccount(no, ownerName, initialBalance, interestRate);
        accounts.add(acc);

        String prefix;
        if (!firstSavingsPrinted) {
            prefix = "Saving(저축) 계좌가 생성되었습니다: ";
            firstSavingsPrinted = true;
        } else {
            prefix = "저축 계좌가 생성되었습니다: ";
        }
        System.out.println(prefix + acc);

        return no;
    }

    //체킹(Checking) 계좌 생성
    public String createCheckingAccount(String ownerName, double initialBalance, double withdrawalLimit) {
        String no = nextNumber();
        CheckingAccount acc = new CheckingAccount(no, ownerName, initialBalance, withdrawalLimit);
        accounts.add(acc);
        System.out.println("체킹 계좌가 생성되었습니다: " + acc);
        return no;
    }

    // 계좌번호로 계좌 조회
    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        for (Account a : accounts) {
            if (a.getAccountNumber().equals(accountNumber)) return a;
        }
        throw new AccountNotFoundException(
            String.format("계좌번호 %s에 해당하는 계좌를 찾을 수 없습니다.", accountNumber)
        );
    }


    // 입금
    public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
        findAccount(accountNumber).deposit(amount);
    }

    // 출금
    public void withdraw(String accountNumber, double amount)
            throws AccountNotFoundException, InsufficientBalanceException {
        findAccount(accountNumber).withdraw(amount);
    }

    // 이체
    public void transfer(String fromAccount, String toAccount, double amount)
            throws AccountNotFoundException, InsufficientBalanceException {
        Account src = findAccount(fromAccount);
        Account dst = findAccount(toAccount);
        src.withdraw(amount);
        dst.deposit(amount);
        System.out.printf("%.1f원이 %s에서 %s로 송금되었습니다.%n", amount, fromAccount, toAccount);
    }

    // 모든 계좌 정보 출력
    public void printAllAccounts() {
        for (Account a : accounts) {
            System.out.println(a);
        }
        System.out.println("===================");
    }
}