package Algorithm;

public class ���ڿ����� {

	public static int solution(String s) {
int answer = s.length(); //1���� �϶� �ּ�
        
        //i=����, j=������ġ
        for(int i=1;i<s.length()/2+1;i++){
            String prev = s.substring(0,i); //���� ���� ����
            int count = 1; //���ӵǴ� ����
            String temp = ""; //����
            String last = ""; //�������� ����(���� ������ ���� ���ڰ����� �ٸ��� ����)
        
            for(int j=i; j<s.length(); j+= i){
                if(j+i>s.length()){
                    last = s.substring(j);//���� ���ڿ��� i���� �������
                    continue;
                }
                if(prev.equals(s.substring(j,j+i))) //����
                    count++; //���� ����
                else{
                    temp += prev; //���̸� ������! �� ���� ���� ���� �ʿ� ���� ����!
                    if(count > 1){ //����
                        temp = count + temp; //���� �߰�
                    }
                    prev = s.substring(j,j+i);
                    count = 1;
                }
            }
            temp += prev + last; //������ ������
            if(count > 1)
                temp = count + temp;
            
            //�ּ� ���� ��
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
