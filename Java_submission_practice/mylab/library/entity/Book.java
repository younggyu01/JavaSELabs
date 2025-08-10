// package���� mylab.library.entity �Դϴ�
package mylab.library.entity;

// ���� ������ ��� ���������(title, author, isbn, publishYear, isAvailable)�� private���� �����մϴ�.
public class Book {
	private String title;
	private String author;
	private String isbn;
	private int publishYear;
	private boolean isAvailable;
	
	// Book() : �⺻ �����ڸ� �����ϸ�, �ʱ� ���� �� ������ ���� ���� ����(isAvailable = true)�� �����մϴ�.
	public Book() {
		isAvailable = true;
	}
	
	// Book(String title, String author, String isbn, int publishYear) : ��� �ʵ带 �ʱ�ȭ�ϴ� �����ڷ�, ���� ���� ���¸� true�� �����մϴ�.
	public Book(String title, String author, String isbn, int publishYear) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.publishYear = publishYear;
		this.isAvailable = true;
	}
	
	// ��������鿡 ���� getter�� setter �޼��带 �ۼ��մϴ�.
	public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
	
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
	
	public String getIsbn() { return isbn; }
	public void setIsbn(String isbn) { this.isbn = isbn; }
	
	public int getPublishYear() { return publishYear; }
	public void setPublishYear(int publishYear) { this.publishYear = publishYear; }
	
	public boolean isAvailable() { return isAvailable; }
	
	// checkOut() : ���� ������ ó���ϴ� �޼����, ���� ������ ��� isAvailable�� false�� �����ϰ� true�� ��ȯ�մϴ�.
	public boolean checkOut() {
        if (!isAvailable) return false;
        isAvailable = false;
        return true;
    }
	
	// returnBook() : ���� �ݳ��� ó���ϴ� �޼����, isAvailable�� true�� �����մϴ�.
	public void returnBook() {
		isAvailable = true;
	}
	
	// toString() : ���� ������ ���ڿ� ǥ���� ��ȯ�ϴ� �޼����Դϴ�.
	@Override
	public String toString() {
	    return String.format(
	        "å ����: %s\t����: %s\tISBN: %s\t���ǳ⵵: %d\t���� ���� ����: %s",
	        title, author, isbn, publishYear, (isAvailable ? "����" : "���� ��"));
	}
}
