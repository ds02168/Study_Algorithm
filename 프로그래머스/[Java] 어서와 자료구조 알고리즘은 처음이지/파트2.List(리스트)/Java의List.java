package com.programmers.java;

import java.util.*;

// LinkedList
// List�������̽�
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
		return value == myData.value; //���� ��ü�� Ÿ ��ü�� �� ��
	}
}

public class Java��List {
	public static void main(String[] args) {
		//List<MyData> list = new LinkedList<>();
		//List<MyData> list = new Vector<>(); //�������ε� ����Ʈ�����ε� ǥ�� �����ϴ�. ������
		List<MyData> list = new ArrayList<>();
		list.add(MyData.create(1));
		list.add(MyData.create(2));
		list.add(MyData.create(3));
		
		//System.out.println(list.contains(MyData.create(2))); //����
		//System.out.println(list.indexOf(MyData.create(1))); //�տ��� ���� ��
		//System.out.println(list.size()); //ũ��
		//System.out.println(list.isEmpty()); //����ִ���
		
		method1(list);
	}
	
	//List<>�� ���� �پ��� Ÿ���� ���� �� ����
	static void method1(List<MyData> list){
		System.out.println(list);
		System.out.println(list.get(2));
		System.out.println(list.size());
		System.out.println(list.isEmpty());
	}
	
	//���ʹ� Synchronized, ArrayList�� Synchronized X
}
