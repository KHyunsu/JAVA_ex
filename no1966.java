package solved;

import java.io.*;
import java.util.*;

// 백준 1966번 프린터 큐
public class no1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());

            // 공백으로 구분하여 입력받기 때문에 StringTokenizer 이용
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 프린트할 순서와 중요도를 함께 담을수 있도록 int 배열로 queue 선언
            Queue<int[]> queue = new LinkedList<int[]>();

            // 중요도를 입력받고
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                // 공백으로 중요도를 구분하기 때문에 마찬가지로 StringTokenizer 이용
                int num = Integer.parseInt(st.nextToken());

                queue.add(new int[]{j, num});
            }

            int cnt = 0;
            while (true) {
                int[] cur = queue.poll();
                // 중요도가 더 높은 원소가 큐 내부에 존재하는지 판별하기 위한 boolean 변수
                boolean check = true;

                // 중요도가 더 높은 원소가 큐 내부에 존재한다면 check변수를 false로 만들어준다.
                for (int[] curQ : queue) {
                    if (curQ[1] > cur[1]) {
                        check = false;
                        break;
                    }
                }
                // 추출한 원소가 중요도가 가장 높은 경우 cnt를 1증가 시키고 만약 찾는 수와 일치하다면 반복문을 빠져나오고 값을 인쇄한다
                if (check) {
                    cnt++;
                    if (cur[0] == M) break;
                // 중요도가 더 높은 원소가 큐 내부에 존재하기 때문에 맨 뒤로 다시 삽입
                } else {
                    queue.add(cur);
                }
            }
            System.out.println(cnt);
        }
    }
}
