package section8;

import java.util.*;

//문자를 담는 정보
class Node{
    String word; //문자
    int depth; //깊이
    Node(String word, int depth){
        this.word = word;
        this.depth = depth;
    }
}


class Solution {
    public static int solution(String begin, String target, String[] words) {
        if(!Arrays.asList(words).contains(target)) return 0; //words에 존재하지 않는 단어

        Stack<Node> stack = new Stack<>();
        Set<String> used = new HashSet<>(); //이미 방문했는지 포함

        stack.push(new Node(begin,0));

        //스택이 빌 떄 까지
        while(!stack.isEmpty()){
            Node now = stack.pop();
            //target 찾음
            if(now.word.equals(target)) return now.depth;

            for(String word : words){
                if(used.contains(word)) continue; //이미 한번 방문함
                if(!changeable(now.word, word)) continue; //1글자 차이가 아님

                //깊이 +1 해서 스택에 추가
                stack.push(new Node(word, now.depth+1));
                used.add(word); //사용함 표시
            }
        }

        return 0;
    }

    static boolean changeable(String w1, String w2){
        //w2와 w1의 글자가 1글자 차이인지 확인
        int length = Math.min(w1.length(),w2.length());
        int count = 0;
        for(int i = 0; i < length && count < 2; i++)
            if(w1.charAt(i) != w2.charAt(i)) count++;
        return count == 1;
    }

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";

        String[] words1 = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution(begin,target,words1));

        String[] words2 = {"hot", "dot", "dog", "lot", "log"};
        System.out.println(solution(begin,target,words2));
    }
}

