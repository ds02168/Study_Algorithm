package test;

import java.util.*;

public class Ʃ�� {

	public static int[] solution(String s) {
        String[] arr = s.split("},"); //���ڿ� ���� �迭 ����
        String temp="";
        String[] temps;
        int[][] answers = new int[arr.length][]; //���ڿ��� ġȯ�� �迭 ����(����)
        HashMap<Integer,Integer> hash = new HashMap<>(); //���� Ƚ�� ����

        
        //�迭�� ġȯ
        for(int i=0;i<arr.length;i++) {
            temp = arr[i].replaceAll("[{|}]",""); //���ȣ ����
            temps = temp.split(","); //�޸� ����
            
            answers[i] = new int[temps.length]; //2���� ���� �迭
            
            for(int j=0;j<temps.length;j++) {
                answers[i][j] = Integer.parseInt(temps[j]); //��Ʈ�� ��ȯ�� ����
            }
        }
        
        //�ؽøʿ� ���� Ƚ�� ����
        for(int i=0;i<answers.length;i++) {
        	for(int j=0;j<answers[i].length;j++) {
        		if(!hash.containsKey(answers[i][j])) //ó��
        			hash.put(answers[i][j], 1); //1
        		else //�̹� ����
        			hash.put(answers[i][j], hash.get(answers[i][j])+1); //+1
        	}
        }
        
        //�������� ����
        List<Integer> KeySetList = new ArrayList<>(hash.keySet());
        Collections.sort(KeySetList, new Comparator<Integer>() { //Comparator �������̽�
        	public int compare(Integer o1, Integer o2) {
        		return hash.get(o2).compareTo(hash.get(o1)); //��������
        	}
        });
        
        //�迭 ����
        int[] answer = new int[KeySetList.size()]; //�迭 ũ��
        for(int i=0;i<KeySetList.size();i++) {
        	answer[i] = KeySetList.get(i); //��� ����
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		System.out.println(Arrays.toString(solution(s)));
		
		s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
		System.out.println(Arrays.toString(solution(s)));
		
		s = "{{20,111},{111}}";
		System.out.println(Arrays.toString(solution(s)));
		
		s = "{{123}}";
		System.out.println(Arrays.toString(solution(s)));
		
		s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		System.out.println(Arrays.toString(solution(s)));
		
	}

}
