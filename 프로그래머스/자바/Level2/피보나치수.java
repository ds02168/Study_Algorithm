class Solution {
    public int solution(int n) {
        int f0 = 0;
        int f1 = 1;
        int f2 = 1;
        
        if(n < 2) //0,1일땐 n값 리턴
            return n;
        
        for(int i=2;i<=n;i++){ //%1234567은 int와 long자료형으론 담아 낼 수 없다
            f2 = ((f0 % 1234567) + (f1 % 1234567)) % 1234567; //대신 더할때마다 %1234567하여 int자료형 내에서 나누어진다는걸
            f0 = f1 % 1234567; //보장
            f1 = f2 % 1234567;
        }
        
        return f2;
    }
}
