package com.programmers.java;

import java.util.*;

public class �ڿ���������迭�θ���� {
	public static int[] solution(int n) {
		List<Integer> answer = new ArrayList<>();
        
        //�� �ڸ��� ����Ʈ�� ����
        while(n > 0){
            long count = n % 10;
            answer.add((int)count);
            n = n / 10;
        }
        
        //��� ����Ʈ�� �迭��
        return answer.stream().mapToInt(i->i).toArray();
	}
	
	public static void main(String[] args) {
		int n = 12345;
		System.out.println(Arrays.toString(solution(n)));
	}
}
