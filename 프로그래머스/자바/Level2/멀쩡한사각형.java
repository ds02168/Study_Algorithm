package Algorithm;

public class 멀쩡한사각형 {
	public static long solution(int w, int h) {  
        if(w <= 1 || h <= 1) //높이가 1이하기억나 너비가 1이하인 경우 모든 사각형이 대각선에 포함
            return 0;
    
        long answer = 0;
        long prev = 0; //이전 y위치
        
        for(int x = 1;x <= w;x++){
            double y = (double)h * x / w; //x +1당 y의 위치(double형식의 정확도 문제로 h부터)      
            long temp = (long)Math.ceil(y) - prev; //y칸으로 몇칸 이동했는지
            answer += temp; //더하고
            prev = (long)Math.floor(y); //다음 x위해 내림함
        }
        
        return (long)w * h - answer; //대각선 제외 사각형
    }
	
	public static void main(String[] args) {	
		System.out.println(solution(8,12));
	}

}
