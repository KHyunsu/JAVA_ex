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
// 처음에 문제를 풀 때는 단지 cnt2가 cnt1보다 커지는 순간 루프를 빠져나오는 것으로 문제를 이해했었다. 막상 테스트케이스를 돌려보니 예상한 답과는 전혀 다른 답이 나와서 당황했다
// 문제를 다시 자세히 읽어보고 문제에 나온 조건 그대로 h번 이상 인용된 논문의 수가 h개 이상이고, h번 이하 인용된 논문의 수가 h개 이하이면 h를 1증가 시키는 조건을 적용했다
// 만약 위에 제시한 조건이 다르다면 현재의 h값이 최대가 아닌 그보다 1작은 값이 최대인 h값이 되므로 h값을 1 감소 시키고 루프를 빠져나가도록 구사했다.
