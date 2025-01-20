package github;

import java.util.ArrayList;

public class no10 {
    public static void main(String[] args) {
        String[] cities1 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        String[] cities2 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        String[] cities3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        String[] cities4 = {"Jeju", "Pangyo", "NewYork", "newyork"};
        System.out.println(solution(3, cities1));
        System.out.println(solution(3, cities2));
        System.out.println(solution(2, cities3));
        System.out.println(solution(2, cities4));

    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        // 대소문자를 구별하지 않는다고 했으므로 전부 대문자로 치환
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toUpperCase();
        }
        // 만약 캐시사이즈가 0일 경우 예외 처리
        if(cacheSize == 0){
            return cities.length * 5;
        }
        // 캐시를 구현할 리스트
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < cities.length; i++) {
            // 만약 캐시안에 값이 존재하면 그 값을 제거하고 제일 뒤에 추가
            if (list.contains(cities[i])) {
                answer += 1;
                list.remove(cities[i]);
                list.add(cities[i]);
            } else {
                // 캐시안에 값이 없으나 캐시가 꽉차있다면 맨 앞 도시를 지우고, 맨뒤에 새로운 도시를 추가
                if (list.size() == cacheSize) {
                    list.remove(0);
                    list.add(cities[i]);
                    answer += 5;
                } else {
                    // 캐시안에 값이 없으나 캐시가 가득차지 않았다면 해당 도시를 추가
                    list.add(cities[i]);
                    answer += 5;
                }
            }
        }
        return answer;
    }
}
