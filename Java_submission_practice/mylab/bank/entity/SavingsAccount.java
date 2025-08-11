package mylab.bank.entity;

public class SavingsAccount extends Account {
    // 이자율(%) 3.0 = 3%
    private final double interestRate;

    //생성자
    public SavingsAccount(String accountNumber, String ownerName, double initialBalance, double interestRate) {
        super(accountNumber, ownerName, initialBalance);
        if (interestRate < 0) throw new IllegalArgumentException("이자율은 음수일 수 없습니다.");
        this.interestRate = interestRate;
    }

    //@return 이자율(%)
    public double getInterestRate() { return interestRate; }

    // 이자 적용
    public void applyInterest() {
        double interest = getBalance() * (interestRate / 100.0);
        deposit(interest); // 공통 검증,출력 로직을 재사용
        System.out.printf("이자 %.1f원이 적용되었습니다. 현재 잔액: %.1f원%n", interest, getBalance());
    }

    // 출력
    @Override
    public String toString() {
        return String.format("%s, 이자율: %.1f%%", super.toString(), interestRate);
    }
}