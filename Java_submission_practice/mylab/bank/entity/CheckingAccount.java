package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class CheckingAccount extends Account {
    // 1회 출금 한도, 음수 불가, 생성 시 고정 
    private final double withdrawalLimit;

    // 생성자
    public CheckingAccount(String accountNumber, String ownerName, double initialBalance, double withdrawalLimit) {
        super(accountNumber, ownerName, initialBalance);
        if (withdrawalLimit < 0) throw new IllegalArgumentException("출금 한도는 음수일 수 없습니다.");
        this.withdrawalLimit = withdrawalLimit;
    }

    // @return 1회 출금 한도 
    public double getWithdrawalLimit() { return withdrawalLimit; }

    //출금(한도 검사 + 잔액 검사)
    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > withdrawalLimit) {
            throw new WithdrawalLimitExceededException(
                String.format("출금 한도를 초과했습니다. 한도: %.1f원", withdrawalLimit)
            );
        }
        // 한도 이내이면 공통 출금 로직을 부모에게
        super.withdraw(amount);
    }

    // 출력
    @Override
    public String toString() {
        return String.format("%s, 출금 한도: %.1f원", super.toString(), withdrawalLimit);
    }
}