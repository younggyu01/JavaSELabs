package mylab.book.control;

import java.text.DecimalFormat;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

/**
 * ManageBook 클래스는 출판물 관리 시스템의 주요 실행 클래스로, 
 * 출판물 객체를 생성하고 관리하는 기능을 제공합니다. 
 * 이 클래스는 다양한 출판물(잡지, 소설, 참고서)을 생성하고, 
 * 출판물 정보를 출력하며, 가격 할인을 적용하고, 통계 분석을 수행합니다.
 */

public class ManageBook {

    // modifyPrice 메서드
    // Magazine: 40% 할인 -> 60% 가격, Novel: 20% 할인 -> 80% 가격, ReferenceBook: 10% 할인 -> 90% 가격
    public static void modifyPrice(Publication publication) {
        int currentPrice = publication.getPrice();

        if (publication instanceof Magazine) {
            publication.setPrice((int) (currentPrice * 0.6));
        } else if (publication instanceof Novel) {
            publication.setPrice((int) (currentPrice * 0.8));
        } else if (publication instanceof ReferenceBook) {
            publication.setPrice((int) (currentPrice * 0.9));
        }

    }

    public static void main(String[] args) {
        DecimalFormat won = new DecimalFormat("#,###");

        // 1) 다형성: 상위 타입 배열에 하위 객체 저장
        Publication[] publications = {
            new Magazine("마이크로소프트", "2007-10-01", 328, 9900, "매월"),
            new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월"),
            new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설"),
            new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설"),
            new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학"),
            new Novel("소년이온다", "2014-05-01", 216, 15000, "한강", "장편소설"),
            new Novel("작별하지않는다", "2021-09-09", 332, 15120, "한강", "장편소설")
        };

        // 2) 도서 정보 출력
        System.out.println("==== 도서 정보 출력 ====");
        for (int i = 0; i < publications.length; i++) {
            System.out.printf("%d. %s%n", (i + 1), publications[i].toString());
        }

        // 3) 가격 변경 (7번째 '작별하지않는다' 가격 변경)
        System.out.println("\n==== 가격 변경 ====");
        Publication target = publications[6]; // 0-based index: 6
        System.out.println(target.getTitle() + " 변경 전 가격: " + won.format(target.getPrice()) + "원");
        int before = target.getPrice();
        modifyPrice(target);
        int after = target.getPrice();
        System.out.println(target.getTitle() + " 변경 후 가격: " + won.format(after) + "원");
        System.out.println("차액: " + won.format(before - after) + "원");

        // 4) 통계 분석
        System.out.println();
        StatisticsAnalyzer analyzer = new StatisticsAnalyzer();
        analyzer.printStatistics(publications);
    }
}
