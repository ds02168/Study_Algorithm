package Algorithm;

public class �����ѻ簢�� {
	public static long solution(int w, int h) {  
        if(w <= 1 || h <= 1) //���̰� 1���ϱ�ﳪ �ʺ� 1������ ��� ��� �簢���� �밢���� ����
            return 0;
    
        long answer = 0;
        long prev = 0; //���� y��ġ
        
        for(int x = 1;x <= w;x++){
            double y = (double)h * x / w; //x +1�� y�� ��ġ(double������ ��Ȯ�� ������ h����)      
            long temp = (long)Math.ceil(y) - prev; //yĭ���� ��ĭ �̵��ߴ���
            answer += temp; //���ϰ�
            prev = (long)Math.floor(y); //���� x���� ������
        }
        
        return (long)w * h - answer; //�밢�� ���� �簢��
    }
	
	public static void main(String[] args) {	
		System.out.println(solution(8,12));
	}

}
