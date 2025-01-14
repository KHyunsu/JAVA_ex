package github;

import java.util.Arrays;

// 프로그래머스 행렬의 곱셈
public class no7 {
    public static void main(String[] args) {
        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};
        System.out.println(Arrays.toString(solution(arr1, arr2)));
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        // 행렬의 곱셈값을 담을 answer 배열
        int[][] answer = new int[arr1.length][arr2.length];

        // 반복문을 통해 행렬의 곱셈을 시행하고 answer 배열에 저장
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                int n = 0;
                for (int k = 0; k < arr2[0].length; k++) {
                    n += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = n;
            }
        }
        return answer;
    }
}
