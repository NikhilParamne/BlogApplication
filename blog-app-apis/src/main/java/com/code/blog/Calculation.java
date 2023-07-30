package com.code.blog;

public class Calculation {

	public int sum(int a, int b) {
		return a + b;
	}

	public int multiply(int a, int b) {
		return a * b;
	}

	public static void main(String[] args) {
		Calculation c = new Calculation();

		int sum = c.sum(10, 20);

		int multiply = c.multiply(10, 20);

		System.out.println("sum:: " + sum + " multiply:: " + multiply);

	}
}
