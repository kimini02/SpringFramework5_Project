package mylab.book.control;

import mylab.book.entity.*;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * 출판물 통계 분석 클래스
 */
public class StatisticsAnalyzer {

    /**
     * 타입별 평균 가격 계산
     */
    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Integer> totalPriceByType = new HashMap<>();
        Map<String, Integer> countByType = new HashMap<>();

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            totalPriceByType.put(type, totalPriceByType.getOrDefault(type, 0) + pub.getPrice());
            countByType.put(type, countByType.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> averagePriceByType = new HashMap<>();
        for (String type : totalPriceByType.keySet()) {
            double average = (double) totalPriceByType.get(type) / countByType.get(type);
            averagePriceByType.put(type, average);
        }

        return averagePriceByType;
    }

    /**
     * 출판물 유형 분포 계산 (백분율)
     */
    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> countByType = new HashMap<>();

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            countByType.put(type, countByType.getOrDefault(type, 0) + 1);
        }

        Map<String, Double> distribution = new HashMap<>();
        int total = publications.length;
        for (String type : countByType.keySet()) {
            double percentage = (double) countByType.get(type) / total * 100;
            distribution.put(type, percentage);
        }

        return distribution;
    }

    /**
     * 특정 연도 출판물 비율 계산
     */
    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int count = 0;
        for (Publication pub : publications) {
            if (pub.getPublishDate().substring(0, 4).equals(year)) {
                count++;
            }
        }
        return (double) count / publications.length * 100;
    }

    /**
     * 출판물 타입 확인
     */
    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) {
            return "소설";
        } else if (pub instanceof Magazine) {
            return "잡지";
        } else if (pub instanceof ReferenceBook) {
            return "참고서";
        } else {
            return "기타";
        }
    }

    /**
     * 통계 정보 출력
     */
    public void printStatistics(Publication[] publications) {
        DecimalFormat df = new DecimalFormat("#,###.##");

        System.out.println("\n===== 출판물 통계 분석 =====");

        // 1. 타입별 평균 가격
        System.out.println("1. 타입별 평균 가격:");
        Map<String, Double> avgPrices = calculateAveragePriceByType(publications);
        for (String type : avgPrices.keySet()) {
            System.out.println("- " + type + ": " + df.format(avgPrices.get(type).intValue()) + "원");
        }

        // 2. 출판물 유형 분포
        System.out.println("\n2. 출판물 유형 분포:");
        Map<String, Double> distribution = calculatePublicationDistribution(publications);
        for (String type : distribution.keySet()) {
            System.out.println("- " + type + ": " + df.format(distribution.get(type)) + "%");
        }

        // 3. 2007년 출판물 비율
        System.out.println("\n3. 2007년에 출판된 출판물 비율: " + 
                df.format(calculatePublicationRatioByYear(publications, "2007")) + "%");
    }
}
