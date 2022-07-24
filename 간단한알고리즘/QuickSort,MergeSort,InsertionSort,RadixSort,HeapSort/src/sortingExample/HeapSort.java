package sortingExample;

import java.util.Arrays;

public class HeapSort {
    public static int[] heapSort(int[] arr){
        //힙 삽입
        heap_insert(arr);
        //힙 삭제(정렬)
        heap_delete(arr);

        return arr;
    }

    private static void heap_insert(int[] arr){
        //결과 배열 (0번째는 안쓰므로 +1)
        int[] temp = new int[arr.length+1];
        //삽입할 위치, 0번 째는 안씀
        int index = 1;

        //요소 하나씩 삽입
        for(int num: arr){
            //마지막 노드에 삽입
            temp[index] = num;
            //부모노드와 비교
            int parent = index / 2;
            int child = index;
            //부모 노드가 0보다 클때 까지
            while(parent > 0){
                //부모노드가 더 작다면 멈춤
                if(temp[parent] <= temp[child]) break;

                //부모와 자식을 바꿈
                int swap = temp[parent];
                temp[parent] = temp[child];
                temp[child] = swap;

                //부모와 자식은 다음 위치로
                child = parent;
                parent = parent / 2;
            }
            index++;
        }
        System.arraycopy(temp,1,arr,0,arr.length);
    }

    private static void heap_delete(int[] arr){
        //temp배열에 arr 복사, 0번째 인덱스는 사용 x
        int[] temp = new int[arr.length + 1];
        System.arraycopy(arr,0,temp,1,arr.length);
        //요소를 삭제할 위치
        int index = temp.length-1;
        for(int i = 0; i< arr.length;i++){
            //root의 요소 제거(최소값)
            arr[i] = temp[1];
            //마지막 노드를 루트로 이동
            temp[1] = temp[index];
            //이동할 위치
            int parent = 1;
            int child = 2;
            //child가 마지막 노드까지
            while(child <= index){
                //우측 자식 노드가 더 작으면 우측 자식 노드와 비교
                if(child < index && temp[child] > temp[child+1]) child++;
                //부모 노드가 자식노드보다 작거나 같으면 그만 비교
                if(temp[parent] <= temp[child]) break;

                //자식 노드와 부모노드 값 swap
                int swap = temp[parent];
                temp[parent] = temp[child];
                temp[child] = swap;

                //부모노드와 자식노드 위치 아래로
                parent = child;
                child = child * 2;
            }
            //마지막 노드 한칸 앞으로
            index--;
        }

    }
    public static void main(String[] args) {
        int[] output = heapSort(new int[]{5, 4, 3, 2, 1});
        System.out.println(Arrays.toString(output)); // --> [1, 2, 3, 4, 5]

        output = heapSort(new int[]{3, 1, 21});
        System.out.println(Arrays.toString(output)); // --> [1, 3, 21]

        output = heapSort(new int[]{4, 10, 3, 5, 1});
        System.out.println(Arrays.toString(output)); // --> [1, 3, 4, 5, 10]
    }
}
