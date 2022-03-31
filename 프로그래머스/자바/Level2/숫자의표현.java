package test;

public class 숫자의표현 {

	public static int solution(int n) {
        int answer = 0;

        for(int i=1;i<=n;i++){
            int inum=i; //기준 초기화
            int add =0; //합 초기화
            while (true){
                add+=inum; //합에 반영

                if(add==n){ //n과 일치
                    answer++; //갯수 +1
                    break;
                }else if(add>n){ //더 커지면 다음 기준
                    break;
                }
                inum++; //다음 자연수
            }
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int n = 15;
		System.out.println(solution(n));
	}
}
