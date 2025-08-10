// package명은 mylab.library.control 입니다.
package mylab.library.control;

//Book과 Library 클래스를 import 합니다.
import mylab.library.entity.Book;
import mylab.library.entity.Library;
import java.util.List;

public class LibraryManagementSystem {
	
	// main() : 도서관 객체를 생성하고 도서를 추가하여 각종 기능을 테스트 하는 메서드입니다.
	 public static void main(String[] args) {
		 // a. 도서관 객체를 생성합니다
		 Library library = new Library("중앙 도서관");
		 
		 // b. addSampleBooks()를 호출하여 샘플 도서를 추가합니다.
		 addSampleBooks(library);
		 
		 // c. 도서관 정보를 출력합니다. 
		 printLibraryHeader(library);
	     printLibraryStatus(library);
	     
	     // d. testFindBook(), testCheckOut(), testReturn()을 호출하여 각 기능을 테스트합니다.
	     testFindBook(library);
	     testCheckOut(library);
	     printSection("도서관 현재 상태:");
	     printLibraryStatus(library);

	     testReturn(library);
	     printSection("도서관 현재 상태:");
	     printLibraryStatus(library);
	     
	     // e. displayAvailableBooks()를 호출하여 대출 가능한 도서 목록을 출력합니다.
	     printSection("===== 대출 가능한 도서 목록 =====");
	     displayAvailableBooks(library);
	}
	
	 // b. addSampleBooks()를 호출하여 샘플 도서를 추가합니다.
	private static void addSampleBooks(Library library) {
        tryAdd(library, new Book("자바 프로그래밍", "김자바", "978-89-01-12345-6", 2022));
        tryAdd(library, new Book("객체지향의 사실과 오해", "조영호", "978-89-01-67890-1", 2015));
        tryAdd(library, new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        tryAdd(library, new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        tryAdd(library, new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        tryAdd(library, new Book("자바의 정석", "남궁성", "978-89-01-14077-4", 2019));
	}
	private static void tryAdd(Library library, Book book) {
        try {
            library.addBook(book);
            System.out.println("도서가 추가되었습니다: " + book.getTitle());
        } catch (IllegalArgumentException e) {
            System.out.println("도서 추가 실패: " + e.getMessage());
        }
    }

    // c. 도서관 정보를 출력합니다.
    private static void printLibraryHeader(Library library) {
        System.out.println("===== " + library.getName() + " =====");
    }

    private static void printLibraryStatus(Library library) {
        System.out.println("전체 도서 수: " + library.getTotalBooks());
        System.out.println("대출 가능 도서 수: " + library.getAvailableBooksCount());
        System.out.println("대출 중인 도서 수: " + library.getBorrowedBooksCount());
        System.out.println();
    }

    // d. testFindBook(), testCheckOut(), testReturn()을 호출하여 각 기능을 테스트합니다.
    private static void testFindBook(Library library) {
        printSection("===== 도서 검색 테스트 =====");

        System.out.println("제목으로 검색 결과:");
        Book byTitle = library.findByTitle("자바의 정석");
        if (byTitle != null) {
            System.out.println(byTitle.toString());
        } else {
            System.out.println("검색 결과가 없습니다.");
        }
        System.out.println();

        System.out.println("저자로 검색 결과:");
        List<Book> byAuthor = library.findByAuthor("Robert C. Martin");
        if (!byAuthor.isEmpty()) {
            System.out.println(byAuthor.get(0).toString());
        } else {
            System.out.println("검색 결과가 없습니다.");
        }
        System.out.println();
    }

    private static void testCheckOut(Library library) {
        printSection("===== 도서 대출 테스트 =====");
        String targetIsbn = "978-89-01-14077-4";

        boolean ok = library.checkOutBook(targetIsbn);
        if (ok) {
            System.out.println("도서 대출 성공!");
            System.out.println("대출된 도서 정보:");
            Book b = library.findByISBN(targetIsbn);
            if (b != null) System.out.println(b.toString());
        } else {
            System.out.println("도서 대출 실패(존재하지 않거나 이미 대출 중).");
        }
        System.out.println();
    }

    private static void testReturn(Library library) {
        printSection("===== 도서 반납 테스트 =====");
        String targetIsbn = "978-89-01-14077-4";

        boolean ok = library.returnBook(targetIsbn);
        if (ok) {
            System.out.println("도서 반납 성공!");
            System.out.println("반납된 도서 정보:");
            Book b = library.findByISBN(targetIsbn);
            if (b != null) System.out.println(b.toString());
        } else {
            System.out.println("도서 반납 실패(존재하지 않는 ISBN).");
        }
        System.out.println();
    }

    // e. displayAvailableBooks()를 호출하여 대출 가능한 도서 목록을 출력합니다.
    private static void displayAvailableBooks(Library library) {
        List<Book> avail = library.getAvailableBooks();
        if (avail.isEmpty()) {
            System.out.println("대출 가능한 도서가 없습니다.");
            return;
        }
        for (Book b : avail) {
            System.out.println(b.toString());
            System.out.println("------------------------");
        }
    }

    // 출력
    private static void printSection(String title) {
        System.out.println(title);
    }
}
