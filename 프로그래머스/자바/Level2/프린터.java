package test;

import java.util.*;

public class 프린터 {

	public static int solution(int[] priorities, int location) {
        int answer = 0;
        int print = priorities[location];
        boolean is_print;
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<priorities.length;i++){
            queue.add(priorities[i]);
        }
        
        while(true){
            Iterator<Integer> it = queue.iterator();
            is_print = true;
            
            int max = it.next(); //맨앞 최대로 가정
            while(it.hasNext()){
                int temp = it.next();
                
                if(max < temp){ //최대가 아니면
                    max = temp;
                    is_print=false; //인쇄x
                }
            }
            
            int first = queue.poll(); //맨 앞고
            location--; //위치 -1
              
            if(is_print){ //최대값이면
                answer++; //출력 +1
                if(first == print && location == -1) //출력값이고 위치가 0이면(인쇄하고자 하는 값이면)
                    break;
            }else{ //최대값이 아니면
                queue.add(first); //맨뒤에 추가
                if(location == -1) //뽑고자하는 값이면
                    location = queue.size()-1; //위치 맨뒤로 해줌
            }
            
        }
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] properties = {2, 1, 3, 2};
		int location = 2;
		System.out.println(solution(properties,location));
		
		int[] properties2 = {1, 1, 9, 1, 1, 1};
		int location2 = 0;
		System.out.println(solution(properties2,location2));
	}

}
