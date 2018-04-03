package com.liugh6.dr.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liugh6 ���µ��ϵĲ�α���������
 */
public class buttomUpTree {
	/**
	 * @param root:
	 *            A tree
	 * @return: buttom-up level order a list of lists of integer
	 */
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		// write your code here
		List<List<Integer>> rtnList = new ArrayList<List<Integer>>();
		if (root == null) {
			return rtnList;
		}
		// �����ϵ��±����Ľ��ѹ��ջ������ջ������Ǵ��µ��ϵı������
		LinkedList<List<Integer>> stack = new LinkedList<List<Integer>>();
		// ͨ�����в�α�����
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				list.add(node.val);
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			stack.push(list);
		}
		int size = stack.size();
		for (int i = 0; i < size; i++) {
			rtnList.add(stack.pop());
		}
		return rtnList;
	}

	public static void main(String strs[]) {
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);
		System.out.println(levelOrderBottom(treeNode));
	}
}
