package com.programmers.java;

import java.util.*;

public class ÃÖ´ñ°ªÀÎµ¦½º±¸ÇÏ±â {

	public static int[] solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        //ÃÖ´ñ°ª ±¸ÇÏ±â
        for(int i : arr) {
        	list.add(i);
        }
        Collections.sort(list);
        int max = list.get(list.size()-1);
        
        //ÃÖ´ñ°ªÀÇ ÀÎµ¦½º ±¸ÇÏ±â
        for(int i=0;i<arr.length;i++) {
        	if(max == arr[i])
        		answer.add(i);
        }
        
        //°á°ú
        return answer.stream().mapToInt(i->i).toArray();
    }
	
	public static void main(String[] args) {
		int[] arr = {3, 6, 10, 1, 7, 2, 4, 6, 10, 9};
		System.out.println(Arrays.toString(solution(arr)));
	}

}
