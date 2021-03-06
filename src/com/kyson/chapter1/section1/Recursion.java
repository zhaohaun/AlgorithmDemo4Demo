package com.kyson.chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

/***
 * 
 * 
 * 
 */
public class Recursion {

	/**
	 * 1.1.16 给出 exR1(6) 的返回值:
	 */
	public static String exR1(int n) {
		if (n <= 0)
			return "";
		return exR1(n - 3) + n + exR1(n - 2) + n;
	}

	/***
	 * 1.1.18 请看以下递归函数: mystery(2, 25) 和 mystery(3, 11) 的返回值是多少?给定正整数 a 和
	 * b，mystery(a,b)计算的结果是什么?将代码中的 + 替换为 * 并将 return 0 改为 return 1，然后回答相同 的问题。
	 */
	public static int mystery(int a, int b) {
		if (b == 0)
			return 0;
		if (b % 2 == 0)
			return mystery(a + a, b / 2);
		return mystery(a + a, b / 2) + a;
	}

	public static int mystery1(int a, int b) {
		if (b == 0)
			return 1;
		if (b % 2 == 0)
			return mystery1(a * a, b / 2);
		return mystery1(a * a, b / 2) * a;
	}
	
	
	

	public static void main(String[] args) {

		/***
		 * 1.1.16
		 */
		System.out.println("1.1.16:");
		System.out.println("exR1(6)的输出：" + exR1(6));

		/***
		 * 1.1.18
		 */
		System.out.println("1.1.18:");
		System.out.println("mystery(2, 25):" + mystery(2, 25)); // 输出50
		System.out.println("mystery(3, 11):" + mystery(3, 11)); // 输出33
		System.out.println("mystery1(2, 25):" + mystery1(2, 25)); // 输出33554432
		System.out.println("mystery1(3, 11):" + mystery1(3, 11)); // 输出177147

		/***
		 * 1.1.19
		 */
		System.out.println("1.1.19");
		for (int N = 0; N < 100; N++)
			StdOut.println(N + " " + Fibonacci.F1(N));
	}

}
