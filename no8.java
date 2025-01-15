package github;

// 프로그래머스 피로도
public class no8 {
    public static void main(String[] args){
        int[][] dungeons = {{80, 20},{50, 40}, {30,10}};
        System.out.println(solution(80, dungeons));
    }
    // 방문 여부를 담을 visited 배열
    public static boolean[] visited;
    // 정답을 담을 answer 변수
    public static int answer = 0;

    public static int solution(int k, int[][] dungeons){
        // 던전의 수 만큼 visited 배열을 초기화
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return answer;
    }
    private static void dfs(int depth, int fatigue, int[][] dungeons){
        for(int i = 0; i < dungeons.length; i++){
            // 방문한 던전이라면 continue를 통해 다음 던전으로 skip
            if(visited[i] || (dungeons[i][0] > fatigue)){
                continue;
            }
            // 방문하지 않았다면 방문 처리
            visited[i] = true;
            // depth를 1 증가시켜 현재 피로도에서 방문한 던전의 피로드만큼 감소한 후 재귀호출을 통해 다음 던전 탐색
            dfs(depth + 1, fatigue - dungeons[i][1], dungeons);
            // 다음 depth의 던전을 위의 반복문에서 탐색해야하므로 방문하지 않았다고 처리함
            visited[i] = false;
        }
        answer = Math.max(answer, depth);
    }
}
