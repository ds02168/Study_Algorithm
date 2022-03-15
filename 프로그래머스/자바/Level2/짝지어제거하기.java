package Algorithm;
import java.util.*;

public class ¦���������ϱ� {

	public static int solution(String s)
    {
		int answer = 0;
        Stack<String> stack = new Stack<>();
        String[] arr = s.split("");
        
        for(String top : arr){
            if(!stack.isEmpty() && stack.peek().equals(top)) //2���� �پ� �ִ� ¦
                stack.pop();
            else // �ٸ� ����
                stack.push(top);
        }
        
        if(stack.isEmpty()) //����ִٸ�, ��� ¦���� �� �ִٸ�
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
