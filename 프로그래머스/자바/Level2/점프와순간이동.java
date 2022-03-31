package test;

public class 점프와순간이동 {

	public static int solution(int n) {
        int ans = 0;
        
        for(int i = n; i > 0; i=i/2)
            if((i%2)==1) //순간이동 후 나머지
                ans++; //점프
        
        return ans;
    }
	
	public static void main(String[] args) {
		int n = 5;
		System.out.println(solution(n));
		
		n = 6;
		System.out.println(solution(n));
		
		n = 5000;
		System.out.println(solution(n));
	}

}
