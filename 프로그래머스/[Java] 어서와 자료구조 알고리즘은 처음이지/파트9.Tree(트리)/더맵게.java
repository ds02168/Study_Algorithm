package Practice;

import java.util.PriorityQueue;
import java.util.Queue;

public class 더맵게 {
    public static int solution(int[] scoville, int K) {
        Queue<Integer> list = new PriorityQueue<>();
        for(int s : scoville) list.add(s);

        int answer = 0;


        while(list.size() >= 2 && list.peek() < K){
            int s1 = list.poll();
            int s2 = list.poll();
            int s3 = s1 + s2 * 2;
            list.offer(s3);
            answer++;
        }
        if(list.peek() < K) return -1;

        return answer;
    }

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        System.out.println(solution(scoville,7));
    }
}
