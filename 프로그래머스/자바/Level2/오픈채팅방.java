package Algorithm;
import java.util.*;

public class ����ä�ù� {
	public static String[] solution(String[] record) {
		HashMap<String,String> hash = new HashMap<>(); //����ID, �г������� �ؽø� ����
        ArrayList<String> answer = new ArrayList<>(); //��� ����
        
        for(String s : record){ //�� ��Ǵ� �г��� ������ ����
            String[] temp = s.split(" ");
            switch(temp[0]){
                case "Enter":
                case "Change": //����, ����
                    hash.put(temp[1],temp[2]); //id, �г��� ����
                    break;
            }
        }
        
        //��� �迭 �ؽ÷� id->�г���
        for(String s: record){
            String[] temp = s.split(" ");
            StringBuilder sb = new StringBuilder();
            String id = temp[1]; //ID
            sb.append(hash.get(id) + "���� "); //�г���
            
            switch(temp[0]){
                case "Enter": //����
                    sb.append("���Խ��ϴ�.");
                    answer.add(sb.toString());
                    break;
                case "Leave": //����
                    sb.append("�������ϴ�.");
                    answer.add(sb.toString());
                    break;
            }
        }
        
        return answer.toArray(new String[answer.size()]); //������
	}

	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String [] results = solution(record);
		
		for(String result : results) {
			System.out.println(result);
		}
	}

}
