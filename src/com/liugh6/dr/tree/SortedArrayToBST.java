package com.liugh6.dr.tree;

public class SortedArrayToBST {
	public static TreeNode sortedArrayToBST(int[] A) {
		// write your code here
		// 数组中间值作为树的根节点
		if (A == null || A.length == 0) {
			return null;
		}
		if (A.length == 1) {
			return new TreeNode(A[0]);
		}
		int index = A.length / 2;
		TreeNode node = new TreeNode(A[index]);
		int[] lsftA = new int[index];
		System.arraycopy(A, 0, lsftA, 0, index);
		node.left = sortedArrayToBST(lsftA);

		int[] rightA = new int[A.length - index];
		System.arraycopy(A, index, rightA, 0, A.length - index);
		node.right = sortedArrayToBST(rightA);
		return node;
	}

	public static void main(String[] args) {
		int a[] = { 0 };
		TreeNode tree = sortedArrayToBST(a);
		System.out.print(tree);
	}

}
