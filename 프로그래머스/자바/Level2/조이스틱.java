package test;

public class ¡∂¿ÃΩ∫∆Ω {

	public static int solution(String name) {
        int answer = 0;
        int length = name.length();
        
        int index;
        int move = length - 1;
        
        for(int i=0;i<length;i++){
            answer += Math.min(name.charAt(i) - 'A','Z'-name.charAt(i) + 1);
            
            index = i + 1;
            while(index < length && name.charAt(index) == 'A')
                index++;
            
            move = Math.min(move,i * 2 + length-index);
            move = Math.min(move,(length-index)* 2 + i);
        }
        return answer + move;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "JEROEN";
		System.out.println(solution(name));
		
		name = "JAN";
		System.out.println(solution(name));
	}

}
