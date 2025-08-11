package mylab.bank.control;

import mylab.bank.entity.Account;
import mylab.bank.entity.Bank;
import mylab.bank.entity.SavingsAccount;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

public class BankDemo {

    public static void main(String[] args) {
        // ��� ������ �����ֱ⸦ �����ϴ� Bank �ν��Ͻ� ����
        Bank bank = new Bank();

        System.out.println("=== ���� ���� ===");
        // createSavingsAccount / createCheckingAccount �� ���ο��� ���¸� �����ϰ�
        // "AC1000"ó�� �ڵ� ���� ��ȣ�� �ο��ϸ�, ���� ����� �ֿܼ� ���
        // ��ȯ���� ������ ���¹�ȣ(���ڿ�)�� ���� �ó��������� ��ȸ/�ŷ� �ĺ��� ���
        String ac1 = bank.createSavingsAccount("ȫ�浿", 10000, 3.0);   // ����(������ 3%)
        String ac2 = bank.createCheckingAccount("��ö��", 20000, 5000); // üŷ(��� �ѵ� 5,000)
        String ac3 = bank.createSavingsAccount("�̿���", 30000, 2.0);   // ����(������ 2%)
        System.out.println();

        // ���� ��� ���� ���¸� ���
        System.out.println("=== ��� ���� ��� ===");
        // Bank�� ������ List<Account> �� ��ȸ�ϸ� �� ������ toString()�� ���
        bank.printAllAccounts();

        
        System.out.println("\n=== �Ա�/��� �׽�Ʈ ===");
        try {
            // deposit, withdraw�� ���������� ��� ���¸� findAccount�� ó��
            // deposit(ac1, 5000): ȫ�浿(����) ���¿� 5,000�� �Ա�
            bank.deposit(ac1, 5000);
            // withdraw(ac2, 3000): ��ö��(üŷ) ���¿��� 3,000�� ���
            bank.withdraw(ac2, 3000);

            // AccountNotFoundException: ���¹�ȣ�� �������� �ʴ� ���
            // InsufficientBalanceException: ��� �� �ܾ� ����n�Ǵ� üŷ �ѵ� �ʰ�
        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        
        System.out.println("\n=== ���� ���� �׽�Ʈ ===");
        try {
            // Ư�� ���¹�ȣ�� ���¸� ������ ��, ���� ������ ��쿡�� ���� ����
            Account a = bank.findAccount(ac1);

            // �ڹ��� ������ Account ���۷����� ������ SavingsAccount Ÿ������ Ȯ��
            if (a instanceof SavingsAccount) {
                // �ٿ�ĳ���� �� SavingsAccount ���� ��� applyInterest() ȣ��
                SavingsAccount sa = (SavingsAccount) a;
                // ���� �ܾ� *(������/100)�� ����Ͽ� deposit()�� ���� �Ա�
                // deposit()�� �Ա� �α׸� ����ѵ� ���� ���� �α׸� ���
                sa.applyInterest();
            }
        } catch (AccountNotFoundException e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }


        System.out.println("\n=== ���� ��ü �׽�Ʈ ===");
        try {
            // ac3(�̿���, ����) �� ac2(��ö��, üŷ) �� 5,000�� �۱�
            // ���������� src.withdraw(5000) �� dst.deposit(5000) ������ ó��
            bank.transfer(ac3, ac2, 5000);

            // ���/�Ա� ��� ���� �� �ϳ��� ����
            // ��� �ܰ迡�� �ܾ� ���� �Ǵ� üŷ �ѵ� �ʰ�
        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        // ��ü �� ��ü ���� ���¸� �ٽ� Ȯ��
        System.out.println("\n=== ��� ���� ��� ===");
        bank.printAllAccounts();

        // üŷ ���� ��� �ѵ� �ʰ� 
        try {
            // üŷ ����(ac2)�� ��� �ѵ��� 5,000��
            // 6,000�� ����� WithdrawalLimitExceededException �߻�
            bank.withdraw(ac2, 6000);
        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            // "��� �ѵ��� �ʰ��߽��ϴ�. �ѵ�: 5000.0��"
            System.out.println("���� �߻�: " + e.getMessage());
        }

        // �ѵ� �ʰ� ���¿��� ��ü �õ�
        try {
            // 7,000�� �۱� �õ� �� ��� �ܰ迡�� �ѵ� �ʰ� �Ǵ� �ܾ� ���� �߻��� ����
            bank.transfer(ac2, ac3, 7000);
        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        // �������� �ʴ� ���� ��ȸ
        try {
            // ������ �������� �ʴ� ���¹�ȣ�� ��ȸ�Ͽ� ���� ����
            bank.findAccount("AC9999");
        } catch (AccountNotFoundException e) {
            // "���¹�ȣ AC9999�� �ش��ϴ� ���¸� ã�� �� �����ϴ�."
            System.out.println("���� �߻�: " + e.getMessage());
        }

    }
}