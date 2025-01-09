package github;

import java.util.*;

public class no4 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5})));
    }

    public static int[] solution(int[] answers) {
        int[] no1 = {1, 2, 3, 4, 5};
        int[] no2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] no3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = {0, 0 ,0};

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == no1[i % 5]) {
                score[0]++;
            }
            if (answers[i] == no2[i % 8]) {
                score[1]++;
            }
            if (answers[i] == no3[i % 10]) {
                score[2]++;
            }
        }
        int max_score = Math.max(score[0], Math.max(score[1], score[2]));

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if (max_score == score[i]) {
                list.add(i + 1);
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
