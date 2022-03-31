package test;

import java.util.HashMap;
import java.util.Iterator;

public class ���� {

	public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> hashmap = new HashMap<String,Integer>();
        
        for(int i=0;i<clothes.length;i++){
            if(hashmap.containsKey(clothes[i][1])) //�̹� �ִ� ����
                hashmap.put(clothes[i][1], hashmap.get(clothes[i][1])+1); // 1�� �߰�
            else
                hashmap.put(clothes[i][1],2); //2�߰�, �ܵ� ���� �ϹǷ�
        }
        
        Iterator<Integer> iter = hashmap.values().iterator();
        while(iter.hasNext()){
            answer *= iter.next(); //������ ���� �ʿ�, ī�׼� ��
        }
        return answer - 1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		System.out.println(solution(clothes));
		
		String[][] clothes2 = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
		System.out.println(solution(clothes2));
	}

}
