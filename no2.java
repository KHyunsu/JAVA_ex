package github;

public class no2 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 0, 6, 1, 5}));
    }
    // 프로그래머스 H-index 구하기
    public static int solution(int[] citations) {
        int h = 0;
        int cnt1;  // h번 이상 인용된 논문의 수
        int cnt2;  // h번 이하 인용된 논문의 수

        while (true) {
            cnt1 = 0;
            cnt2 = 0;
            // citation을 돌며 h번 이상 인용된 논문의 수와 h번 이하 인용된 논문의 수 구하기
            for (int i = 0; i < citations.length; i++) {
                if (citations[i] >= h) {
                    cnt1++;
                } else if (citations[i] <= h) {
                    cnt2++;
                }
            }
            // 문제의 조건대로 h번 이상 인용되고, h번 이하 인용되었다면 h값을 1증가시킨다.
            if (cnt1 >= h && cnt2 <= h) {
                h++;
            } else { // 만약 그렇지 않다면 h값의 최댓값은 현재 h값-1 이므로 h를 1감소시키고 루프를 빠져나간다.
                h--;
                return h;
            }
        }
    }
}
