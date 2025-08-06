package workshop.account.entity;

import workshop.account.exception.InsufficientBalanceException;

public class Account extends Object {
	private String custId;
	private String acctId;
	private int balance;

	// default constructor ����
	public Account() {
		System.out.println("�⺻������ ȣ���");
	}

	// Constructor Overloading (������ �ߺ�����)
	public Account(String custId, String acctId, int balance) {
		//this.custId = custId;
		//this.acctId = acctId;
		setCustId(custId);
		setAcctId(acctId);
		this.balance = balance;
	}

//	public void setBalance(int balance) {
//		this.balance = balance;
//	}

	public int getBalance() {
		return balance;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}

	public String getAcctId() {
		return acctId;
	}

	// �Ա�
	public void deposit(int amount) {
		this.balance += amount;
	}

	// ���
	public void withdraw(int amount) throws InsufficientBalanceException {
		//�ܾ׺���
		if(amount > this.balance) {
			String errMessage = String.format("�ܾ��� �����մϴ�. (��û �ݾ�: %d, ���� �ܾ�: %d)", amount, this.balance);
			//Exception ������ �߻� ��Ŵ
			throw new InsufficientBalanceException(errMessage);
		}
		this.balance -= amount;
	}
}