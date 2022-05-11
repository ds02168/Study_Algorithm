package Set집합;
import java.util.*;

public class 끝말잇기 {
    public static boolean solution(String[] words) {
        Set<String> set = new HashSet<>();
        String prev= "";
        //단어를 Set에 입력
        for(String word : words){
            if(set.size() >= 1){ //2번째 단어부터
                if(word.charAt(0) != prev.charAt(prev.length()-1)) return false;
                //이전 단어와 현재 단어가 다르면 false반환
            }
            set.add(word);
            prev = word;
        }
        //단어 배열길이 == Set길이 시 중복 x
        return set.size() == words.length;
    }

    public static void main(String[] args) {
        String[] input1 = {"tank", "kick", "know", "wheel", "land", "dream"};
        System.out.println(Arrays.toString(input1));
        System.out.println(solution(input1));

        String[] input2 = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        System.out.println(Arrays.toString(input2));
        System.out.println(solution(input2));
    }
}
