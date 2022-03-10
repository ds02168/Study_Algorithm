package Algorithm;

public class 괄호변환 {
public static final int BALANCE = 0; //0은 +와-의 중간이므로 '('와 ')'갯수가 동일할때의 값
    
    public static String solution(String p) {
        String answer = "";
        answer = bracket(p);
        return answer;
    }
    
    //괄호 재귀적
    public static String bracket(String u){
        int bal = BALANCE;
        String v = "";
        int index;
        
        if (u.equals(""))
            return u;
        
        //균형잡힙 괄호 문자열 찾기, u찾기
        for(index = 0;index<u.length();index++){
        	char c = u.charAt(index);
        	
            //문자'('는 +1, ')'는 -1, 양수면 '('가 많고, 음수면 ')'가 많음
            switch(c){
                case '(':
                    bal++;
                    break;
                case ')':
                    bal--;
                    break;
            }
            
            if(bal == BALANCE) //+1과 -1갯수 즉 '('와 ')'갯수가 동일
                break;
        }
        
        v = u.substring(index+1); //뒷 문자열
        u = u.substring(0,index+1); //균형 문자열
        
        //'('로 시작하면 올바른, ')'로 시작하면 균형, 문자열은 무조건 균형임을 응용
        if(u.charAt(0) == '(')
            return u + bracket(v); //3-1
        else{        	
        	
        	u = u.substring(1,u.length()-1); //4-4 	
            u = u.replaceAll("\\(","열");
            u = u.replaceAll("\\)","닫"); //바꾸기위한 치환                    
            u = u.replaceAll("열",")");
            u = u.replaceAll("닫","("); //( 와 )치환
            
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
