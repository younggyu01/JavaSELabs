package mylab.book.entity;

/** Publication을 상속받아 참고서 정보를 표현합니다.
 * field(분야) 속성을 추가로 가집니다.
 * toString()을 오버라이드하여 참고서 정보를 상세히 표시합니다.
 */

public class ReferenceBook extends Publication {
    private String field; // 전문 분야 (예: "컴퓨터언어학습")

    public ReferenceBook() {}

    public ReferenceBook(String title, String publishDate, int page, int price,
                         String field) {
        super(title, publishDate, page, price);
        this.field = field;
    }

    public String getField() { return field; }
    public void setField(String field) { this.field = field; }

    @Override
    public String toString() {
        return super.toString()
                + " [참고서] 분야:" + field
                + ", " + getPage() + "쪽, " + getPrice() + "원"
                + ", 출판일:" + getPublishDate();
    }
}
