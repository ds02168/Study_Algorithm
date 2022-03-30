package com.programmers.java;

import java.util.*;

// LinkedList
// List인터페이스
// 
// ArrayList (not synch)
// Vector (synch)



class MyData{
	int value;
	
	public MyData(int v) {
		value = v;
	}
	
	static MyData create(int v) {
		return new MyData(v);
	}

	@Override
	public String toString() {
		return "" + value;
	}
	
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		MyData myData = (MyData) o;
		return value == myData.value; //현재 객체와 타 객체의 값 비교
	}
}

public class Java의List {
	public static void main(String[] args) {
		//List<MyData> list = new LinkedList<>();
		//List<MyData> list = new Vector<>(); //벡터형인데 리스트형으로도 표현 가능하다. 다형성
		List<MyData> list = new ArrayList<>();
		list.add(MyData.create(1));
		list.add(MyData.create(2));
		list.add(MyData.create(3));
		
		//System.out.println(list.contains(MyData.create(2))); //값비교
		//System.out.println(list.indexOf(MyData.create(1))); //앞에서 부터 비교
		//System.out.println(list.size()); //크기
		//System.out.println(list.isEmpty()); //비어있는지
		
		method1(list);
	}
	
	//List<>로 만들어서 다양한 타입을 받을 수 있음
	static void method1(List<MyData> list){
		System.out.println(list);
		System.out.println(list.get(2));
		System.out.println(list.size());
		System.out.println(list.isEmpty());
	}
	
	//백터는 Synchronized, ArrayList는 Synchronized X
}
