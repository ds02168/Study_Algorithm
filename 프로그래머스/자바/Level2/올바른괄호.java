package test;

public class ¿Ã¹Ù¸¥°ýÈ£ {
	static boolean solution(String s) {
        boolean answer = true;
        int count = 0;
        char[] list = s.toCharArray();
        
        for(char temp : list){
            if(temp == '(')
                count++;
            else{
                if((--count) < 0)
                    return false;
            }
        }
        
        if(count != 0)
            answer = false;
        
        return answer;
    }
	
	public static void main(String[] args) {
		String s = "()()";
		System.out.println(solution(s));
		
		s = "(())()";
		System.out.println(solution(s));
		
		s = ")()(";
		System.out.println(solution(s));
		
		s = "(()(";
		System.out.println(solution(s));
	}
}
