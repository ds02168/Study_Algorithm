package test;

import java.util.*;

public class 주식가격 {

	public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i=0;i < prices.length;i++){
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {1, 2, 3, 2, 3};
		System.out.println(Arrays.toString(solution(prices)));
	}

}
