package sortingExample;

import java.util.Arrays;

public class MergeSort {
    public static int[] mergeSort(int[] arr) {
        // TODO :
        //mergeSort는 2단계로 이루어집니다.
        //재귀적으로 1/2로 나누고
        //그때마다 sorting을 합니다.

        //임시로 저장할 배열을 선언합니다ㅣ.
        int[] tmp = new int[arr.length];
        //재귀적으로 1/2로 나누고 sorting
        mergeSort(arr,tmp,0,arr.length-1);
        return arr;
    }

    private static void mergeSort(int[] arr, int[] tmp, int start, int end){
        //시작이 끝보다 작다면
        if(start < end){
            int mid = (start + end) / 2; //중간 인덱스구함
            mergeSort(arr,tmp,start,mid); //앞부분을 다시 재귀적으로
            mergeSort(arr,tmp,mid+1,end); //뒷부분을 다시 재귀적으로
            merge(arr,tmp,start,mid,end); //sorting
        }
    }

    private static void merge(int[] arr, int[] tmp, int start, int mid, int end){
        //arr -> tmp로 복사
        for(int i = 0; i < arr.length; i++){
            tmp[i] = arr[i];
        }
        //tmp 앞부분 or tmp 뒷부분 -> arr합한부분
        int part1 = start; //tmp 앞부분
        int part2 = mid + 1; //tmp 뒷부분
        int index = start; //arr 합한부분

        //part1과 part2가 남아있을 때 까지
        while(part1 <= mid && part2 <= end){
            if(tmp[part1] <= tmp[part2]){ //part1이 더 작을 경우
                arr[index] = tmp[part1]; //arr에 삽입
                part1++; //part1 한 칸 뒤로
            }else{ //part2가 더 작을 경우
                arr[index] = tmp[part2]; //arr에 삽입
                part2++; //part2 한 칸 뒤로
            }
            index++; //arr 한칸 뒤로
        }
        //part1이 남을 경우 나머지 부분 삽입
        for(int i = 0; i <= mid - part1; i++){
            arr[index + i] = tmp[part1 + i];
        }
        //part2가 남는 경우는 위에 arr의 뒷부분이 이미 part2의 뒷부분으로 정렬되어 있음
    }



    public static void main(String[] args) {
        int[] output = mergeSort(new int[]{3, 1, 21});
        System.out.println(Arrays.toString(output)); // --> [1, 3, 21]
    }
}
