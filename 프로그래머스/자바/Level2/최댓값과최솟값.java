class Solution {
    public String solution(String s) {
        String[] temp = s.split(" ");
        int min, max, n;
        min = max = Integer.parseInt(temp[0]); //0번 인덱스로 초기화
        for(int i=0;i<temp.length;i++){ //1번 인덱스부터 순차적으로 최대와 최소 비교
            n = Integer.parseInt(temp[i]); //각 요소마다 확인
            
            if(min > n) min = n; //최소면 최소
            if(max < n) max = n; //최대면 최대
        }
        
        return min + " " + max;
    }
}
