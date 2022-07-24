package sortingExample;

import java.util.Arrays;

public class InsertionSort {
    public static int[] insertionSort(int[] arr) {
        // TODO:

        for(int i = 1; i< arr.length; i++){
            //현재 이동할 원소
            int now = arr[i];
            //한칸 앞부터
            int j = i - 1;
            //0까지 앞의 원소들이 클 동안
            while(j >= 0 && arr[j] > now){
                //앞의 원소들을 한칸뒤로 미룸
                arr[j+1] = arr[j];
                j--;
            }
            //해당 원소는 현재 원소 삽입
            arr[j+1] = now;
        }
        //배열 반환
        return arr;
    }

    public static void main(String[] args) {
        int[] output = insertionSort(new int[]{3, 1, 21});
        System.out.println(Arrays.toString(output)); // --> [1, 3, 21]
    }
}
