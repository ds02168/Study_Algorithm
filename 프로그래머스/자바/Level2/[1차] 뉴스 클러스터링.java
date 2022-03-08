package Algorithm;
import java.util.*;

public class NewsClustering {

	public static int solution(String str1, String str2) {
        double answer = 0;
        int inters = 0; //������ ��
        int unions =0; //������ ��
        HashMap<String,Integer> arr1 = new HashMap<>(); //str1�� ���ҿ� Ƚ��
        HashMap<String,Integer> arr2 = new HashMap<>(); //str2�� ���ҿ� Ƚ��
        HashMap<String,Integer> inter = new HashMap<>(); //�������� ���ҿ� Ƚ��
        HashMap<String,Integer> union = new HashMap<>(); //�������� ���ҿ� Ƚ��
        
        //str1�� ���ҿ� Ƚ��
        for(int i=1;i<str1.length();i++){
            if(Character.isLetter(str1.charAt(i-1)) && Character.isLetter(str1.charAt(i))){
                String key = str1.substring(i-1,i+1).toUpperCase(); //��� �빮�ڷ�
                if(!arr1.containsKey(key))
                    arr1.put(key,1);
                else
                    arr1.put(key,arr1.get(key)+1);
            }
        }
        //str2�� ���ҿ� Ƚ��
        for(int i=1;i<str2.length();i++){
            if(Character.isLetter(str2.charAt(i-1)) && Character.isLetter(str2.charAt(i))){
                String key = str2.substring(i-1,i+1).toUpperCase(); //��� �빮�ڷ�
                if(!arr2.containsKey(key))
                    arr2.put(key,1);
                else
                    arr2.put(key,arr2.get(key)+1);
            }
        }        
        
        //�������� ���ҿ� Ƚ��
        Iterator<String> keys = arr1.keySet().iterator();
        while(keys.hasNext()){
            String key = keys.next();
            int value = 0; //�ȳ����� 0
            if(arr2.containsKey(key)) //str2���� �ִٸ�
                value = arr2.get(key); //���� Ƚ�� ����
            int intersection = Math.min(arr1.get(key),value); //str1�� str2�� ���� ���� Ƚ�� ����
            if(intersection > 0) //�Ѵ� �����Ѵٸ�
                inter.put(key,intersection); //�ּڰ� ����
        }
        
        //�������� ���ҿ� Ƚ��
        keys = arr1.keySet().iterator();
        while(keys.hasNext()){ //str1 ��� ����
            String key = keys.next();
            union.put(key,arr1.get(key));
        }
        keys = arr2.keySet().iterator();
        while(keys.hasNext()){
            String key = keys.next();
            int value = arr2.get(key);
            if(union.containsKey(key)){ //str1���� ����
                if(value > union.get(key)) //Ƚ���� ��������
                    union.put(key,value); //�ٲ�
            }else{ //str1�� ���� str2���� ����
                union.put(key,value);
            }
        }
        
        //�������� ��
        keys = inter.keySet().iterator();
        while(keys.hasNext()){
            String key = keys.next();
            inters += inter.get(key);
        }
        //�������� ��
        keys = union.keySet().iterator();
        while(keys.hasNext()){
            String key = keys.next();
            unions += union.get(key);
        }
        
        //��ī�� ���絵
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
