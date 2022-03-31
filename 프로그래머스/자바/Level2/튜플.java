package test;

import java.util.*;

public class 튜플 {

	public static int[] solution(String s) {
        String[] arr = s.split("},"); //문자열 내에 배열 구분
        String temp="";
        String[] temps;
        int[][] answers = new int[arr.length][]; //문자열을 치환한 배열 저장(가변)
        HashMap<Integer,Integer> hash = new HashMap<>(); //나온 횟수 저장

        
        //배열로 치환
        for(int i=0;i<arr.length;i++) {
            temp = arr[i].replaceAll("[{|}]",""); //대괄호 제거
            temps = temp.split(","); //콤마 제거
            
            answers[i] = new int[temps.length]; //2차원 가변 배열
            
            for(int j=0;j<temps.length;j++) {
                answers[i][j] = Integer.parseInt(temps[j]); //인트로 변환후 저장
            }
        }
        
        //해시맵에 나온 횟수 저장
        for(int i=0;i<answers.length;i++) {
        	for(int j=0;j<answers[i].length;j++) {
        		if(!hash.containsKey(answers[i][j])) //처음
        			hash.put(answers[i][j], 1); //1
        		else //이미 있음
        			hash.put(answers[i][j], hash.get(answers[i][j])+1); //+1
        	}
        }
        
        //내림차순 정렬
        List<Integer> KeySetList = new ArrayList<>(hash.keySet());
        Collections.sort(KeySetList, new Comparator<Integer>() { //Comparator 인터페이스
        	public int compare(Integer o1, Integer o2) {
        		return hash.get(o2).compareTo(hash.get(o1)); //내림차순
        	}
        });
        
        //배열 저장
        int[] answer = new int[KeySetList.size()]; //배열 크기
        for(int i=0;i<KeySetList.size();i++) {
        	answer[i] = KeySetList.get(i); //요소 저장
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
