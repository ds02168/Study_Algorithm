package test;

import java.util.*;

public class 파일명정렬 {

	public static String[] solution(String[] files) {
        String[] answer = {};
        
        //조건에 따른 정렬을 위해 Comparator
        //compare 리턴값이 양수면 자리 바꾸고 0이면 숫자비교
        Arrays.sort(files, new Comparator<String>(){
            public int compare(String o1, String o2){
                //숫자 앞부분을 잘라서 head 생성
                String head1 = o1.split("[0-9]")[0];
                String head2 = o2.split("[0-9]")[0];
                
                //compareTo를 사용한 비교를 위해서는 모두 소문자로 변경 후 비교
                int result = head1.toLowerCase().compareTo(head2.toLowerCase());
                
                if(result == 0){ //같은 문자일 경우 숫자로 비교
                    result = convertNum(o1,head1) - convertNum(o2,head2);
                }
                
                return result;
            }
        });
        
        return files;
    }
    
    public static int convertNum(String str, String head){
        str = str.substring(head.length()); //head길이 만큼 잘라서 num부터
        String result = "";
        for(char c: str.toCharArray()){
            if(Character.isDigit(c) && result.length() < 5) //숫자이고 길이가 5이하인지 확인
                result += c;
            else
                break;
        }
        
        return Integer.valueOf(result);
    }
	public static void main(String[] args) {
		String[] file = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		System.out.println(Arrays.toString(solution(file)));
		
		String[] file2 = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
		System.out.println(Arrays.toString(solution(file2)));

	}

}
