package Algorithm;

import java.util.ArrayList;

public class MaximumArith {
	public static ArrayList<Long> operand = new ArrayList<>();
    public static ArrayList<String> operator = new ArrayList<>();
    public static long answer = Long.MIN_VALUE;
    
    public static String[] oper = {"+","-","*"}; //연산자 목록
    public static String[] priority = new String[3]; //우선순위 순열
    public static boolean[] visited = new boolean[3]; //여부확인용
    
	public static void main(String[] args) {
		String expression = "50*6-3*2";
        int index=0;
        
        //피연산자, 연산자 배열 만들기
        for(int i=0;i<expression.length();i++){
            if(expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*'){
                operand.add(Long.parseLong(expression.substring(index,i)));
                index = i + 1;
                operator.add(expression.substring(i,index));
            }
        }
        operand.add(Long.parseLong(expression.substring(index,expression.length())));
        
        permutation(0,oper.length); //순열
        
        System.out.println(answer);
	}
	
	//순열
	static void permutation(int depth,int r) {
		if(depth == r) {
			getMax(); //우선순위에 맞게 계싼
			return;
		}
		for(int i=0;i<oper.length;i++) {
			if(!visited[i]) {
				visited[i] = true;
				priority[depth] = oper[i];
				permutation(depth+1,r);
				visited[i] = false;
			}
		}
	}
	
	
	//연산자 우선순위 별로 결과 구함
	public static void getMax() {
        long result=0;
        int index;
        ArrayList<Long> temp_operand = new ArrayList<Long>();
        temp_operand.addAll(operand); //피연산자 불러오기
        ArrayList<String> temp_operator = new ArrayList<String>();
        temp_operator.addAll(operator); //연산자 불러오기
        
        for(int i=0;i<priority.length;i++){ //연산자 별로
        	String opt = priority[i]; //연산자 불러오기
            
            for(index=0;index<temp_operator.size();index++){ //연산자 하나하나씩 비교
                
                if(temp_operator.get(index).equals(opt)){ //현재 우선순위 연산자면
                    long num1 = temp_operand.get(index);
                    long num2 = temp_operand.get(index+1); //피연산자 가져오기
                    switch(opt){ //연산
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "*":
                            result = num1 * num2;
                            break;
                    }
                    temp_operand.set(index+1,result);
                    temp_operand.remove(index); //2개의 피연산자는 1개로
                    temp_operator.remove(index); //1개의 연산자는 0개로
                    
                    index--; //계산후 인덱스 조정
                }
            }
            
           
        }
        if(answer < Math.abs(temp_operand.get(0))) //최댓값보다 크면
            answer = Math.abs(temp_operand.get(0)); //최대값으로
	}

}
