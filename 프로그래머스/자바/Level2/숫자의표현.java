package test;

public class ������ǥ�� {

	public static int solution(int n) {
        int answer = 0;

        for(int i=1;i<=n;i++){
            int inum=i; //���� �ʱ�ȭ
            int add =0; //�� �ʱ�ȭ
            while (true){
                add+=inum; //�տ� �ݿ�

                if(add==n){ //n�� ��ġ
                    answer++; //���� +1
                    break;
                }else if(add>n){ //�� Ŀ���� ���� ����
                    break;
                }
                inum++; //���� �ڿ���
            }
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int n = 15;
		System.out.println(solution(n));
	}
}
