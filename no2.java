package assignment;

import java.util.*;
import java.io.IOException;

public class no2 {
    // 방문여부를 담을 check배열
    static boolean check[];
    // 정답을 담을 StringBuilder
    static StringBuilder sb = new StringBuilder();
    // bfs, dfs를 이용하기위해 static변수로 선언
    static int node, line, start;
    // 간선의 유무를 담을 배열 선언
    static boolean[][] arr;
    // bfs에 필요한 큐 선언
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        node = sc.nextInt();
        line = sc.nextInt();
        start = sc.nextInt();
        check = new boolean[node + 1];
        arr = new boolean[node + 1][node + 1];

        for (int i = 0; i < line; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            // 문제에서 주어진 간선은 양방향이다 처리
            arr[x][y] = arr[y][x]  = true;
        }
        dfs(start);
        sb.append("\n");
        check = new boolean[node + 1];
        bfs(start);

        System.out.println(sb);
    }

    public static void dfs(int start) {
        // 시작 노드 방문 처리
        check[start] = true;
        sb.append(start + " ");
        for (int i = 0; i <= node; i++) {
            // 간선이 존재하고, 방문하지 않았다면 dfs를 재귀 호출
            if (arr[start][i] && !check[i]) {
                dfs(i);
            }
        }

    }

    public static void bfs(int start) {
        // 큐에 시작 노드를 삽입하고 방문 처리
        queue.add(start);
        check[start] = true;

        while (!queue.isEmpty()) {
            start = queue.poll();
            sb.append(start + " ");

            for (int i = 1; i <= node; i++) {
                // 시작 노드에 대해 간선이 존재해야 하고, 방문하지 않았다면 큐에 삽입하고 방문처리를 한다.
                if (arr[start][i] && !check[i]) {
                    queue.add(i);
                    check[i] = true;
                }
            }
        }
    }
}

