package workshop.person.control;

import java.util.Scanner;

import workshop.person.entity.PersonEntity;

public class PersonManager {

	public static void main(String[] args) {
		//Scanner ��ü����
		Scanner scanner = new Scanner(System.in);
		System.out.println("==> ������ �Է��ϼ���!");
		String inputValue = scanner.next();
		char gender = inputValue.charAt(0); //String => char
		
		System.out.println("==> �̸��� �Է��ϼ���!");
		String name = scanner.next();
		
		System.out.println(String.format("==> �Է��Ͻ� ������ %s, �̸��� %s", gender, name) + "\n");
		
		PersonManager personMgr = new PersonManager();
		//�迭���� �� �ʱ�ȭ
		PersonEntity[] persons = new PersonEntity[10];
		//persons ������ PersonEntity[] Ÿ���̰�, persons[0]�� PersonEntity Ÿ���̴�.
		personMgr.fillPersons(persons);		
		
		personMgr.printTitle("�ι����� ��ȸ�ý���");
		personMgr.showPerson(persons);		
		
		String message = String.format("���� : %s (��)��   %d �� �Դϴ�.", gender, personMgr.findByGender(persons, gender));
		System.out.println(message);
		
		personMgr.showPerson(persons, name);
		
		scanner.close();

	}
	
	public void showPerson(PersonEntity[] persons, String name) {
		for(PersonEntity person : persons) {
			if(person.getName().equals(name)) {
				System.out.println("[�̸�] " + person.getName());
				System.out.println("[����] " + person.getGender());
				System.out.println("[��ȭ��ȣ] " + person.getPhone());
				System.out.println("[�ּ�] " + person.getAddress());
				break;
			}
		}
	}
	
	public int findByGender(PersonEntity[] persons, char gender ) {
		int genderCnt = 0;
		for(PersonEntity person : persons) {
			if(person.getGender() == gender) {
				genderCnt++;
			}
		}
		return genderCnt;
	}

	public void showPerson(PersonEntity[] persons) {
		//for loop�� ��ȸ�ϸ鼭 
		for(PersonEntity person:persons) {
			System.out.println("[�̸� ] " + person.getName() + "\t [����] " + person.getGender() + "\t [��ȭ��ȣ] " + person.getPhone());
		}
	}

	public void fillPersons(PersonEntity[] persons) {
		persons[0] = new PersonEntity("�̼�ȣ","7212121028102", "��õ ��籸", "032-392-2932");
		persons[1] = new PersonEntity("���ϴ�","7302132363217", "���� ������", "02-362-1932");
		persons[2] = new PersonEntity("�ڿ���","7503111233201", "���� ���ϱ�", "02-887-1542");
		persons[3] = new PersonEntity("���μ�","7312041038988", "���� ������", "032-384-2223");
		persons[4] = new PersonEntity("ȫ����","7606221021341", "���� ��õ��", "02-158-7333");
		persons[5] = new PersonEntity("�̹̼�","7502142021321", "���� ������", "02-323-1934");
		persons[6] = new PersonEntity("�ڼ���","7402061023101", "���� ���α�", "02-308-0932");
		persons[7] = new PersonEntity("������","7103282025101", "���� ����", "02-452-0939");
		persons[8] = new PersonEntity("Ȳ����","7806231031101", "��õ �߱�", "032-327-2202");
		persons[9] = new PersonEntity("��ö��","7601211025101", "��õ ��籸", "032-122-7832");
	}
	
	public void printTitle(String title) {
		System.out.println("@@@@ " + title + " @@@@");
		System.out.println();
	}

}