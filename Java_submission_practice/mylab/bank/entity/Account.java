package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

public abstract class Account {
    // 계좌번호(불변)
    private final String accountNumber;
    // 소유자 이름(불변)
    private final String ownerName;
    // 현재 잔액(가변, 하위 타입에서 접근 가능)
    protected double balance;

    protected Account(String accountNumber, String ownerName, double initialBalance) {
        // 식별자,이름 null 불가
        if (accountNumber == null || ownerName == null) {
            throw new IllegalArgumentException("계좌번호/소유자 이름은 null일 수 없습니다.");
        }
        // 초기 잔액 음수 불가
        if (initialBalance < 0) {
            throw new IllegalArgumentException("초기 잔액은 음수일 수 없습니다.");
        }
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    // @return 계좌번호(불변)
    public String getAccountNumber() { return accountNumber; }

    // @return 소유자 이름(불변)
    public String getOwnerName() { return ownerName; }

    // @return 현재 잔액 
    public double getBalance() { return balance; }

    
    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("입금액은 0보다 커야 합니다.");
        balance += amount;
        System.out.printf("%.1f원이 입금되었습니다. 현재 잔액: %.1f원%n", amount, balance);
    }

    
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0) throw new IllegalArgumentException("출금액은 0보다 커야 합니다.");
        if (balance < amount) {
            throw new InsufficientBalanceException(
                String.format("잔액이 부족합니다. 현재 잔액: %.1f원", balance)
            );
        }
        balance -= amount;
        System.out.printf("%.1f원이 출금되었습니다. 현재 잔액: %.1f원%n", amount, balance);
    }

    @Override
    public String toString() {
        return String.format("계좌번호: %s, 소유자: %s, 잔액: %.1f원", accountNumber, ownerName, balance);
    }
}