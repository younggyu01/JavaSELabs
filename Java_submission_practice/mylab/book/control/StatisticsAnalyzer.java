package mylab.book.control;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

/**
 * StatisticsAnalyzer 클래스는 출판물 배열을 분석하여
 * 다양한 통계 정보를 계산하고 출력하는 기능을 제공합니다.
 * 이 클래스는 출판물의 타입별 평균 가격, 유형 분포, 특정 연도 출판 비율 등의 통계 데이터를 처리합니다.
 */

public class StatisticsAnalyzer {

    // 1). 타입별 평균 가격 계산 메서드
    public Map<String, Double> calculateAveragePriceByType(Publication[] pubs) {
        Map<String, Long> sum = new HashMap<>();
        Map<String, Integer> cnt = new HashMap<>();

        for (Publication p : pubs) {
            String type = getPublicationType(p);
            sum.put(type, sum.getOrDefault(type, 0L) + p.getPrice());
            cnt.put(type, cnt.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> avg = new HashMap<>();
        for (String type : sum.keySet()) {
            avg.put(type, sum.get(type) * 1.0 / cnt.get(type));
        }
        return avg;
    }

    // 2). 출판물 유형 분포 계산 메서드
    public Map<String, Double> calculatePublicationDistribution(Publication[] pubs) {
        Map<String, Integer> cnt = new HashMap<>();
        for (Publication p : pubs) {
            String type = getPublicationType(p);
            cnt.put(type, cnt.getOrDefault(type, 0) + 1);
        }
        Map<String, Double> ratio = new HashMap<>();
        int n = pubs.length;
        for (String type : cnt.keySet()) {
            ratio.put(type, cnt.get(type) * 100.0 / n);
        }
        return ratio;
    }

    // 3). 특정 연도 출판물 비율 계산 메서드
    public double calculatePublicationRatioByYear(Publication[] pubs, String year) {
        int n = pubs.length;
        int hit = 0;
        for (Publication p : pubs) {
            String y = p.getPublishDate().substring(0, 4);
            if (year.equals(y)) hit++;
        }
        return hit * 100.0 / n;
    }

    // 4). 출판물 타입 확인 헬퍼 메서드
    private String getPublicationType(Publication p) {
        if (p instanceof Novel) return "소설";
        if (p instanceof Magazine) return "잡지";
        if (p instanceof ReferenceBook) return "참고서";
        return "기타";
    }

    // 5). 통계 정보 출력 메서드
    public void printStatistics(Publication[] pubs) {
        DecimalFormat won = new DecimalFormat("#,###");

        System.out.println("===== 출판물 통계 분석 =====");

        // 1) 타입별 평균 가격
        Map<String, Double> avg = calculateAveragePriceByType(pubs);
        System.out.println("1. 타입별 평균 가격:");
        // 소설/참고서/잡지 순으로 출력 (있는 경우만)
        String[] order = {"소설", "참고서", "잡지", "기타"};
        for (String key : order) {
            if (avg.containsKey(key)) {
                long rounded = Math.round(avg.get(key));
                System.out.println("   - " + key + ": " + won.format(rounded) + "원");
            }
        }
        System.out.println();

        // 2) 출판물 유형 분포
        Map<String, Double> dist = calculatePublicationDistribution(pubs);
        System.out.println("2. 출판물 유형 분포:");
        for (String key : order) {
            if (dist.containsKey(key)) {
                System.out.printf("   - %s: %.2f%%%n", key, dist.get(key));
            }
        }
        System.out.println();

        // 3) 2007년 비율
        double r2007 = calculatePublicationRatioByYear(pubs, "2007");
        System.out.printf("3. 2007년에 출판된 출판물 비율: %.2f%%%n", r2007);
    }
}
