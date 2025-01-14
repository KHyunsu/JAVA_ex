package github;


import java.util.Arrays;

// 프로그래머스 카펫
public class no6 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10, 2)));
        System.out.println(Arrays.toString(solution(8, 1)));
        System.out.println(Arrays.toString(solution(24, 24)));
    }

    public static int[] solution(int brown, int yellow) {
        // 답을 반환할 answer 배열 선언
        int[] answer = new int[2];

        //카펫의 총 갯수를 확인하기 위한 sum
        int sum = brown + yellow;

        // yellow색 카펫이 1개밖에 없는경우 예외 처리
        if (yellow == 1) {
            answer[0] = 3;
            answer[1] = 3;
            return answer;
        }
        // 두 수를 곱해서 yellow가 나오는 x, y 값을 찾고, brown색을 덮었을 때 카펫의 총 갯수와 sum이 일치하는지 확인
        for (int i = 1; i <= yellow / 2; i++) {
            int x = 0;
            int y = 0;
            if (yellow % (i) == 0) {
                x = yellow / i;
                y = i;
            }
            if ((x + 2) * (y + 2) == sum) {
                answer[0] = x + 2;
                answer[1] = y + 2;
                return answer;
            }
        }
        return answer;
    }
}
