import java.util.Arrays; //배열 패키지

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        int counter = A.length;
        
        Arrays.sort(A); //정렬
        Arrays.sort(B); //정렬
        
        
        //두수의 곱이 최소가 되려면 최대와 최소를 곱해야 함
        for(int i=0;i<counter;i++){
            answer += (A[i] * B[counter-i-1]); //counter-1은 마지막 요소index가 길이-1이므로
        }
        return answer;
    }
}
