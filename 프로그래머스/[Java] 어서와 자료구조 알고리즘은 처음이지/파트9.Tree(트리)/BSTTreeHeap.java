package section9;

import java.util.*;


class MyData implements Comparable<MyData>{
    int v;

    public MyData(int v){
        this.v = v;
    }

    @Override
    public String toString() {
        return String.valueOf(v);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyData myData = (MyData) o;
        return v == myData.v;
    }

    @Override
    public int hashCode() {
        return Objects.hash(v);
    }

    @Override
    public int compareTo(MyData o) {
        return Integer.compare(v, o.v);
    }
}

public class BSTTreeHeap {
    public static void main(String[] args) {
//        // Tree
//        Set<MyData> set = new TreeSet<>(); // Binary Search Tree
//
//        set.add(new MyData(1));
//        set.add(new MyData(2));
//        set.add(new MyData(3));
//
//        set.add(new MyData(1));
//        set.add(new MyData(2));
//        set.add(new MyData(3));
//
//        System.out.println(set);

//        //Heap
//        //O(nlogn) / O(logn)
//        Queue<Integer> queue = new PriorityQueue(); //최댓값(최소값) 유지

//        queue.offer(100);
//        queue.offer(1);
//        queue.offer(60);
//        queue.offer(30);
//
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());


//        Random r = new Random();
//        for(int i = 0; i< 20; i++){
//            queue.offer(r.nextInt(50));
//        }
//
//        System.out.println(queue);
//
//        List<Integer> sorted = new LinkedList<>();
//        while(!queue.isEmpty()) sorted.add(queue.poll()); //heap sort
//
//        System.out.println(sorted);

        Queue<MyData> queue = new PriorityQueue(); //최댓값(최소값) 유지

        Random r = new Random();
        for(int i = 0; i< 20; i++){
            queue.offer(new MyData(r.nextInt(50)));
        }

        System.out.println(queue);

        List<MyData> sorted = new LinkedList<>();
        while(!queue.isEmpty()) sorted.add(queue.poll()); //heap sort

        System.out.println(sorted);
    }
}
