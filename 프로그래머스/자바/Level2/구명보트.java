package test;

import java.util.*;

public class 구명보트 {

	public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        
        while(left <= right){
            if(people[left] + people[right] <= limit){
                left++;
                right--;
            }else
                right--;
            
            answer++;
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int[] people = {70, 50, 80, 50};
		int limit = 100;
		System.out.println(solution(people,limit));
		
		int[] people2 = {70, 80, 50};
		limit = 100;
		System.out.println(solution(people2,limit));
	}
}
