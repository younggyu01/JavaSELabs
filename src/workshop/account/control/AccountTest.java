package workshop.account.control;

import workshop.account.entity.Account;
import workshop.account.exception.InsufficientBalanceException;

public class AccountTest {

	public static void main(String[] args) {
		//1. Account ��ü���� - �⺻������ ȣ��
		Account account = new Account();
		
		//1-1. setter �޼��� ȣ��� ���� ����
		//����ȣ : "A1100", ���¹�ȣ : "221-22-3477", �ܾ� : 100
		account.setCustId("A1100");
		account.setAcctId("221-22-3477");
		account.deposit(1000);
		
		//1-2. getter �޼��� ȣ��� ���� Ȯ��
		System.out.println("����ȣ = " + account.getCustId());
		System.out.println("���¹�ȣ = " + account.getAcctId());
		System.out.println("�ܾ� = "    + account.getBalance());
		
		//2.Account ��ü���� - �����ε��� ������ ȣ��
		Account account2 = new Account("B1200", "331-22-3477", 2000);
		System.out.println("����ȣ = " + account2.getCustId());
		System.out.println("���¹�ȣ = " + account2.getAcctId());
		System.out.println("�ܾ� = "    + account2.getBalance());
		
		System.out.println("10000�� �Ա�");
		account2.deposit(10000);
		System.out.println("�ܾ� = "    + account2.getBalance());
		
		try {
			System.out.println("10000�� ���");
			account2.withdraw(10000);
			System.out.println("�ܾ� = " + account2.getBalance());
			
			System.out.println("5000�� ���");
			account2.withdraw(5000);
			System.out.println("�ܾ� = "    + account2.getBalance());
		} catch (InsufficientBalanceException e) {
			System.out.println(e.getMessage());
		}

	}

}