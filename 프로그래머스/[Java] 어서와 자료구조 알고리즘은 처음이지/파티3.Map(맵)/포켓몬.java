package Map맵;

import java.util.HashMap;
import java.util.Map;

public class 포켓몬 {
    public static int solution(int[] nums){
        //해쉬맵 만들기(중복 제거)
        Map<Integer,Integer> map = new HashMap<>();

        //뽑는 횟수 구하기
        int answer = nums.length / 2;

        //하나씩 뽑아 벡터에 저장
        for(int num : nums){
            map.put(num,1); //종류의 갯수가 중요하지 몇개인지는 중요하지 않으므로 value는 1 넣어도 무관합니다.
        }
        // 종류 갯수 >= 뽑는 횟수 = 뽑는 횟수(위에서 구함)
        // 종류 갯수 < 뽑는 횟수 = 종류 갯수
        if(map.size() < answer)
            answer = map.size();

        return answer;
    }

    public static void main(String[] args){
        int[] nums = {3,1,2,3};
        System.out.println(solution(nums));

        int[] nums2 = {3,3,3,2,2,4};
        System.out.println(solution(nums2));

        int[] nums3 = {3,3,3,2,2,2};
        System.out.println(solution(nums3));
    }
}
