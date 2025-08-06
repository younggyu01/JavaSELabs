package workshop.account.entity;

public class Account {
	private String custId;
	private String acctId;
	private int balance;

	// default constructor ����
	public Account() {
		System.out.println("�⺻������ ȣ���");
	}

	// Constructor Overloading (������ �ߺ� ����)
	public Account(String custId, String acctId, int balance) {
//		this.custId = custId;
//		this.acctId = acctId;
		setCustId(custId);
		setAcctId(acctId);
		this.balance = balance;
	}

//	public void setBlance(int balance) {
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
	public void withdraw(int amount) {
		this.balance -= amount;
	}
}
