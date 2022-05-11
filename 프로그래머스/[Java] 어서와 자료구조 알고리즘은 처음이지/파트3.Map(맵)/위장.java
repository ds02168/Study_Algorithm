package Map맵;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class 위장 {
    public static int solution(String[][] clothes){
        int answer = 1;
        Map<String,Integer> map = new HashMap<>();
        //Hashmap에 삽입
        for(String[] cloth : clothes){
            map.put(cloth[1],map.getOrDefault(cloth[1],1) + 1);
        }
        //조합 계산
        Iterator<Integer> iter = map.values().iterator();
        while(iter.hasNext()){
            answer *= iter.next();
        }
        //아무것도 입지 않은 경우는 제외
        return answer - 1;
    }

    public static void main(String[] args){
        String[][] clothes1 = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"},
                {"green_turban", "headgear"}};
        String[][] clothes2 = {{"crowmask", "face"}, {"bluesunglasses", "face"},
                {"smoky_makeup", "face"}};

        System.out.println(solution(clothes1));
        System.out.println(solution(clothes2));
    }
}
