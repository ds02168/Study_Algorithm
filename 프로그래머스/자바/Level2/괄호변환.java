package Algorithm;

public class ��ȣ��ȯ {
public static final int BALANCE = 0; //0�� +��-�� �߰��̹Ƿ� '('�� ')'������ �����Ҷ��� ��
    
    public static String solution(String p) {
        String answer = "";
        answer = bracket(p);
        return answer;
    }
    
    //��ȣ �����
    public static String bracket(String u){
        int bal = BALANCE;
        String v = "";
        int index;
        
        if (u.equals(""))
            return u;
        
        //�������� ��ȣ ���ڿ� ã��, uã��
        for(index = 0;index<u.length();index++){
        	char c = u.charAt(index);
        	
            //����'('�� +1, ')'�� -1, ����� '('�� ����, ������ ')'�� ����
            switch(c){
                case '(':
                    bal++;
                    break;
                case ')':
                    bal--;
                    break;
            }
            
            if(bal == BALANCE) //+1�� -1���� �� '('�� ')'������ ����
                break;
        }
        
        v = u.substring(index+1); //�� ���ڿ�
        u = u.substring(0,index+1); //���� ���ڿ�
        
        //'('�� �����ϸ� �ùٸ�, ')'�� �����ϸ� ����, ���ڿ��� ������ �������� ����
        if(u.charAt(0) == '(')
            return u + bracket(v); //3-1
        else{        	
        	
        	u = u.substring(1,u.length()-1); //4-4 	
            u = u.replaceAll("\\(","��");
            u = u.replaceAll("\\)","��"); //�ٲٱ����� ġȯ                    
            u = u.replaceAll("��",")");
            u = u.replaceAll("��","("); //( �� )ġȯ
            
            return "(" + bracket(v) + ")" + u; //4-1, 4-2, 4-3, 4-5
        }
    }
    
	public static void main(String[] args) {
		String p = "(()())()";
		System.out.println(solution(p));
		p = ")(";
		System.out.println(solution(p));
		p = "()))((()";
		System.out.println(solution(p));
	}

}
