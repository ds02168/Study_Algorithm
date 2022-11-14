package section8;

import java.util.LinkedList;
import java.util.Queue;

public class 네트워크 {
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n]; //방문 여부

        //컴퓨터 하나씩 네트워크 검색
        for(int i = 0 ; i < computers.length; i++){
            if(visited[i]) continue; //이미 방문한 적이 있는 컴퓨터는 패스
            answer++; //네트워크 갯수 추가
            visitAllConnectedComputers(computers,visited,i); //연결된 컴퓨터 모두 방문
        }
        return answer;
    }

    //네트워크 내 컴퓨터 모두 방문(BFS)
    static void visitAllConnectedComputers(final int[][] computers, boolean[] visited, int c){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(c);

        while(!queue.isEmpty()){
            int computer = queue.poll();
            for(int adjacent = 0; adjacent < computers[computer].length; adjacent++){
                if(visited[adjacent]) continue;
                if(computers[computer][adjacent] == 1){
                    visited[adjacent] = true;
                    queue.offer(adjacent);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] computers1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(solution(n,computers1));

        int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        System.out.println(solution(n,computers2));
    }
}
