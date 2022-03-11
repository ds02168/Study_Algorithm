package Algorithm;

import java.util.*;

public class 메뉴리뉴얼 {
	public static HashMap<String,Integer> hash = new HashMap<>(); //조합의 횟수를 저장하는 해시맵
        
    public static String[] solution(String[] orders, int[] course) {
        ArrayList<String> result = new ArrayList<>();
        HashMap<Integer,Integer> max = new HashMap<>(); //각 코스메뉴의 최대 크기
        
        
        //메뉴의 조합 구하기
        for(int i=0;i<course.length;i++){
           for(int j=0;j<orders.length;j++){
               String[] order = orders[j].split("");
               int n = orders[j].length();
               boolean[] visited = new boolean[n];
               combination(order,visited,0,n,course[i]); //조합
           }
        }
        
        //각 메뉴갯수당 후보가 가능한 횟수, 즉 메뉴당 최댓값 구하기
        Iterator<String> keys = hash.keySet().iterator();
        while(keys.hasNext()){
            String key = keys.next();
            int menu_num = key.length();
            
            if(hash.get(key) < 2) //1번만 나왔으면
                continue;
            
            if(!max.containsKey(menu_num)) //해당 길이 주문이 처음일때
                max.put(menu_num,hash.get(key));
            else{ //이미 다른 주문이 존재시
                if(max.get(menu_num) < hash.get(key)) //이전의 주문 조합보다 횟수가 더많으면
                    max.put(menu_num,hash.get(key)); //바꿈
            }
        }
        
        //코스요리 메뉴 후보 출력
        keys = hash.keySet().iterator();
        while(keys.hasNext()){
            String key = keys.next();
            int menu_num = key.length(); //조합의 횟수
            if(hash.get(key) == max.get(menu_num)) //코스메뉴 후보면
                result.add(key);
        }
        
        Collections.sort(result); //정렬
        return result.toArray(new String[0]);
    }
    
    //조합
    //order[]는 문자, visited[]는 방문, start는 시작인덱스, nCr에서 n개중에 r개의 조합
    public static void combination(String[] order, boolean[] visited, int start, int n, int r){
        if(r == 0){
            String key = "";
            for(int i=0;i<n;i++){ //조합 결과
                if(visited[i]){
                    key += order[i];
                }
            }
            
            //정렬
            char[] temp = key.toCharArray();
            Arrays.sort(temp);
            key = new String(temp);
            
            //존재하지 않으면 1
            if(!hash.containsKey(key))
                hash.put(key,1);
            else //존재하면 +1
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
		
		hash = new HashMap<>(); //static은 초기화
		String[] orders2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		int[] course2 = {2,3,5};
		String[] results2 = solution(orders2, course2);
		for(String result2 : results2)
			System.out.print(result2 + " ");
		System.out.println();
		
		hash = new HashMap<>(); //static은 초기화
		String[] orders3 = {"XYZ", "XWY", "WXA"};
		int[] course3 = {2,3,4};
		String[] results3 = solution(orders3, course3);
		for(String result3 : results3)
			System.out.print(result3 + " ");
		System.out.println();
	}

}
