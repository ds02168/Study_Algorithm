package test;

import java.util.*;

public class Hindex {

	public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        
        for(int i=0;i<citations.length;i++){
            int h = Math.min(citations[i],citations.length - i); //h�� �̻� �ο�� ���� h�� �̻�����
            answer = Math.max(answer,h); // h�� �ִ�
            
        }
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] citations = {3, 0, 6, 1, 5};
		System.out.println(solution(citations));
	}

}
