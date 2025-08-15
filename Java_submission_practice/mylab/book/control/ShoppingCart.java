package mylab.book.control;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

/**
 * 출판물 관리 시스템에서 장바구니 기능을 구현한 ShoppingCart 클래스입니다.
 * 출판물(Publication)과 그 하위 클래스(Magazine, Novel, ReferenceBook)의 객체들을
 * 장바구니에 추가하고 관리하는 기능을 제공합니다.
 */

// 1). 생성자
public class ShoppingCart {
    private final List<Publication> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    // 2). 장바구니 조작 메서드 (장바구니 담기)
    public void addItem(Publication item) {
        items.add(item);
        System.out.println(item.getTitle() + "이(가) 장바구니에 추가되었습니다.");
    }

    // 2). 장바구니 조작 메서드 (제목으로 장바구니 제거 (성공 시 true))
    public boolean removeItem(String title) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getTitle().equals(title)) {
                Publication removed = items.remove(i);
                System.out.println(removed.getTitle() + "이(가) 장바구니에서 제거되었습니다.");
                return true;
            }
        }
        System.out.println("해당 제목의 출판물을 찾을 수 없습니다.");
        return false;
    }

    // 3). 가격 계산 메서드 (원가 총합)
    public int calculateTotalPrice() {
        int sum = 0;
        for (Publication p : items) sum += p.getPrice();
        return sum;
    }

    // 3). 가격 계산 메서드 (Magazine 10%, Novel 15%, ReferenceBook 20%, 기타 0%)
    public int calculateDiscountedPrice() {
        int total = 0;
        for (Publication item : items) {
            if (item instanceof Magazine) {
                total += (int) (item.getPrice() * 0.9);
            } else if (item instanceof Novel) {
                total += (int) (item.getPrice() * 0.85);
            } else if (item instanceof ReferenceBook) {
                total += (int) (item.getPrice() * 0.8);
            } else {
                total += item.getPrice();
            }
        }
        return total;
    }

    // 장바구니 출력
    public void displayCart() {
        DecimalFormat won = new DecimalFormat("#,###");
        System.out.println("====== 장바구니 내용 ======");
        for (int i = 0; i < items.size(); i++) {
            Publication p = items.get(i);
            System.out.printf("%d. %s - %s원%n", (i + 1), p.getTitle(), won.format(p.getPrice()));
        }
        int total = calculateTotalPrice();
        int discounted = calculateDiscountedPrice();
        System.out.println("총 가격: " + won.format(total) + "원");
        System.out.println("할인 적용 가격: " + won.format(discounted) + "원");
    }

    // 4). 통계 메서드
    public void printStatistics() {
        int magazine = 0, novel = 0, ref = 0;
        for (Publication p : items) {
            if (p instanceof Magazine)      magazine++;
            else if (p instanceof Novel)    novel++;
            else if (p instanceof ReferenceBook) ref++;
        }
        System.out.println("====== 장바구니 통계 ======");
        System.out.println("잡지: " + magazine + "권");
        System.out.println("소설: " + novel + "권");
        System.out.println("참고서: " + ref + "권");
        System.out.println("총 출판물: " + items.size() + "권");
    }

    // 5). 메인 메서드
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Publication[] publications = {
            new Magazine("마이크로소프트", "2007-10-01", 328, 9900, "매월"),
            new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월"),
            new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설"),
            new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설"),
            new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학")
        };

        // 추가
        for (Publication p : publications) {
            cart.addItem(p);
        }

        cart.displayCart();     // 합계/할인가 출력
        cart.printStatistics(); // 타입별 수량

        // 제거
        cart.removeItem("빠삐용");
        cart.displayCart();
    }
}
