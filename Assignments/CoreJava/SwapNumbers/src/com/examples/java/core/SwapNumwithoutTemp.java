package com.examples.java.core;

public class SwapNumwithoutTemp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        int a=15;
		  int b=30;

  System.out.println("--Before swap--");
  System.out.println("First number = " + a);
  System.out.println("Second number = " + b);
	
	a=a-b;
	b=a+b;
	a=b-a;

  System.out.println("--After swap--");
  System.out.println("First number = " + a);
  System.out.println("Second number = " + b);
	}

}
