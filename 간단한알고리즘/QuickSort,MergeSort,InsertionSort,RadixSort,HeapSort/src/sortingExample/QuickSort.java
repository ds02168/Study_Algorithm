package sortingExample;

import java.util.Arrays;

public class QuickSort {
    public static int[] quickSort(int[] arr) {
        // TODO:
        quickSort(arr,0,arr.length-1); //퀵정렬
        return arr; //정렬된 배열
    }
    public static void quickSort(int[]arr, int start, int end){
        int part2 = partition(arr,start,end); //bigger의 첫번째 인덱스 값
        if(start < part2 - 1) //smaller가 2개 이상
            quickSort(arr,start,part2-1);
        if(part2 < end) //bigger가 2개이상
            quickSort(arr,part2,end);
    }
    //정렬
    public static int partition(int[] arr, int start, int end){
        int pivot = arr[(start+end)/2]; //중간 값
        //start:맨앞부터 1칸씩 뒤로, end:맨뒤부터 1칸씩 앞으로
        while(start <= end){ //start가 end보다 작을 동안
            while(arr[start] < pivot) start++; //작은값 pass
            while(arr[end] > pivot) end--; //큰값 pass
            if(start <= end){ //아직 교차x
                //swap
                swap(arr,start,end);
                //한칸씩
                start++;
                end--;
            }
        }
        return start; //bigger의 첫번째 인덱스
    }

    private static void swap(int[] arr, int start, int end){
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }
    public static void main(String[] args) {
        int[] output = quickSort(new int[]{3, 1, 21});
        System.out.println(Arrays.toString(output)); // --> [1, 3, 21]
    }
}
