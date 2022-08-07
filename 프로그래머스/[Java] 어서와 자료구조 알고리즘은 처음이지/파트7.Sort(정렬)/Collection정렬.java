package SortingPractice;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

//왜 종류별로 알고리즘을 학습해야 하나?
//
// 1. 다양한 알고리즘을 학습하면서 : 문제풀이의 접근방식을 학습 할 수 있습니다.
// 2. 문제를 해결하는 알고리즘은 한 가지가 아니구나! 절대적인 것은 없구나!


class MyData implements Comparable<MyData>{
    int v;

    public MyData(int v){
        this.v = v;
    }

    @Override
    public String toString() {
        return String.valueOf(v); //"" + v;
    }

    @Override
    public int compareTo(MyData o) {
        return Integer.compare(v,o.v); //v - o.v;
    }
}

public class Collection정렬 {
    public static void main(String[] args) {
//        List<Integer> list = new LinkedList<>();

//        Random r =new Random();
//        for(int i=0;i<20;i++)list.add(r.nextInt(50));

//        list.sort(Comparator.naturalOrder()); //오름차순
//        list.sort(Comparator.reverseOrder()); //내림차순

//        //오름차순
//        list.sort(new Comparator<Integer>(){
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1.intValue() - o2.intValue();
//            }
//        });

        //내림 차순
//        list.sort(new Comparator<Integer>(){
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2.compareTo(o1);
//            }
//        });

        //람다식
//        list.sort((o1,o2) -> o2.compareTo(o1));

        List<MyData> list = new LinkedList<>();

        Random r =new Random();
        for(int i=0;i<20;i++)list.add(new MyData(r.nextInt(50)));

        //단순 비교
//        list.sort(new Comparator<MyData>(){
//            @Override
//            public int compare(MyData o1, MyData o2) {
//                return o2.v-o1.v;
//            }
//        });

        //Comparable 인터페이스 구현
//        list.sort(Comparator.reverseOrder());

        list = quickSort(list);

        System.out.println(list);
    }

    static List<MyData> quickSort(List<MyData> list){
        if(list.size() <= 1) return list;

        MyData pivot = list.remove(0);

        List<MyData> lesser = new LinkedList<>();
        List<MyData> greater = new LinkedList<>();

        for(MyData m: list){
            if(pivot.compareTo(m) > 0) lesser.add(m);
            else greater.add(m);
        }

        List<MyData> merged = new LinkedList<>();
        //오름차순
//        merged.addAll(quickSort(lesser));
//        merged.add(pivot);
//        merged.addAll(quickSort(greater));

        //내림차순
        merged.addAll(quickSort(greater));
        merged.add(pivot);
        merged.addAll(quickSort(lesser));

        return merged;
    }
}
