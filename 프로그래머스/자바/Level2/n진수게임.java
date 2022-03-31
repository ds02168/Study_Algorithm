package test;

public class n진수게임 {

	public static String solution(int n, int t, int m, int p) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        for(int num=0; num<=t*m; num++){ //t*m개 만큼
            
            // n진수화
            StringBuilder tmp = convertNum(num,n);
            sb.append(tmp);
        }
        
        StringBuilder result = new StringBuilder();
        for(int i=0;i<sb.length();i++){
            if(result.length() >= t) break;
            
            if(((i+1)%m) == (p%m)){
                result.append(sb.charAt(i));
            }
        }
        
        answer = result.toString();
        return answer;
    }
    
    private static StringBuilder convertNum(int num, int n){
        StringBuilder sb = new StringBuilder();
        if(num==0)
            return sb.append(0);
        
        while(num != 0){
            int mod = num % n;
            if(mod >= 10){
                int idx = 'A' + (mod-10);
                sb.append((char)idx);
            }
            else
                sb.append(mod);
            num /= n;
        }
        
        //거꾸로 출력
        return sb.reverse();
    }
    
	public static void main(String[] args) {
		int n = 2;
		int t = 4;
		int m = 2;
		int p = 1;
		System.out.println(solution(n,t,m,p));
		
		n = 16;
		t = 16;
		m = 2;
		p = 1;
		System.out.println(solution(n,t,m,p));
		
		n = 16;
		t = 16;
		m = 2;
		p = 2;
		System.out.println(solution(n,t,m,p));
		
	}

}
