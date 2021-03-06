class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        int temp;
        
        for(int i=0;i<arr1.length;i++){ // 앞테이블의 행
            for(int j=0;j<arr2[0].length;j++){ //뒷 테이블의 열
                temp=0; //뒷 테이블의 열 마다
                for(int k=0;k<arr2.length;k++) //앞테이블의 열, 뒷 테이블의 행
                    temp += arr1[i][k] * arr2[k][j]; //각 요소의 곱을 합한다
                answer[i][j] = temp; //요소의 합 저장
                
            }
        }
        return answer;
    }
}
