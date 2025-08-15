package mylab.book.entity;

/**
 * 모든 출판물의 기본 클래스로 title, publishDate, page, price 속성을 가집니다.
 * 기본 생성자와 모든 멤버변수를 초기화하는 생성자를 제공합니다.
 * toString() 메서드는 요구사항에 맞게 title만 반환합니다.
 */

public class Publication {
    private String title;
    private String publishDate; // yyyy-MM-dd
    private int page;
    private int price;

    // 기본 생성자: 빈 객체 생성 
    public Publication() {} // 매개변수 생성자: 모든 필드 초기화

    // 모든 필드 초기화 생성자
    public Publication(String title, String publishDate, int page, int price) {
        this.title = title;
        this.publishDate = publishDate;
        this.page = page;
        this.price = price;
    }

    // getter/setter
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getPublishDate() { return publishDate; }
    public void setPublishDate(String publishDate) { this.publishDate = publishDate; }

    public int getPage() { return page; }
    public void setPage(int page) { this.page = page; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    // 기본 toString()은 제목만 반환
    @Override
    public String toString() {
        return title;
    }
}
