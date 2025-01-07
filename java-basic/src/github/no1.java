package github;

import java.util.Arrays;

// 프로그래머스 가장 큰 수
public class no1 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 30, 34, 5, 9}));
        // 출력값: "9534303"
    }

    public static String solution(int[] numbers) {
        String[] arr = new String[numbers.length];

        // 답이 되는 배열의 값을 이어 붙이기 위한 StringBuilder 선언
        StringBuilder sb = new StringBuilder();

        // arr에 numbers 배열의 값을 String으로 바꿔 저장
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        // 첫번째 숫자를 비교하여 내림차순으로 저장
        // ex) o1 = 3, o2 = 30이면 o2 + o1 = 303, o1 + o2 = 330이므로 3보다 30이 큰 수로 인식
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        // 내림차순으로 정렬한 결과가 0인 경우 가장 큰 수는 0이므로 0을 출력
        if (arr[0].equals("0")) {
            return "0";
        }

        // String의 형태로 이어서 출력하기 위해 StringBuilder를 이용
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        // StringBuilder 값을 String으로 리턴
        return sb.toString();
    }
}
