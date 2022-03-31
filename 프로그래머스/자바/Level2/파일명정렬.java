package test;

import java.util.*;

public class ���ϸ����� {

	public static String[] solution(String[] files) {
        String[] answer = {};
        
        //���ǿ� ���� ������ ���� Comparator
        //compare ���ϰ��� ����� �ڸ� �ٲٰ� 0�̸� ���ں�
        Arrays.sort(files, new Comparator<String>(){
            public int compare(String o1, String o2){
                //���� �պκ��� �߶� head ����
                String head1 = o1.split("[0-9]")[0];
                String head2 = o2.split("[0-9]")[0];
                
                //compareTo�� ����� �񱳸� ���ؼ��� ��� �ҹ��ڷ� ���� �� ��
                int result = head1.toLowerCase().compareTo(head2.toLowerCase());
                
                if(result == 0){ //���� ������ ��� ���ڷ� ��
                    result = convertNum(o1,head1) - convertNum(o2,head2);
                }
                
                return result;
            }
        });
        
        return files;
    }
    
    public static int convertNum(String str, String head){
        str = str.substring(head.length()); //head���� ��ŭ �߶� num����
        String result = "";
        for(char c: str.toCharArray()){
            if(Character.isDigit(c) && result.length() < 5) //�����̰� ���̰� 5�������� Ȯ��
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
