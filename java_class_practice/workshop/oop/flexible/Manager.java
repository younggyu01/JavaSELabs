package workshop.oop.flexible;
/* ������ Ŭ���� */
public class Manager extends Employee {
	private String dept;
	
    public Manager (String name, double salary) {
//        this.name = name;
//        this.salary = salary;
    	super(name,salary);
    }
    
    public Manager(String name, double salary,String dept) {
    	this(name,salary);
    	this.dept = dept;
    }
    
    public String getDept() {
		return dept;
	}
    
    @Override
    public void manageSalary(double rate) {
        salary = salary+ salary*(rate/100);
        salary += 20; // 20������ �߰��� �޴´�.
    }
}