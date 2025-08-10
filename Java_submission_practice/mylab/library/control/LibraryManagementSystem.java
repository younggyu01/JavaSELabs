// package���� mylab.library.control �Դϴ�.
package mylab.library.control;

//Book�� Library Ŭ������ import �մϴ�.
import mylab.library.entity.Book;
import mylab.library.entity.Library;
import java.util.List;

public class LibraryManagementSystem {
	
	// main() : ������ ��ü�� �����ϰ� ������ �߰��Ͽ� ���� ����� �׽�Ʈ �ϴ� �޼����Դϴ�.
	 public static void main(String[] args) {
		 // a. ������ ��ü�� �����մϴ�
		 Library library = new Library("�߾� ������");
		 
		 // b. addSampleBooks()�� ȣ���Ͽ� ���� ������ �߰��մϴ�.
		 addSampleBooks(library);
		 
		 // c. ������ ������ ����մϴ�. 
		 printLibraryHeader(library);
	     printLibraryStatus(library);
	     
	     // d. testFindBook(), testCheckOut(), testReturn()�� ȣ���Ͽ� �� ����� �׽�Ʈ�մϴ�.
	     testFindBook(library);
	     testCheckOut(library);
	     printSection("������ ���� ����:");
	     printLibraryStatus(library);

	     testReturn(library);
	     printSection("������ ���� ����:");
	     printLibraryStatus(library);
	     
	     // e. displayAvailableBooks()�� ȣ���Ͽ� ���� ������ ���� ����� ����մϴ�.
	     printSection("===== ���� ������ ���� ��� =====");
	     displayAvailableBooks(library);
	}
	
	 // b. addSampleBooks()�� ȣ���Ͽ� ���� ������ �߰��մϴ�.
	private static void addSampleBooks(Library library) {
        tryAdd(library, new Book("�ڹ� ���α׷���", "���ڹ�", "978-89-01-12345-6", 2022));
        tryAdd(library, new Book("��ü������ ��ǰ� ����", "����ȣ", "978-89-01-67890-1", 2015));
        tryAdd(library, new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        tryAdd(library, new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        tryAdd(library, new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        tryAdd(library, new Book("�ڹ��� ����", "���ü�", "978-89-01-14077-4", 2019));
	}
	private static void tryAdd(Library library, Book book) {
        try {
            library.addBook(book);
            System.out.println("������ �߰��Ǿ����ϴ�: " + book.getTitle());
        } catch (IllegalArgumentException e) {
            System.out.println("���� �߰� ����: " + e.getMessage());
        }
    }

    // c. ������ ������ ����մϴ�.
    private static void printLibraryHeader(Library library) {
        System.out.println("===== " + library.getName() + " =====");
    }

    private static void printLibraryStatus(Library library) {
        System.out.println("��ü ���� ��: " + library.getTotalBooks());
        System.out.println("���� ���� ���� ��: " + library.getAvailableBooksCount());
        System.out.println("���� ���� ���� ��: " + library.getBorrowedBooksCount());
        System.out.println();
    }

    // d. testFindBook(), testCheckOut(), testReturn()�� ȣ���Ͽ� �� ����� �׽�Ʈ�մϴ�.
    private static void testFindBook(Library library) {
        printSection("===== ���� �˻� �׽�Ʈ =====");

        System.out.println("�������� �˻� ���:");
        Book byTitle = library.findByTitle("�ڹ��� ����");
        if (byTitle != null) {
            System.out.println(byTitle.toString());
        } else {
            System.out.println("�˻� ����� �����ϴ�.");
        }
        System.out.println();

        System.out.println("���ڷ� �˻� ���:");
        List<Book> byAuthor = library.findByAuthor("Robert C. Martin");
        if (!byAuthor.isEmpty()) {
            System.out.println(byAuthor.get(0).toString());
        } else {
            System.out.println("�˻� ����� �����ϴ�.");
        }
        System.out.println();
    }

    private static void testCheckOut(Library library) {
        printSection("===== ���� ���� �׽�Ʈ =====");
        String targetIsbn = "978-89-01-14077-4";

        boolean ok = library.checkOutBook(targetIsbn);
        if (ok) {
            System.out.println("���� ���� ����!");
            System.out.println("����� ���� ����:");
            Book b = library.findByISBN(targetIsbn);
            if (b != null) System.out.println(b.toString());
        } else {
            System.out.println("���� ���� ����(�������� �ʰų� �̹� ���� ��).");
        }
        System.out.println();
    }

    private static void testReturn(Library library) {
        printSection("===== ���� �ݳ� �׽�Ʈ =====");
        String targetIsbn = "978-89-01-14077-4";

        boolean ok = library.returnBook(targetIsbn);
        if (ok) {
            System.out.println("���� �ݳ� ����!");
            System.out.println("�ݳ��� ���� ����:");
            Book b = library.findByISBN(targetIsbn);
            if (b != null) System.out.println(b.toString());
        } else {
            System.out.println("���� �ݳ� ����(�������� �ʴ� ISBN).");
        }
        System.out.println();
    }

    // e. displayAvailableBooks()�� ȣ���Ͽ� ���� ������ ���� ����� ����մϴ�.
    private static void displayAvailableBooks(Library library) {
        List<Book> avail = library.getAvailableBooks();
        if (avail.isEmpty()) {
            System.out.println("���� ������ ������ �����ϴ�.");
            return;
        }
        for (Book b : avail) {
            System.out.println(b.toString());
            System.out.println("------------------------");
        }
    }

    // ���
    private static void printSection(String title) {
        System.out.println(title);
    }
}
