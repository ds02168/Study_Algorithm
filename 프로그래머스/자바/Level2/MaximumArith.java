package Algorithm;

import java.util.ArrayList;

public class MaximumArith {
	public static ArrayList<Long> operand = new ArrayList<>();
    public static ArrayList<String> operator = new ArrayList<>();
    public static long answer = Long.MIN_VALUE;
    
    public static String[] oper = {"+","-","*"}; //������ ���
    public static String[] priority = new String[3]; //�켱���� ����
    public static boolean[] visited = new boolean[3]; //����Ȯ�ο�
    
	public static void main(String[] args) {
		String expression = "50*6-3*2";
        int index=0;
        
        //�ǿ�����, ������ �迭 �����
        for(int i=0;i<expression.length();i++){
            if(expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*'){
                operand.add(Long.parseLong(expression.substring(index,i)));
                index = i + 1;
                operator.add(expression.substring(i,index));
            }
        }
        operand.add(Long.parseLong(expression.substring(index,expression.length())));
        
        permutation(0,oper.length); //����
        
        System.out.println(answer);
	}
	
	//����
	static void permutation(int depth,int r) {
		if(depth == r) {
			getMax(); //�켱������ �°� ���
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
	
	
	//������ �켱���� ���� ��� ����
	public static void getMax() {
        long result=0;
        int index;
        ArrayList<Long> temp_operand = new ArrayList<Long>();
        temp_operand.addAll(operand); //�ǿ����� �ҷ�����
        ArrayList<String> temp_operator = new ArrayList<String>();
        temp_operator.addAll(operator); //������ �ҷ�����
        
        for(int i=0;i<priority.length;i++){ //������ ����
        	String opt = priority[i]; //������ �ҷ�����
            
            for(index=0;index<temp_operator.size();index++){ //������ �ϳ��ϳ��� ��
                
                if(temp_operator.get(index).equals(opt)){ //���� �켱���� �����ڸ�
                    long num1 = temp_operand.get(index);
                    long num2 = temp_operand.get(index+1); //�ǿ����� ��������
                    switch(opt){ //����
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
                    temp_operand.remove(index); //2���� �ǿ����ڴ� 1����
                    temp_operator.remove(index); //1���� �����ڴ� 0����
                    
                    index--; //����� �ε��� ����
                }
            }
            
           
        }
        if(answer < Math.abs(temp_operand.get(0))) //�ִ񰪺��� ũ��
            answer = Math.abs(temp_operand.get(0)); //�ִ밪����
	}

}
