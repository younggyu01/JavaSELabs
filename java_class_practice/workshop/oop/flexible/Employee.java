package workshop.oop.flexible;

/*
 * �߻�Ŭ������ ��ü�� ������ �� ����. 
 * Employee e = new Employee(); (x)
 * Employee m = new Manger(); (O)
 * �߻�޼��带 �ϳ� �̻� ������ ������ ������ �߻�Ŭ������ �ȴ�.
 * Super Ŭ������ �޼��尡  �߻�޼����̸� , Sub Ŭ�������� �� �߻�޼��带 
 * �ݵ�� �������̵� �ؾ� �Ѵ�. 
 */
public abstract class Employee extends Object {

	private String name;
	protected double salary;

	public Employee() {
	}
	
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	//Concrete Method
	public String getName() {
	    return this.name;
	}

	public double getSalary() {
	    return this.salary;
	}

	//Abstract Method
	public abstract void manageSalary(double rate);
}