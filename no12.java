package github;

import java.util.ArrayList;

// 프로그래머스 [1차] 뉴스 클러스터링
public class no12 {
    public static void main(String[] args) {
        System.out.println(solution("handshake", "shake hands"));
        System.out.println(solution("FRANCE","french"));
        System.out.println(solution("aa1+aa2","AAAA12"));
        System.out.println(solution("E=M*C^2","e=m*c^2"));
    }

    public static int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        // 문자열을 2글자씩 끊어서 저장할 리스트 생성
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        for (int i = 0; i < str1.length() - 1; i ++) {
            // 2글자씩 끊어서 리스트에 저장, 영어 이외의 문자가 들어오면 그 문자는 없애버린다.
            String s = str1.substring(i, i + 2).replaceAll("[^A-Z]","");
            // 문자열에 영어 이외의 문자가 들어왔다면 문자열의 길이가 2보다 작으므로 리스트에 저장하지 않고 skip
            if(s.length() < 2){
                continue;
            }
            list1.add(s);
        }
        for (int i = 0; i < str2.length() - 1; i ++) {
            // 2글자씩 끊어서 리스트에 저장, 영어 이외의 문자가 들어오면 그 문자는 없애버린다.
            String s = str2.substring(i, i + 2).replaceAll("[^A-Z]", "");
            // 문자열에 영어 이외의 문자가 들어왔다면 문자열의 길이가 2보다 작으므로 리스트에 저장하지 않고 skip
            if(s.length() < 2){
                continue;
            }
            list2.add(s);
        }
        // 문제에서 제시한 리스트가 모두 비어있을 경우 예외처리
        if(list1.isEmpty() && list2.isEmpty()){
            return 65536;
        }
        // 교집합을 담을 리스트
        ArrayList<String> inter = new ArrayList<>();
        // 합집합을 담을 리스트
        ArrayList<String> union = new ArrayList<>();
        for(String s : list1){
            // 교집합이 존재한다면 해당 원소를 교집합 리스트에 넣는다
            if(list2.remove(s)){
                inter.add(s);
            }
            union.add(s);
        }
        // 교집합이 아닌 나머지 원소들을 합집합 리스트에 넣는다.
        union.addAll(list2);

        double answer =  (double) inter.size() / (double) union.size();
        return (int) (answer * 65536);
    }
}
