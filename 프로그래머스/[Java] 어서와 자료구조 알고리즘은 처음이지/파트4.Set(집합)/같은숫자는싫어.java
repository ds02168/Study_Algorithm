package Set집합;

import java.util.*;

public class 같은숫자는싫어 {
    public static int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        //첫 숫자는 구함
        int prev = arr[0];
        set.add(prev);

        for(int i=1;i<arr.length;i++){
            int now = arr[i];
            if(prev == now) set.add(now); //배열에서 같은 값이 나올때 까지 Set으로
            else{ //다른 값이 나오면 이전 값은 리스트로, Set에서 삭제, 새로운 값은 Set
                list.add(prev);
                set.remove(prev);
                set.add(now);
            }
            prev = now;
        }
        //배열 다 돌면 마지막 Set은 리스트로
        Iterator<Integer> iter = set.iterator();
        list.add(iter.next());
        //배열 반환
        return list.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        int[] input1 = {1,1,3,3,0,1,1};
        System.out.println(Arrays.toString(input1));
        System.out.println(Arrays.toString(solution(input1)));

        int[] input2 = {4,4,4,3,3};
        System.out.println(Arrays.toString(input2));
        System.out.println(Arrays.toString(solution(input2)));
    }
}
