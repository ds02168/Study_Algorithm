class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        
        for(int i=0;i<arr.length;i++){
            answer = lcm(answer,arr[i]);
        }
        
        return answer;
    }
    
    
	public static int gcd(int a,int b){  //두 수를 입력 받음
        int temp; // 큰 수 교환용
        int r = 1; // 나머지 값
        if(b > a){ // a보다 b가 더크면 서로 교환
            temp = a;
            a = b;
            b = temp;
        }
        while(b!=0){ //b가 0일때까지
            r = a % b; //a와 b를 나눈 나머지를 r에
            a = b; //a는 b의 값
            b = r;  //b는 r의 값
        }
        return a; //b기 0일때의 a가 최대공약수
    }
    

	public static int lcm(int a, int b){
        return a * b / gcd(a,b); //두 수를 곱한 값에서 gcd를 나눈다.
    }
}
