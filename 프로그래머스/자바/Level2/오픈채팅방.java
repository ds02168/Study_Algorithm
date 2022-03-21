package Algorithm;
import java.util.*;

public class 오픈채팅방 {
	public static String[] solution(String[] record) {
		HashMap<String,String> hash = new HashMap<>(); //유저ID, 닉네임으로 해시맵 구성
        ArrayList<String> answer = new ArrayList<>(); //결과 저장
        
        for(String s : record){ //한 사건당 닉네임 구분을 위해
            String[] temp = s.split(" ");
            switch(temp[0]){
                case "Enter":
                case "Change": //입장, 변경
                    hash.put(temp[1],temp[2]); //id, 닉네임 저장
                    break;
            }
        }
        
        //출력 배열 해시로 id->닉네임
        for(String s: record){
            String[] temp = s.split(" ");
            StringBuilder sb = new StringBuilder();
            String id = temp[1]; //ID
            sb.append(hash.get(id) + "님이 "); //닉네임
            
            switch(temp[0]){
                case "Enter": //입장
                    sb.append("들어왔습니다.");
                    answer.add(sb.toString());
                    break;
                case "Leave": //퇴장
                    sb.append("나갔습니다.");
                    answer.add(sb.toString());
                    break;
            }
        }
        
        return answer.toArray(new String[answer.size()]); //결과출력
	}

	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String [] results = solution(record);
		
		for(String result : results) {
			System.out.println(result);
		}
	}

}
