package com.qq.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 小Q定义了一种数列称为翻转数列 给定整数n和m,满足n和2m整除。对于一串连续递增整数数列 1，2，3，4...，每隔m个符号
 * 
 * @author gient
 *
 */
public class Main {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int a = 0, b = 0;
		while (in.hasNextInt()) {// 注意while处理多个case
			a = in.nextInt();
			b = in.nextInt();
			
			long start = System.currentTimeMillis();
			
			int[] ary = reverseAry(a, b);
			System.out.println(Arrays.toString(ary));
			int sum = sum(ary);
			System.out.println(sum);
			
			System.out.println("时间:"+(System.currentTimeMillis() - start));
		}

	}

	public static int[] reverseAry(int n, int m) {

		int[] ary = null;
		//控制打印相同符号数字的个数
		int num = 0;
		//是否是负数
		boolean isNegative = true;// 负数
		//控制isNegative的修改
		int s = 0;

		if (n % m == 0) {
			ary = new int[n];

			for (int i = 1; i <= n; i++) {
				if (num >= m) {
					num = 0;
					s++;
					if (s % 2 != 0) {
						isNegative = false; // 正数
						ary[i - 1] = i;
						num++;
					} else {
						isNegative = true;// 负数
						ary[i - 1] = -i;
						num++;
					}
				} else {
					// 如果是true，则为负数
					if (isNegative) {
						ary[i - 1] = -i;
					} else {
						ary[i - 1] = i;
					}
					num++;
				}
			}
		}

		return ary;
	}

	public static int sum(int[] ary) {
		int sum = 0;
		if (ary != null) {
			for (int i = 0; i < ary.length; i++) {
				sum += ary[i];
			}
			return sum;
		}
		return -1;
	}
}
