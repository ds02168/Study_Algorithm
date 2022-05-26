package StackQueue스택큐;
import java.util.*;
import java.util.stream.*;

public class 기능개발 {
    public static int[] solution(int[] progresses, int[] speeds) {
        //5 10 1 1 20 1 , 5
        //10 1 1 20 1, 5
        //10 1 1 20 1, 10
        //20 1, 10
        //20 1, 20
        // , 20

        int[] days = new int[progresses.length]; //작업 시간을 담는 배열
        for(int i=0;i<days.length;i++) //남은 작업 시간 계산
            days[i] = (int)Math.ceil((100 - (double)progresses[i]) / (double)speeds[i]);
        //queue : 남은 작업 시간을 담는 큐, list : 각 배포마다 몇개의 기능 배포
        Queue<Integer> queue = Arrays.stream(days).boxed().collect(Collectors.toCollection(LinkedList::new));
        List<Integer> list = new ArrayList<>();
        //큐가 빌 때 까지
        while(!queue.isEmpty()){
            int day = queue.peek(); //현재 작업이 걸리는 시간
            int task = 0; //현재 작업을 완료하는 동안 끝난 뒷 작업들
            while(!queue.isEmpty() && day >= queue.peek()){ //큐가 비지 않고 현재 작업 시간보다 적게 걸리는 작업들
                task++; //추가
                queue.poll(); //제거하고 다음 작업
            }
            list.add(task); //작업의 갯수를 리스트에 추가
        }
        return list.stream().mapToInt(i->i).toArray(); //리스트를 배열로 반환
    }

    public static void main(String[] args) {
        System.out.println("결과 : "+ Arrays.toString(solution(new int[]{93, 30, 55},new int[]{1, 30, 5})));
        System.out.println("결과 : " + Arrays.toString(solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));
    }
}
