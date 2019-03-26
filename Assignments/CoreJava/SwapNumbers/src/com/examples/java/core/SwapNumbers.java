package com.examples.java.core;

public class SwapNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int a=10;
		   int b=20;

System.out.println("--Before swap--");
System.out.println("First number = " + a);
System.out.println("Second number = " + b);

// Value of first is assigned to temporary
int temp = a;

// Value of second is assigned to first
a = b;

// Value of temporary (which contains the initial value of first) is assigned to second
b = temp;

System.out.println("--After swap--");
System.out.println("First number = " + a);
System.out.println("Second number = " + b);

	}

}
