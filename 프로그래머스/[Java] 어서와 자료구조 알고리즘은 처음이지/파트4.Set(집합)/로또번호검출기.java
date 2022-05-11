package Set집합;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 로또번호검출기 {
    public static boolean solution(int[] lotto) {
        Set<Integer> set = new HashSet<>();
        //OMR을 Set에 삽입
        for(int x : lotto) set.add(x);
        //중복여부 확인(6이 아닐시 중복 발생!)
        return set.size() == 6;
    }
    public static void main(String[] args){
        int[] input1 = {4, 7, 32, 43, 22, 19};
        System.out.println(Arrays.toString(input1));
        System.out.println(solution(input1));

        int[] input2 = {3, 19, 34, 39, 39, 20};
        System.out.println(Arrays.toString(input2));
        System.out.println(solution(input2));
    }
}
