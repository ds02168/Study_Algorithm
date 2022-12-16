package section9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node{
    int n;
    int win = 0, lose = 0; //승, 패
    boolean visit = false;
    List<Node> links = new LinkedList<>();
    Node(int n) {this.n = n;}
}

public class 순위 {
    public static int solution(int n, int[][] results) {
        //A가 B를 이기고 B가 C를 이기면 A는 C를 이긴것과 마찬가지
        //각 노드마다 BFS를 수행
        //제대로 알 수 있는 선수 : 승 + 패 == 선수수 - 1

        List<Node> list = new ArrayList<>();
        for(int i =0; i<n; i++) list.add(new Node(i+1));

        for(int[] result : results){
            Node winner = list.get(result[0] - 1);
            Node loser = list.get(result[1] - 1);
            winner.links.add(loser); //방향성을 가지므로 한쪽만
        }

        for(Node winner : list){
            //BFS
            for(Node node : list) node.visit = false;

            Queue<Node> queue = new LinkedList<>();

            winner.visit = true;
            queue.offer(winner);
            while(!queue.isEmpty()){
                Node now = queue.poll();

                for(Node loser : now.links){
                    if(loser.visit) continue;
                    loser.visit = true;

                    winner.win += 1;
                    loser.lose += 1;
                    queue.offer(loser);
                }
            }
        }

        //제대로 알 수 있는 선수 : 승 + 패 == 선수수 - 1
        int answer = 0;
        for(Node node : list){
            if(node.win + node.lose == n - 1) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        System.out.println(solution(5,results));
    }
}
