package test;

import java.util.*;

public class 전화번호목록 {

	public static boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashMap<String,Integer> hashmap = new HashMap<>();
        for(int i=0;i<phone_book.length;i++){
            hashmap.put(phone_book[i],i);
        }
        
        for(int i=0;i<phone_book.length;i++){
            for(int j=1;j<phone_book[i].length();j++){
                if(hashmap.containsKey(phone_book[i].substring(0,j)))
                    answer = false;
            }
        }
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] phone_book = {"119", "97674223", "1195524421"};
		System.out.println(solution(phone_book));
		
		String[] phone_book2 = {"123","456","789"};
		System.out.println(solution(phone_book2));
		
		String[] phone_book3 = {"12","123","1235","567","88"};
		System.out.println(solution(phone_book3));
	}

}
