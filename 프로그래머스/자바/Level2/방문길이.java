package test;

import java.util.*;

public class 방문길이 {
	
	public static int solution(String dirs) {
        HashSet<String> s = new HashSet<String>();
        
        int nowX=0;
        int nowY=0;
        int nextX;
        int nextY;
        
        for(int i=0;i<dirs.length();i++){
            nextX=nowX;
            nextY=nowY;
            String road="";
            
            switch(dirs.charAt(i)){
                case 'U':
                    nextY++;
                    road += nowX;
                    road += nowY;
                    road += nextX;
                    road += nextY;
                    break;
                case 'D':
                    nextY--;
                    road += nextX;
                    road += nextY;
                    road += nowX;
                    road += nowY;
                    break;
                case 'R':
                    nextX++;
                    road += nowX;
                    road += nowY;
                    road += nextX;
                    road += nextY;
                    break;
                case 'L':
                    nextX--;
                    road += nextX;
                    road += nextY;
                    road += nowX;
                    road += nowY;
                    break;
                default:
                    
            }
            
            if(nextX > 5 || nextX < -5 || nextY > 5 || nextY < -5)
                continue;
            
            s.add(road);
            nowX=nextX;
            nowY=nextY;
        }
        
        return s.size();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dirs = "ULURRDLLU";
		System.out.println(solution(dirs));
		
		dirs = "LULLLLLLU";
		System.out.println(solution(dirs));
	}
}
