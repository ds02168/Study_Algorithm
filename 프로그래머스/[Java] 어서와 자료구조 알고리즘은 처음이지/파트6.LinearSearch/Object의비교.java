package LinearSearch;

import java.util.*;

// search는 indexOf, contains, remove 같은 곳에서 이미 구현되어 있습니다. : 완전탐색
// equals가 제공될 필요가 있다.
//
// 이진탐색 : Collections.binarySearch
// Comparable가 구현되어 있어야 한다.
// 순서대로 정렬되어 있어야 한다.


class MyData implements Comparable<MyData>{
    int v;

    public MyData(int v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "" + v;
    }

    @Override
    public boolean equals(Object o) {
       if(this==o)return true;
       if(o==null || getClass() != o.getClass()) return false;
       MyData myData = (MyData) o;
       return v == myData.v;
    }

    @Override
    public int hashCode() {
        return Objects.hash(v);
    }

    public int compareTo(MyData o){
        // 1 ? 2 : 1 - 2 == 0 : 같다
        //               < 0 : 오른쪽이 크다
        //               > 0 : 왼족이 크다

        return v - o.v;
    }
}

public class Object의비교 {
    public static void main(String[] args) {
//        List<Integer> list = new LinkedList<>();
//        for(int i =1; i<= 100; i++) list.add(i);
//        System.out.println(list);
//        int index = list.indexOf(63);
//        System.out.println(index);

        List<MyData> list = new LinkedList<>();

//        for(int i = 1; i<= 100;i++)list.add(new MyData(i));
//
//        System.out.println(list);
//        int index = list.indexOf(new MyData(63));
//        System.out.println(index);

        Random r= new Random();
        for(int i = 1; i<=100; i++){
            list.add(new MyData(i));
        }
        System.out.println(list);
        int index = Collections.binarySearch(list, new MyData(63));

        //정렬한다 -> sort 한다.
//        int index = list.indexOf(new MyData(63));
        System.out.println(index);
        System.out.println(list.get(index));
    }
}
