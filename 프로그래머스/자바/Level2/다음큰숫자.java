package test;

public class 다음큰숫자 {

	public static int solution(int n) {
        String bin = Integer.toBinaryString(n);
        int count = countOne(bin);
        
        for(int i=n+1;;i++){ //다음수 부터
            String temp = Integer.toBinaryString(i);
            int next = countOne(temp); //현재 수의 1의 개수 구하기
            
            if(count == next) //1의 개수가 같으면
                return i; //다음 수
        }
    }
    
    
    //1의 갯수 구하는 함수
    public static int countOne(String bin){
        int count = 0;
        char[] array = bin.toCharArray();
        
        for(char temp:array){
            if(temp == '1')
                count++;
        }
        
        return count;
    }
    
	public static void main(String[] args) {
		int n = 78;
		System.out.println(solution(n));
		
		n = 15;
		System.out.println(solution(n));
	}

}
