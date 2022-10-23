package main;

import java.util.Arrays;

public class 문자열_내_마음대로_정렬하기 {

    public static String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> { //람다식 활용
            if(s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2); //사전 순
            return s1.charAt(n) - s2.charAt(n); //n번째 문자 순
        });
        return strings;
    }

    public static void main(String[] args) {
        String[] arr = new String[] {"sun", "bed", "car"};
        System.out.println(Arrays.toString(solution(arr, 1)));
        arr = new String[] {"abce", "abcd", "cdx"};
        System.out.println(Arrays.toString(solution(arr,2)));
    }
}
