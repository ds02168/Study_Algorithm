package Algorithm;
import java.util.*;

public class NewsClustering {

	public static int solution(String str1, String str2) {
        double answer = 0;
        int inters = 0; //교집합 수
        int unions =0; //합집합 수
        HashMap<String,Integer> arr1 = new HashMap<>(); //str1의 원소와 횟수
        HashMap<String,Integer> arr2 = new HashMap<>(); //str2의 원소와 횟수
        HashMap<String,Integer> inter = new HashMap<>(); //교집합의 원소와 횟수
        HashMap<String,Integer> union = new HashMap<>(); //합집합의 원소와 횟수
        
        //str1의 원소와 횟수
        for(int i=1;i<str1.length();i++){
            if(Character.isLetter(str1.charAt(i-1)) && Character.isLetter(str1.charAt(i))){
                String key = str1.substring(i-1,i+1).toUpperCase(); //모두 대문자로
                if(!arr1.containsKey(key))
                    arr1.put(key,1);
                else
                    arr1.put(key,arr1.get(key)+1);
            }
        }
        //str2의 원소와 횟수
        for(int i=1;i<str2.length();i++){
            if(Character.isLetter(str2.charAt(i-1)) && Character.isLetter(str2.charAt(i))){
                String key = str2.substring(i-1,i+1).toUpperCase(); //모두 대문자로
                if(!arr2.containsKey(key))
                    arr2.put(key,1);
                else
                    arr2.put(key,arr2.get(key)+1);
            }
        }        
        
        //교집합의 원소와 횟수
        Iterator<String> keys = arr1.keySet().iterator();
        while(keys.hasNext()){
            String key = keys.next();
            int value = 0; //안나오면 0
            if(arr2.containsKey(key)) //str2에도 있다면
                value = arr2.get(key); //나온 횟수 저장
            int intersection = Math.min(arr1.get(key),value); //str1과 str2중 적게 나온 횟수 저장
            if(intersection > 0) //둘다 존재한다면
                inter.put(key,intersection); //최솟값 저장
        }
        
        //합집합의 원소와 횟수
        keys = arr1.keySet().iterator();
        while(keys.hasNext()){ //str1 모두 저장
            String key = keys.next();
            union.put(key,arr1.get(key));
        }
        keys = arr2.keySet().iterator();
        while(keys.hasNext()){
            String key = keys.next();
            int value = arr2.get(key);
            if(union.containsKey(key)){ //str1에도 존재
                if(value > union.get(key)) //횟수가 더많으면
                    union.put(key,value); //바꿈
            }else{ //str1에 없고 str2에만 존재
                union.put(key,value);
            }
        }
        
        //교집합의 수
        keys = inter.keySet().iterator();
        while(keys.hasNext()){
            String key = keys.next();
            inters += inter.get(key);
        }
        //합집합의 수
        keys = union.keySet().iterator();
        while(keys.hasNext()){
            String key = keys.next();
            unions += union.get(key);
        }
        
        //자카드 유사도
        if(unions == 0)
            answer = 1;
        else{
            answer = (double)inters / (double)unions;
        }        
        answer *= 65536;   
        
        return (int)answer;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "FRANCE";
		String str2 = "french";
		System.out.println(solution(str1,str2));
		str1 = "handshake";
		str2 = "shake hands	";
		System.out.println(solution(str1,str2));
		str1 = "aa1+aa2	";
		str2 = "AAAA12";
		System.out.println(solution(str1,str2));
		str1 = "E=M*C^2	";
		str2 = "e=m*c^2	";
		System.out.println(solution(str1,str2));
	}
}
