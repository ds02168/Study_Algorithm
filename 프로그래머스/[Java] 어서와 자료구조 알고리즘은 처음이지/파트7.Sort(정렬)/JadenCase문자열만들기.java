package main;

public class JadenCase문자열만들기 {
    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();
        //소문자로 초기화
        s = s.toLowerCase();

        char last = ' ';
        //이전 문자가 공백이면 대문자로
        for(char c : s.toCharArray()){
            if(last == ' ') c = Character.toUpperCase(c);
            answer.append(c);
            last = c;
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        String s = "3people unFollowed me";
        System.out.println(solution(s));
        s = "for the last week";
        System.out.println(solution(s));
    }
}
