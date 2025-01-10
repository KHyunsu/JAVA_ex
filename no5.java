package github;

import java.util.HashSet;

public class no5 {
    public static void main(String[] arr) {
        System.out.println(solution("17"));
    }
    // 중복을 허용하지 않고, 조합 가능한 숫자를 담을 HashSet
    static HashSet<Integer> hashSet = new HashSet<>();

    public static int solution(String numbers) {
        int answer = 0;
        // 가능한 조합을 찾기위한 함수 호출
        // 초기에 공백을 넣고 주어진 number를 하나씩 분리해서 가능한 조합을 찾는다
        findNumberSet("", numbers);

        // int 배열에 hashSet의 결과를 담는다
        int[] arr = hashSet.stream().mapToInt(Integer::intValue).toArray();
        // 찾은 조합 가능한 숫자들이 소수이면 1 증가
        for (int i : arr) {
            if (isPrime(i)) {
                answer++;
            }
        }

        return answer;
    }

    // 조합 가능한 수를 찾기위해 재귀호출로 구현한 함수(중복을 허용하지 않는 HashSet 이용)
    public static void findNumberSet(String comb, String others) {
        System.out.println(comb);
        // 비어있지 않으면 HashSet에 추가
        if (!comb.equals("")) {
            hashSet.add(Integer.parseInt(comb));
        }
        for (int i = 0; i < others.length(); i++) {
            if (!comb.equals("")) {
                hashSet.add(Integer.parseInt(comb));
            }
            // 가능한 조합을 찾기 위해 주어진 numbers를 하나씩 조합해가며 수를 찾는다.
            findNumberSet(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
        }
    }
    // 소수 판별 함수
    public static boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
