package main;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {

    public static String solution(String[] participant, String[] completion) {
        // 참가자 - 완주자 = 완주하지  못한 선수

        String answer = "";
        Map<String,Integer> map = new HashMap<>(); //해시 맵(선수 저장)

        //참가자들 해시맵에 저장
        //처음 나오는 이름 : 1, 동명이인 : +1
        for(String runner : participant){
            map.put(runner, map.getOrDefault(runner, 0) + 1);
        }

        //해시맵에 완주자들 제거
        //완주자: - 1
        for(String runner : completion){
            map.put(runner, map.get(runner) - 1);
        }

        //참가자 명단에서 더하고, 완주자들 명단에서 다 빼고 남은 사람은 완주하지 못한 사람
        for(String runner : map.keySet()){
            int count = map.get(runner); //해당 이름의 참가자 - 완주자 수를 구함
            if(count > 0) answer = runner; //완주하지 못한 사람의 이름 > 0
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
        System.out.println(solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));
        System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"}));
    }
}
