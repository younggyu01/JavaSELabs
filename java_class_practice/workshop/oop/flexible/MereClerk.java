package workshop.oop.flexible;
/* ���� Ŭ���� */
public class MereClerk extends Employee {    
    public MereClerk (String name, double salary) {
//        this.name = name;
//        this.salary = salary;
    	super(name,salary);
    }
    
    /*
     * �������̵� ��Ģ�� �θ� ������� �޼���� Signature�� �ݵ�� ���ƾ� �Ѵ�.
     * @Override ������̼��� �������̵� ��Ģ�� ������ Ÿ�ӿ� üũ���ش�.
     */
    @Override
    public void manageSalary(double rate) {
        salary = salary+ salary*(rate/100);
    }
}