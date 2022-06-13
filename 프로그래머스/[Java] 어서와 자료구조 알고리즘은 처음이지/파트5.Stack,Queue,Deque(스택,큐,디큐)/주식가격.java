package StackQueue스택큐;

import java.util.*;

public class 주식가격 {
    public static int[] solution(int[] prices){
        //하락하지 않은 시간을 저장하는 배열
        int[] times = new int[prices.length];

        //가격당 비교
        for(int i=0;i<prices.length;i++){
            int time = 0; //유지 시간
            int price = prices[i]; //가격
            //몇초 동안 유지되는지 비교
            for(int j = i+1; j < prices.length;j++){
                time++; //1초 추가
                if(price > prices[j]) break; //하락시 멈춤
            }
            times[i] = time; //유지시간 저장
        }

        return times; //시간을 담은 배열 반환
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1,2,3,2,3})));
    }
}
