package main;

import java.util.Arrays;

public class HIndex {
    public static int solution(int[] citations) {
        Arrays.sort(citations); //순서는 상관 없음
        int answer = 0;
        for(int i=0;i<citations.length;i++){
            int h = citations.length - i; //h편 이상 인용
            if(citations[i] >= h) return h; //값이 크거나 같아지면 그 값임
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {3, 0, 6, 1, 5};
        System.out.println(solution(arr));
    }
}
