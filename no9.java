package github;

import java.util.HashMap;
import java.util.HashSet;

// 프로그래머스 롤케이크 자르기
public class no9 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2}));
    }

    public static int solution(int[] topping) {
        // 케이크가 공평하게 잘라지는 경우의 수를 담을 count 변수
        int count = 0;
        // 토핑의 종류를 중복을 허용하자 않고 저장한 HashSet
        HashSet<Integer> set = new HashSet<>();
        // 토핑의 종류와 수를 저장할 HashMap
        HashMap<Integer, Integer> map = new HashMap<>();

        // topping 배열을 돌며 토핑의 종류와 갯수를 map에 추가
        for (int n : topping) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        // topping 배열을 돌며 map에서 하나씩 꺼내어 set에 넣고 map과 set의 크기를 비교하여 공평하게 나누어진지 확인
        for (int m : topping) {
            map.put(m, map.get(m) - 1);
            set.add(m);
            // 더이상 토핑이 없다면 map에서 제거
            if (map.get(m) == 0) {
                map.remove(m);
            }
            // 토핑이 공평하게 나누어져있다면 count 변수를 1 증가
            if (map.size() == set.size()) {
                count++;
            }
        }
        return count;
    }
}
