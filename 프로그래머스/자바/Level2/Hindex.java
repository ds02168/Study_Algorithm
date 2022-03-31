package test;

import java.util.*;

public class Hindex {

	public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        
        for(int i=0;i<citations.length;i++){
            int h = Math.min(citations[i],citations.length - i); //h번 이상 인용된 논문이 h편 이상인지
            answer = Math.max(answer,h); // h의 최댓값
            
        }
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] citations = {3, 0, 6, 1, 5};
		System.out.println(solution(citations));
	}

}
