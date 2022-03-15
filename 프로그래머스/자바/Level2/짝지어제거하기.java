package Algorithm;
import java.util.*;

public class 짝지어제거하기 {

	public static int solution(String s)
    {
		int answer = 0;
        Stack<String> stack = new Stack<>();
        String[] arr = s.split("");
        
        for(String top : arr){
            if(!stack.isEmpty() && stack.peek().equals(top)) //2개가 붙어 있는 짝
                stack.pop();
            else // 다른 문자
                stack.push(top);
        }
        
        if(stack.isEmpty()) //비어있다면, 모두 짝지을 수 있다면
            answer = 1;
        
        return answer;
    }
	
	public static void main(String[] args) {
		String s = "baabaa";
		System.out.println(solution(s));
		
		s = "cdcd";
		System.out.println(solution(s));
	}

}
