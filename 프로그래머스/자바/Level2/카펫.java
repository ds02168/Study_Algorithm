package test;

import java.util.Arrays;

public class Ä«Æê {

	public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int width=0;
        int height=0;
        
        for(int i=1;i<=yellow;i++){
            if(yellow % i != 0)
                continue;
            else{
                height = i;
                width = yellow / i;
            }
            
            if((2 * height) + (2 * width) + 4 == brown)
                break;
        }
        
        answer[0] = width+2;
        answer[1] = height+2;
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int brown = 10;
		int yellow = 2;
		System.out.println(Arrays.toString(solution(brown,yellow)));
		
		brown = 8;
		yellow = 1;
		System.out.println(Arrays.toString(solution(brown,yellow)));
		
		brown = 24;
		yellow = 24;
		System.out.println(Arrays.toString(solution(brown,yellow)));
	}

}
