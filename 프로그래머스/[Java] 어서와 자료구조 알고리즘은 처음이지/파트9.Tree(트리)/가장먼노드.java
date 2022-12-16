package section9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node{
    int n;
    int dist = 0;
    boolean visit = false;
    List<Node> links = new LinkedList<>();
    Node(int n){ this.n = n;}
}

public class 가장먼노드 {
    public static int solution(int n, int[][] edge) {
        List<Node> list = new ArrayList<>();
        for(int i = 0; i < n; i++) list.add(new Node(i+1));

        for(int[] e : edge){
            Node n1 = list.get(e[0] - 1);
            Node n2 = list.get(e[1] - 1);
            n1.links.add(n2);
            n2.links.add(n1);
        }

        int maxDist = 0;

        Queue<Node> queue = new LinkedList<>();
        Node first = list.get(0);
        first.visit = true;
        queue.offer(first);
        while(!queue.isEmpty()){
            Node now = queue.poll();

            for(Node node : now.links){
                if(node.visit) continue;

                node.visit = true;
                node.dist = now.dist + 1;
                queue.offer(node);

                maxDist = Math.max(maxDist, node.dist);
            }
        }

        int answer = 0;
        for(Node node : list)
            if(maxDist == node.dist) answer++;
        return answer;
    }

    public static void main(String[] args) {
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution(6,vertex));
    }
}
