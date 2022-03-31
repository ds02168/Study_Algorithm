package test;

import java.util.*;

public class 캐시 {

	public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        int number;
        ArrayList<String> cache = new ArrayList<String>();
        
        for(String city:cities){
            city = city.toLowerCase();
            number = -1;
            
            for(int i=0;i<cache.size();i++){
                if(i == cacheSize) break; //캐쉬 크기 만큼 봄
                
                if(cache.get(i).equals(city)){ //hit시
                    number = i; //캐시내 번호 저장
                    break;
                }
            }
            
            if(cacheSize == 0){ //캐시 size = 0
                answer += 5;
            }else if(cache.size() < cacheSize){ //캐쉬가 덜 찼을 때, 추가만
                if(number == -1){ //miss
                    answer+=5;
                }else{ //hit
                    answer+=1;
                }
            }else{ //캐쉬가 다 찼을 때, 맨앞이나 해당 요소 삭제
                if(number == -1){ //miss
                    answer+=5;
                    cache.remove(0);
                }else{ //hit
                    answer+=1;
                    cache.remove(number);
                }
            }
            
            cache.add(city); //갱신
            
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int cacheSize = 3;
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		System.out.println(solution(cacheSize,cities));
		
		cacheSize = 3;
		String[] cities2 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
		System.out.println(solution(cacheSize,cities2));
		
		cacheSize = 2;
		String[] cities3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
		System.out.println(solution(cacheSize,cities3));
		
		cacheSize = 5;
		String[] cities4 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
		System.out.println(solution(cacheSize,cities4));
		
		cacheSize = 2;
		String[] cities5 = {"Jeju", "Pangyo", "NewYork", "newyork"};
		System.out.println(solution(cacheSize,cities5));
		
		cacheSize = 0;
		String[] cities6 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		System.out.println(solution(cacheSize,cities6));

	}

}
