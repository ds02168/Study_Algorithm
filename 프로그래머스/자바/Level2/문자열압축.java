package Algorithm;

public class 문자열압축 {

	public static int solution(String s) {
int answer = s.length(); //1단위 일때 최소
        
        //i=길이, j=시작위치
        for(int i=1;i<s.length()/2+1;i++){
            String prev = s.substring(0,i); //시작 문자 묶음
            int count = 1; //연속되는 갯수
            String temp = ""; //버퍼
            String last = ""; //마지막은 따로(묶음 갯수와 남은 문자갯수는 다를수 있음)
        
            for(int j=i; j<s.length(); j+= i){
                if(j+i>s.length()){
                    last = s.substring(j);//남은 문자열이 i보다 작은경우
                    continue;
                }
                if(prev.equals(s.substring(j,j+i))) //연속
                    count++; //갯수 증가
                else{
                    temp += prev; //길이만 맞추자! 꼭 압축 형식 맞출 필요 없는 문제!
                    if(count > 1){ //연속
                        temp = count + temp; //숫자 추가
                    }
                    prev = s.substring(j,j+i);
                    count = 1;
                }
            }
            temp += prev + last; //마지막 나머지
            if(count > 1)
                temp = count + temp;
            
            //최소 길이 비교
            if(answer > temp.length())
                answer = temp.length();
        }
        
        return answer;
    }
	public static void main(String[] args) {
		String s = "aabbaccc";
		int result = solution(s);		
		System.out.println("result : " + result);
		
		s = "ababcdcdababcdcd";
		result = solution(s);		
		System.out.println("result : " + result);
		
		s = "abcabcdede";
		result = solution(s);		
		System.out.println("result : " + result);
		
		s = "abcabcabcabcdededededede";
		result = solution(s);		
		System.out.println("result : " + result);
		
		s = "xababcdcdababcdcd";
		result = solution(s);		
		System.out.println("result : " + result);
	}

}
