package Algorithm;

import java.util.*;

public class �޴������� {
	public static HashMap<String,Integer> hash = new HashMap<>(); //������ Ƚ���� �����ϴ� �ؽø�
        
    public static String[] solution(String[] orders, int[] course) {
        ArrayList<String> result = new ArrayList<>();
        HashMap<Integer,Integer> max = new HashMap<>(); //�� �ڽ��޴��� �ִ� ũ��
        
        
        //�޴��� ���� ���ϱ�
        for(int i=0;i<course.length;i++){
           for(int j=0;j<orders.length;j++){
               String[] order = orders[j].split("");
               int n = orders[j].length();
               boolean[] visited = new boolean[n];
               combination(order,visited,0,n,course[i]); //����
           }
        }
        
        //�� �޴������� �ĺ��� ������ Ƚ��, �� �޴��� �ִ� ���ϱ�
        Iterator<String> keys = hash.keySet().iterator();
        while(keys.hasNext()){
            String key = keys.next();
            int menu_num = key.length();
            
            if(hash.get(key) < 2) //1���� ��������
                continue;
            
            if(!max.containsKey(menu_num)) //�ش� ���� �ֹ��� ó���϶�
                max.put(menu_num,hash.get(key));
            else{ //�̹� �ٸ� �ֹ��� �����
                if(max.get(menu_num) < hash.get(key)) //������ �ֹ� ���պ��� Ƚ���� ��������
                    max.put(menu_num,hash.get(key)); //�ٲ�
            }
        }
        
        //�ڽ��丮 �޴� �ĺ� ���
        keys = hash.keySet().iterator();
        while(keys.hasNext()){
            String key = keys.next();
            int menu_num = key.length(); //������ Ƚ��
            if(hash.get(key) == max.get(menu_num)) //�ڽ��޴� �ĺ���
                result.add(key);
        }
        
        Collections.sort(result); //����
        return result.toArray(new String[0]);
    }
    
    //����
    //order[]�� ����, visited[]�� �湮, start�� �����ε���, nCr���� n���߿� r���� ����
    public static void combination(String[] order, boolean[] visited, int start, int n, int r){
        if(r == 0){
            String key = "";
            for(int i=0;i<n;i++){ //���� ���
                if(visited[i]){
                    key += order[i];
                }
            }
            
            //����
            char[] temp = key.toCharArray();
            Arrays.sort(temp);
            key = new String(temp);
            
            //�������� ������ 1
            if(!hash.containsKey(key))
                hash.put(key,1);
            else //�����ϸ� +1
                hash.put(key,hash.get(key)+1);
            
            return;
        }
        
        for(int i =start;i<n;i++){
            visited[i] = true;
            combination(order,visited,i+1,n,r-1);
            visited[i] = false;
        }
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2,3,4};
		String[] results = solution(orders,course);
		for(String result : results)
			System.out.print(result + " ");
		System.out.println();
		
		hash = new HashMap<>(); //static�� �ʱ�ȭ
		String[] orders2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		int[] course2 = {2,3,5};
		String[] results2 = solution(orders2, course2);
		for(String result2 : results2)
			System.out.print(result2 + " ");
		System.out.println();
		
		hash = new HashMap<>(); //static�� �ʱ�ȭ
		String[] orders3 = {"XYZ", "XWY", "WXA"};
		int[] course3 = {2,3,4};
		String[] results3 = solution(orders3, course3);
		for(String result3 : results3)
			System.out.print(result3 + " ");
		System.out.println();
	}

}
