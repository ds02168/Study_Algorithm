package test;

public class 가장큰정사각형찾기 {

	public static int solution(int [][]board)
    {
        int answer = 1;
        
        if(isAllZero(board)) return 0;
        
        for(int i=1;i<board.length;i++){
            for(int j=1;j<board[i].length;j++){
                if(board[i][j] == 0) continue;
                board[i][j] = Math.min(Math.min(board[i][j-1],board[i-1][j]),board[i-1][j-1]) + 1;
                answer = Math.max(answer,board[i][j]);
            }
        }

        return answer * answer;
    }
    
    private static boolean isAllZero(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
		System.out.println(solution(board));
		
		int[][] board2 = {{0,0,1,1},{1,1,1,1}};
		System.out.println(solution(board2));
		
	}

}
