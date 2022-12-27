package main;

import java.util.HashMap;
import java.util.Map;

public class 포켓몬 {
    public static int solution(int[] nums) {
        int answer = nums.length / 2; //최대로 많이 나올 수 있는 종류 == 포켓몬수 / 2
        //HashMap에 포켓몬 (종류, 수)쌍으로 저장
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        //같은 종류 두번째 선택부터는 종류의 갯수 변화 x
        //포켓몬의 종류가 N/2보다 많으면 N/2가 최대 작으면 포켓몬의 종류만큼이 최대치
        return map.size() >= answer ? answer : map.size();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,1,2,3}));
        System.out.println(solution(new int[]{3,3,3,2,2,4}));
        System.out.println(solution(new int[]{3,3,3,2,2,2}));
    }
}
