package Map맵;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class 완주하지못한선수 {
    public static String solution(String[] participant, String[] completion) {
        Map<String,Integer> map = new HashMap<>();

        //참가한 선수들을 벡터에 저장(동명이인시 +1)
        for(String runner : participant){
            if(!map.containsKey(runner))
                map.put(runner,1);
            else
                map.put(runner,map.get(runner)+1);
        }

        //참가자가 완주하면 벡터에서 제거(동명이인:1 낮춤, 1->0:제거)
        for(String runner : completion){
            if(map.get(runner)==1)
                map.remove(runner);
            else
                map.put(runner,map.get(runner)-1);
        }

        //남은 완주자 출력
        Iterator<String> iter = map.keySet().iterator();
        return iter.next();
    }

    public static void main(String[] args){
        String[] participant1 = {"leo", "kiki", "eden"};
        String[] completion1 = {"eden", "kiki"};
        System.out.println(solution(participant1,completion1));

        String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
        System.out.println(solution(participant2,completion2));

        String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
        String[] completion3 = {"stanko", "ana", "mislav"};
        System.out.println(solution(participant3,completion3));
    }
}
