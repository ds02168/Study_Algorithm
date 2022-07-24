package sortingExample;

import java.util.Arrays;

public class RadixSort {
    public static int[] radixSort(int[] arr){
        //최댓값 구하기
        int max = Arrays.stream(arr).max().getAsInt();
        //자릿수 별로 countingSort
        for(int radix = 1; radix <= max; radix *= 10){
            arr = countingSort(arr,radix);
        }
        return arr;
    }

    private static int[] countingSort(int[] arr, int radix){
        //결과를 저장할 배열
        int[] result = new int[arr.length];
        //해당 자리수의 숫자를 저장할 배열
        int[] counting = new int[10];

        //숫자의 갯수를 구함
        for(int i = 0; i < arr.length; i++){
            int num = (arr[i] / radix) % 10;
            counting[num]++;
        }

        //숫자별 마지막 위치를 구함
        for(int i = 1; i < counting.length; i++)
            counting[i] += counting[i-1];

        //stable 하므로 이전에 정렬되었던 순서가 현재 졍렬에도 반영됨 -> 이전 자리수가 현재 자리수에도 반영이 됨
        for(int i = arr.length-1;i>=0;i--){
            int num = (arr[i]/radix) % 10; //현재 자리수
            counting[num]--; //해당 자리수의 위치 -1하면 들어갈 위치
            result[counting[num]] = arr[i]; //counting[num]은 해당 자릿수가 들어갈 위치가 저장되어있음
        }
        return result;
    }


    public static void main(String[] args) {
        int[] output = radixSort(new int[]{3, 1, 21});
        System.out.println(Arrays.toString(output)); // --> [1, 3, 21]
    }
}
