package main;

import java.util.HashMap;
import java.util.Map;

public class 위장 {
    public static int solution(String[][] clothes) {
        int answer = 1; //조합의 수를 저장
        Map<String,Integer> map = new HashMap<>();
        //그 종류의 옷을 안입는 경우를 반영
        //ex) A, B, C 종류의 의상이 있을 때 A : O, B : X, C: X인 경우
        //B,와 C를 입지 않는 경우도 포함해야 하므로 기본값이 0이아닌 1부터 시작
        for(String[] cloth : clothes) map.put(cloth[1],map.getOrDefault(cloth[1], 1) + 1);
        for(int count : map.values()) answer *= count; //조합의 갯수를 곱함
        //아무것도 입지 않는 경우는 없으므로 -1
        return answer - 1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
        System.out.println(solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));
    }
}
