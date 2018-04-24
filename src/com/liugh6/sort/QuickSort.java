package com.liugh6.sort;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] a = { 1, 2, 4, 5, 7, 4, 5, 3, 9, 0 };
		System.out.println(Arrays.toString(a));
		sort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}

	public static int partition(int[] array, int lo, int hi) {
		// �̶����зַ�ʽ
		int key = array[lo];
		while (lo < hi) {
			while (array[hi] >= key && hi > lo) {// �Ӻ�벿����ǰɨ��
				hi--;
			}
			array[lo] = array[hi];
			while (array[lo] <= key && hi > lo) {// ��ǰ�벿�����ɨ��
				lo++;
			}
			array[hi] = array[lo];
		}
		array[hi] = key;
		return hi;
	}

	public static void sort(int[] array, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		int index = partition(array, lo, hi);
		sort(array, lo, index - 1);
		sort(array, index + 1, hi);
	}
}
