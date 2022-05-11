package Set집합;

import java.util.*;

class MyData{
    int v;

    public MyData(int v){
        this.v = v;
    }
    public String toString(){
        return "" + v;
    }

    @Override
    public boolean equals(Object obj) { //객체간 비교
        if(this == obj) return true; //같은 객체
        if(obj == null || getClass() != obj.getClass()) return false; //다른 클래스
        MyData myData = (MyData) obj; //타입 캐스팅
        return v == myData.v; //값 비교
    }

    @Override
    public int hashCode() {
        return Objects.hash(v); //해시 반환
    }
}
public class Set실습 {
    public static void main(String[] args){

//        List<Integer> list = new LinkedList<>();
//
//        if(!list.contains(1)) list.add(1);
//        if(!list.contains(2)) list.add(2);
//        if(!list.contains(3)) list.add(3);
//
//        if(!list.contains(1)) list.add(1);
//        if(!list.contains(2)) list.add(2);
//        if(!list.contains(3)) list.add(3);

//        HashSet<Integer> list = new HashSet<>();

//        list.add(1);
//        list.add(2);
//        list.add(3);
//
//        list.add(1);
//        list.add(2);
//        list.add(3);

//        HashSet<MyData> list = new HashSet<>(); //set은 순서를 보장하지 않는다.
//        Set<MyData> list = new HashSet<>();
//        Set<MyData> list = new LinkedHashSet<>();

//        list.add(new MyData(1));
//        list.add(new MyData(2));
//        list.add(new MyData(3));
//
//        list.add(new MyData(1));
//        list.add(new MyData(2));
//        list.add(new MyData(3));


        Set<MyData> setA = new LinkedHashSet<>();
        Set<MyData> setB = new LinkedHashSet<>();

        //A
        setA.add(new MyData(1));
        setA.add(new MyData(2));
        setA.add(new MyData(3));

        //B
        setB.add(new MyData(2));
        setB.add(new MyData(3));
        setB.add(new MyData(4));

//
//        //A + B
//        setA.addAll(setB);
//        //A - B
//        setA.removeAll(setB);
        //A * B
        setA.retainAll(setB);

        System.out.println(setA);
    }
}
