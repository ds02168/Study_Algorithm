package main;


import java.util.Arrays;

public class 제일_작은_수_제거하기 {
    public static int[] solution(int[] arr) {
        //길이가 1이면 빈 배열
        if(arr.length == 1) return new int[] {-1};
        //최솟 값 구하기
        int min = Arrays.stream(arr).min().getAsInt();
        //최솟 값 제거
        int[] answer = Arrays.stream(arr).filter(i -> i != min).toArray();

        return answer;
    }


    public static void main(String[] args) {
        int[] arr = new int[] {4,3,2,1};
        System.out.println(Arrays.toString(solution(arr)));
        arr = new int[] {10};
        System.out.println(Arrays.toString(solution(arr)));
    }
}
