package com.programmers.java;

import java.util.*;

public class 자연수뒤집어배열로만들기 {
	public static int[] solution(int n) {
		List<Integer> answer = new ArrayList<>();
        
        //한 자리씩 리스트에 삽입
        while(n > 0){
            long count = n % 10;
            answer.add((int)count);
            n = n / 10;
        }
        
        //결과 리스트를 배열로
        return answer.stream().mapToInt(i->i).toArray();
	}
	
	public static void main(String[] args) {
		int n = 12345;
		System.out.println(Arrays.toString(solution(n)));
	}
}
