package test;

public class ����ū���� {

	public static int solution(int n) {
        String bin = Integer.toBinaryString(n);
        int count = countOne(bin);
        
        for(int i=n+1;;i++){ //������ ����
            String temp = Integer.toBinaryString(i);
            int next = countOne(temp); //���� ���� 1�� ���� ���ϱ�
            
            if(count == next) //1�� ������ ������
                return i; //���� ��
        }
    }
    
    
    //1�� ���� ���ϴ� �Լ�
    public static int countOne(String bin){
        int count = 0;
        char[] array = bin.toCharArray();
        
        for(char temp:array){
            if(temp == '1')
                count++;
        }
        
        return count;
    }
    
	public static void main(String[] args) {
		int n = 78;
		System.out.println(solution(n));
		
		n = 15;
		System.out.println(solution(n));
	}

}
