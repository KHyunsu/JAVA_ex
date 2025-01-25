package github;

// 프로그래머스 k진수에서 소수 개수 구하기
public class no15 {
    public static void main(String[] args) {
        System.out.println(solution(437674, 3));
        System.out.println(solution(110011, 10));
    }

    public static int solution(int n, int k) {
        // 소수의 개수를 파악할 answer
        int answer = 0;
        // k진수를 저장할 StringBuilder 변수
        StringBuilder sb = new StringBuilder();

        // 주어진 n을 k진수로 변환
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        sb.append(n).reverse();
        // 문제에서 제시한 조건대로 0을 기준으로 수를 나눈다.
        String[] arr = sb.toString().split("0");

        for (int i = 0; i < arr.length; i++) {
            // 0이 연속으로 나오는 경우 배열에 공백이 저장되어 있을수 있으므로 예외 처리
            if (arr[i].isEmpty()) {
                continue;
            }
            // 배열의 원소가 소수이면 counting
            if (isPrime(Long.parseLong(arr[i]))) {
                answer++;
            }
        }
        return answer;
    }

    // 소수인지 판별하는 isPrime 함수(문제에서 n의 범위가 1 이상 1,000,000이하라고 했으므로 long을 받는다)
    public static boolean isPrime(long n) {
        boolean isPrime = true;
        if (n < 2) {
            isPrime = false;
            return isPrime;
        }
        if (n == 2) {
            isPrime = true;
            return isPrime;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                isPrime = false;
            }
        }
        return isPrime;
    }
}
