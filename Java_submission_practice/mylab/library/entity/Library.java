// package명은 mylab.library.entity 입니다.
package mylab.library.entity;

import java.util.List;
import java.util.ArrayList;

// 도서관 이름(name)과 도서 목록(books)을 담는 멤버변수를 private으로 정의합니다.
public class Library {
	private final List<Book> books;
	private String name;
	
	public Library(String name) {
		this.books = new ArrayList<>();
		this.name = name;
	}
	
	// 캡슐화
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	// 예외 처리 추가
	private static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }
    private static String norm(String s) {
        return s == null ? "" : s.trim().toLowerCase();
    }
	
	// addBook() : 도서를 추가하는 메서드입니다.
	public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("book이 null입니다.");
        }
        String isbn = book.getIsbn();
        if (isBlank(isbn)) {
            throw new IllegalArgumentException("ISBN이 비어 있습니다.");
        }
        if (findByISBN(isbn) != null) {
            throw new IllegalArgumentException("이미 존재하는 ISBN입니다: " + isbn);
        }
        books.add(book);
    }
	
	// findBookByTitle(), findBooksByAuthor(), findBookByISBN() : 제목, 저자, ISBN으로 도서를 검색하는 메서드입니다.
	public Book findByTitle(String title) {
        if (isBlank(title)) return null;
        String key = norm(title);
        for (Book b : books) {
            if (norm(b.getTitle()).equals(key)) {
                return b;
            }
        }
        return null;
    }
	
	public List<Book> findByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        if (isBlank(author)) return result;
        String key = norm(author);
        for (Book b : books) {
            if (norm(b.getAuthor()).equals(key)) {
                result.add(b);
            }
        }
        return result;
    }
	
	public Book findByISBN(String isbn) {
        if (isBlank(isbn)) return null;
        String key = norm(isbn);
        for (Book b : books) {
            if (norm(b.getIsbn()).equals(key)) {
                return b;
            }
        }
        return null;
    }
	
	// checkOutBook(), returnBook() : ISBN으로 도서를 대출하거나 반납하는 메서드입니다.
	public boolean checkOutBook(String isbn) {
        Book book = findByISBN(isbn);
        if (book == null) return false;
        return book.checkOut();
    }
	
	public boolean returnBook(String isbn) {
        Book book = findByISBN(isbn);
        if (book == null) return false;
        book.returnBook();
        return true;
    }
	
	// getAvailableBooks(), getAllBooks() : 대출 가능한 도서 목록이나 전체 도서 목록을 반환하는 메서드입니다.
	public List<Book> getAvailableBooks() {
        List<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.isAvailable()) result.add(b);
        }
        return result;
    }
	
	public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }
	
	// getTotalBooks(), getAvailableBooksCount(), getBorrowedBooksCount() : 도서 수량 관련 정보를 반환하는 메서드입니다.
	public int getTotalBooks() {
        return books.size();
    }
	
	public int getAvailableBooksCount() {
        int cnt = 0;
        for (Book b : books) {
            if (b.isAvailable()) cnt++;
        }
        return cnt;
    }
	
	public int getBorrowedBooksCount() {
        return getTotalBooks() - getAvailableBooksCount();
    }

}	

