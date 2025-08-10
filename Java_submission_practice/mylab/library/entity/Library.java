// package���� mylab.library.entity �Դϴ�.
package mylab.library.entity;

import java.util.List;
import java.util.ArrayList;

// ������ �̸�(name)�� ���� ���(books)�� ��� ��������� private���� �����մϴ�.
public class Library {
	private final List<Book> books;
	private String name;
	
	public Library(String name) {
		this.books = new ArrayList<>();
		this.name = name;
	}
	
	// ĸ��ȭ
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	// ���� ó�� �߰�
	private static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }
    private static String norm(String s) {
        return s == null ? "" : s.trim().toLowerCase();
    }
	
	// addBook() : ������ �߰��ϴ� �޼����Դϴ�.
	public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("book�� null�Դϴ�.");
        }
        String isbn = book.getIsbn();
        if (isBlank(isbn)) {
            throw new IllegalArgumentException("ISBN�� ��� �ֽ��ϴ�.");
        }
        if (findByISBN(isbn) != null) {
            throw new IllegalArgumentException("�̹� �����ϴ� ISBN�Դϴ�: " + isbn);
        }
        books.add(book);
    }
	
	// findBookByTitle(), findBooksByAuthor(), findBookByISBN() : ����, ����, ISBN���� ������ �˻��ϴ� �޼����Դϴ�.
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
	
	// checkOutBook(), returnBook() : ISBN���� ������ �����ϰų� �ݳ��ϴ� �޼����Դϴ�.
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
	
	// getAvailableBooks(), getAllBooks() : ���� ������ ���� ����̳� ��ü ���� ����� ��ȯ�ϴ� �޼����Դϴ�.
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
	
	// getTotalBooks(), getAvailableBooksCount(), getBorrowedBooksCount() : ���� ���� ���� ������ ��ȯ�ϴ� �޼����Դϴ�.
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

