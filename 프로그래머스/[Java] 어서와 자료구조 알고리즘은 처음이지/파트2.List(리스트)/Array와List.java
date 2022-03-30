package com.programmers.java;

import java.util.Arrays;

public class Array¿ÍList {

	public static void main(String[] args) {
		int[] arr = new int[5];
		arr[0] = 1;
		arr[arr.length - 1] = 5;
		System.out.println(Arrays.toString(arr));
		System.out.println(arr.length);
	}

}
