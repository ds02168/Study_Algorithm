package com.programmers.java;

import java.util.*;

public class �����˻� {
	public static boolean solution(int[] arr) {
		boolean answer = true;
		//����
		Arrays.sort(arr);
		//���� �˻�
		for(int i=0;i<arr.length;i++) {
			if((i+1) != arr[i]) {
				answer = false;
				break;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		int[] arr = {4, 1, 3, 2};
		System.out.println(solution(arr));
		
		int[] arr2 = {4, 1, 3};
		System.out.println(solution(arr2));
	}
}
