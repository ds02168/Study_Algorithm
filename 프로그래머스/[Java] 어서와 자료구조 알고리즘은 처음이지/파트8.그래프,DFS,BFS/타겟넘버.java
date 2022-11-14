package section8;

public class 타겟넘버 {
    public static int solution(int[] numbers, int target) {
        return sumCount(numbers,target,0,0); //재귀 시작
    }

    //재귀 함수
    static int sumCount(final int[] numbers, final int target, int index, int sum){
        //종료 조건
        if(index == numbers.length){
            if(sum == target) return 1; //target이면 + 1추가
            return 0; //아니면 추가 안함
        }

        //더하는 경우
        //빼는 경우
        //target인 숫자의 갯수를 더함
        return sumCount(numbers, target, index + 1, sum + numbers[index]) +
                sumCount(numbers, target, index + 1, sum - numbers[index]);
    }

    public static void main(String[] args) {
        int[] numbers1 = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution(numbers1,target));

        int[] numbers2 = {4, 1, 2, 1};
        target = 4;
        System.out.println(solution(numbers2,target));

    }
}
