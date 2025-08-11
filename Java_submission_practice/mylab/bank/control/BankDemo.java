package mylab.bank.control;

import mylab.bank.entity.Account;
import mylab.bank.entity.Bank;
import mylab.bank.entity.SavingsAccount;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

public class BankDemo {

    public static void main(String[] args) {
        // 모든 계좌의 생명주기를 관리하는 Bank 인스턴스 생성
        Bank bank = new Bank();

        System.out.println("=== 계좌 생성 ===");
        // createSavingsAccount / createCheckingAccount 는 내부에서 계좌를 생성하고
        // "AC1000"처럼 자동 증가 번호를 부여하며, 생성 결과를 콘솔에 출력
        // 반환값은 생성된 계좌번호(문자열)로 이후 시나리오에서 조회/거래 식별에 사용
        String ac1 = bank.createSavingsAccount("홍길동", 10000, 3.0);   // 저축(이자율 3%)
        String ac2 = bank.createCheckingAccount("김철수", 20000, 5000); // 체킹(출금 한도 5,000)
        String ac3 = bank.createSavingsAccount("이영희", 30000, 2.0);   // 저축(이자율 2%)
        System.out.println();

        // 현재 모든 계좌 상태를 출력
        System.out.println("=== 모든 계좌 목록 ===");
        // Bank가 보유한 List<Account> 를 순회하며 각 계좌의 toString()을 출력
        bank.printAllAccounts();

        
        System.out.println("\n=== 입금/출금 테스트 ===");
        try {
            // deposit, withdraw는 내부적으로 대상 계좌를 findAccount로 처리
            // deposit(ac1, 5000): 홍길동(저축) 계좌에 5,000원 입금
            bank.deposit(ac1, 5000);
            // withdraw(ac2, 3000): 김철수(체킹) 계좌에서 3,000원 출금
            bank.withdraw(ac2, 3000);

            // AccountNotFoundException: 계좌번호가 존재하지 않는 경우
            // InsufficientBalanceException: 출금 시 잔액 부족n또는 체킹 한도 초과
        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        
        System.out.println("\n=== 이자 적용 테스트 ===");
        try {
            // 특정 계좌번호로 계좌를 가져온 뒤, 저축 계좌인 경우에만 이자 적용
            Account a = bank.findAccount(ac1);

            // 자바의 다형성 Account 레퍼런스가 실제로 SavingsAccount 타입인지 확인
            if (a instanceof SavingsAccount) {
                // 다운캐스팅 후 SavingsAccount 고유 기능 applyInterest() 호출
                SavingsAccount sa = (SavingsAccount) a;
                // 현재 잔액 *(이자율/100)을 계산하여 deposit()을 통해 입금
                // deposit()이 입금 로그를 출력한뒤 이자 적용 로그를 출력
                sa.applyInterest();
            }
        } catch (AccountNotFoundException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }


        System.out.println("\n=== 계좌 이체 테스트 ===");
        try {
            // ac3(이영희, 저축) → ac2(김철수, 체킹) 로 5,000원 송금
            // 내부적으로 src.withdraw(5000) → dst.deposit(5000) 순서로 처리
            bank.transfer(ac3, ac2, 5000);

            // 출금/입금 대상 계좌 중 하나라도 없음
            // 출금 단계에서 잔액 부족 또는 체킹 한도 초과
        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        // 이체 후 전체 계좌 상태를 다시 확인
        System.out.println("\n=== 모든 계좌 목록 ===");
        bank.printAllAccounts();

        // 체킹 계좌 출금 한도 초과 
        try {
            // 체킹 계좌(ac2)의 출금 한도는 5,000원
            // 6,000원 출금은 WithdrawalLimitExceededException 발생
            bank.withdraw(ac2, 6000);
        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            // "출금 한도를 초과했습니다. 한도: 5000.0원"
            System.out.println("예외 발생: " + e.getMessage());
        }

        // 한도 초과 상태에서 이체 시도
        try {
            // 7,000원 송금 시도 후 출금 단계에서 한도 초과 또는 잔액 부족 발생해 예외
            bank.transfer(ac2, ac3, 7000);
        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        // 존재하지 않는 계좌 조회
        try {
            // 실제로 존재하지 않는 계좌번호를 조회하여 예외 유도
            bank.findAccount("AC9999");
        } catch (AccountNotFoundException e) {
            // "계좌번호 AC9999에 해당하는 계좌를 찾을 수 없습니다."
            System.out.println("예외 발생: " + e.getMessage());
        }

    }
}