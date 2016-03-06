package org.zw.singletion.jeeframework.test.menu;

public class Digui {
	/*
	 * 递归算法
	 * 自己调用自己
	 */
	long v = 0;

	public long test(int n) {
		if (n == 1) {
			v = 1;
		} else {
			v = n * test(n - 1);
		}
		return v;
	}

	public static void main(String[] args) {
		System.out.println(new Digui().test(5));
		//120
	}
}
