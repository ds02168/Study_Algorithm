import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

// Array 장점 + List 장점 => 유연하면서도 빠르게 값을 찾아낼 수 있는
// Map : Key -> Hash Function -> hash -> bucket index -> List -> Data
//
// Map<K,V>
// HashMap : not sync, 멀티 쓰레드x, 속도
// Hashtable : sync, 쓰레드, 안정성
// ConcurrentHashMap : sync + high concurrency

class MyData{
    int v;

    public MyData(int v){
        this.v = v;
    }

    public String toString(){
        return "[" + v + "]";
    }

    @Override
    public boolean equals(Object o) { //객체간 비교시 객체 주소가 아닌 값 비교
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyData myData = (MyData) o;
        return v == myData.v;
    }

    @Override
    public int hashCode() { //값 비교시 해쉬값 비교
        return Objects.hash(v);
    }
}


public class Map실습 {
    public static void main(String[] args){
//        Hashtable<String, Integer> map = new Hashtable<>(); //해쉬테이블 레퍼런스
//        Map<String, Integer> map = new Hashtable<>(); //Map 인터페이스
//        Map<String, Integer> map = new HashMap<>(); //해쉬 맵
        Map<MyData, Integer> map = new ConcurrentHashMap<>(); //해쉬 맵
//        map.put("A",1);
//        map.put("B",2);
        map.put(new MyData(1),1);
        map.put(new MyData(2),2);
//        map.replace("A",1,11); //key가 oldValue면 newValue로 바꿔라
        map.replace(new MyData(1),1,11); //key가 oldValue면 newValue로 바꿔라

        method1(map);
    }

    static void method1(Map<MyData, Integer> map){
//        System.out.println(map.remove("B",3)); //key가 현재 value 값이면 삭제
        System.out.println(map.remove(new MyData(2),2)); //key가 현재 value 값이면 삭제
//        map.putIfAbsent("C",10); //이미 있다면 안 넣음
        System.out.println(map);
//        System.out.println(map.get("A"));
        System.out.println(map.get(new MyData(1)));
//        System.out.println(map.get("C"));
//        System.out.println(map.getOrDefault("C",-1)); //없다면 디폴트 값 반환
        System.out.println(map.getOrDefault(new MyData(3),-1)); //없다면 디폴트 값 반환
        System.out.println(map.values()); //value들만 뽑아냄
        System.out.println(map.keySet()); //key들만 뽑아냄
    }
}
