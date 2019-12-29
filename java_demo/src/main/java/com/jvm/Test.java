package com.jvm;

public class Test {
	public int calc(){
		int a = 100;
		int b = 200;
		int c = 300;
		return (a+b)*c;
	}

	public static void main(String[] args) {
		Test t = new Test();
		System.out.println(t.calc());

	}
}



