package StackQueue스택큐;

import java.util.*;

public class 올바른괄호 {
    static boolean solution(String s){
        int stack = 0;
        for(char c : s.toCharArray()){
            if(c == '(') stack++;
            else{
                if(stack == 0) return false;
                stack--;
            }
        }
        return stack == 0;
    }
    public static void main(String[] args) {
        System.out.println(solution("()()"));
        System.out.println(solution("(())()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));
    }
}
