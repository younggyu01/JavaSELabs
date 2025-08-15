package mylab.book.entity;

/** Publication을 상속받아 잡지 정보를 표현합니다.
 * publishPeriod(발행주기) 속성을 추가로 가집니다.
 * toString()을 오버라이드 하여 잡지 정보를 상세히 표시합니다.
 */

public class Magazine extends Publication {
    private String publishPeriod; // 발행주기 (예: "월간", "주간")

    public Magazine() {}
    
    // 부모 생성자 호출 후 자신만의 속성 초기화
    public Magazine(String title, String publishDate, int page, int price,
                    String publishPeriod) {
        super(title, publishDate, page, price); // 부모 생성자 호출 
        this.publishPeriod = publishPeriod; // 자신만의 속성 초기화
    }

    public String getPublishPeriod() { return publishPeriod; }
    public void setPublishPeriod(String publishPeriod) { this.publishPeriod = publishPeriod; }

    @Override
    public String toString() {
        return super.toString()
                + " [잡지] 발행주기:" + publishPeriod
                + ", " + getPage() + "쪽, " + getPrice() + "원"
                + ", 출판일:" + getPublishDate();
    }
}
