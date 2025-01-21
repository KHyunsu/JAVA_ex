package github;

import java.util.ArrayList;
import java.util.Arrays;

//  프로그래머스 튜플
public class no11 {
    public static void main(String[] args) {
        System.out.println(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"));
    }

    public static int[] solution(String s) {
        // 튜플을 담을 list
        ArrayList<Integer> list = new ArrayList<>();
        // 양쪽 끝에 존재하는 "{{", "}}"제거, 문자열을 구분하기위해 "-"로 대체하고 나눈다.
        String[] arr = s.substring(2, s.length() - 2).replace("},{", "-").split("-");
        // 생성한 배열을 길이가 작은것부터 정렬
        Arrays.sort(arr, (a, b) -> {return a.length() - b.length();});

        for (String str : arr) {
            // 각 배열의 원소를 "," 기준으로 나누어 숫자만 존재하는 배열로 변환
            String[] arr2 = str.split(",");

            for (int i = 0; i < arr2.length; i++) {
                // 배열을 돌면서 String으로 나타낸 숫자를 int형으로 변경하고, 리스트에 없다면 추가
                int n = Integer.parseInt(arr2[i]);
                if (!list.contains(n)) {
                    list.add(n);
                }
            }
        }
        // 리스트를 문제에서 요구한 형태인 int형 배열로 반환
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
