package test;

import java.util.*;

public class ������ {

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
            
            int max = it.next(); //�Ǿ� �ִ�� ����
            while(it.hasNext()){
                int temp = it.next();
                
                if(max < temp){ //�ִ밡 �ƴϸ�
                    max = temp;
                    is_print=false; //�μ�x
                }
            }
            
            int first = queue.poll(); //�� �հ�
            location--; //��ġ -1
              
            if(is_print){ //�ִ밪�̸�
                answer++; //��� +1
                if(first == print && location == -1) //��°��̰� ��ġ�� 0�̸�(�μ��ϰ��� �ϴ� ���̸�)
                    break;
            }else{ //�ִ밪�� �ƴϸ�
                queue.add(first); //�ǵڿ� �߰�
                if(location == -1) //�̰����ϴ� ���̸�
                    location = queue.size()-1; //��ġ �ǵڷ� ����
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
