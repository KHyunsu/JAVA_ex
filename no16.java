package github;


// 프로그래머스 [3치] n진수 게임
public class no16 {
    public static void main(String[] args) {
        System.out.println(solution(2, 4, 2, 1));
        System.out.println(solution(16, 16, 2, 1));
        System.out.println(solution(16, 16, 2, 2));
    }

    public static String solution(int n, int t, int m, int p) {
        // n진수로 변환한 수를 저장할 StringBuilder변수 선언
        StringBuilder sb = new StringBuilder();
        String anser = "";

        // 튜브가 말해야하는 숫자의 개수가 n개이므로 게임에 참가하는 사람의 숫자만큼 곱해서 수를 구해야한다
        for (int i = 0; i < t * m; i++) {
            sb.append(Integer.toString(i, n));
        }

        // 숫자의 순서가 0부터 시작하므로 p - 1부터 시작하여 튜브가 말해야하는 숫자를 추출
        for (int i = p - 1; i < t * m; i += m) {
            anser += sb.substring(i, i + 1);
        }
        // 문제의 조건인 대문자로 변환
        anser = anser.toUpperCase();
        return anser;
    }
}
