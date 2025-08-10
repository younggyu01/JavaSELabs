// package명은 mylab.library.entity 입니다
package mylab.library.entity;

// 도서 정보를 담는 멤버변수들(title, author, isbn, publishYear, isAvailable)을 private으로 정의합니다.
public class Book {
	private String title;
	private String author;
	private String isbn;
	private int publishYear;
	private boolean isAvailable;
	
	// Book() : 기본 생성자를 정의하며, 초기 생성 시 도서는 대출 가능 상태(isAvailable = true)로 설정합니다.
	public Book() {
		isAvailable = true;
	}
	
	// Book(String title, String author, String isbn, int publishYear) : 모든 필드를 초기화하는 생성자로, 대출 가능 상태를 true로 설정합니다.
	public Book(String title, String author, String isbn, int publishYear) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publishYear = publishYear;
		this.isAvailable = true;
	}
	
	// 멤버변수들에 대한 getter와 setter 메서드를 작성합니다.
	public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
	
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
	
	public String getIsbn() { return isbn; }
	public void setIsbn(String isbn) { this.isbn = isbn; }
	
	public int getPublishYear() { return publishYear; }
	public void setPublishYear(int publishYear) { this.publishYear = publishYear; }
	
	public boolean isAvailable() { return isAvailable; }
	
	// checkOut() : 도서 대출을 처리하는 메서드로, 대출 가능한 경우 isAvailable을 false로 변경하고 true를 반환합니다.
	public boolean checkOut() {
        if (!isAvailable) return false;
        isAvailable = false;
        return true;
    }
	
	// returnBook() : 도서 반납을 처리하는 메서드로, isAvailable을 true로 변경합니다.
	public void returnBook() {
		isAvailable = true;
	}
	
	// toString() : 도서 정보의 문자열 표현을 반환하는 메서드입니다.
	@Override
	public String toString() {
	    return String.format(
	        "책 제목: %s\t저자: %s\tISBN: %s\t출판년도: %d\t대출 가능 여부: %s",
	        title, author, isbn, publishYear, (isAvailable ? "가능" : "대출 중"));
	}
}
