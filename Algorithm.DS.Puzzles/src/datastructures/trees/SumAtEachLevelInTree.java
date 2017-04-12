package datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Time Complexity : O(n)</br>
 * Auxiliary Space : O(n)
 *
 */
class SumAtEachLevelInTree {
	Node root = null;

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int n) {
			this.data = n;
			this.left = this.right = null;
		}
	}

	void printBFS() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) { // each iteration of the while completes a level
			int sum = 0;
			int count = queue.size();
			while (count-- != 0) {
				Node temp = queue.poll();
				sum = sum + temp.data;
				System.out.println(temp.data + "");
				if (temp.left != null) {
					queue.add(temp.left);
				}
				if (temp.right != null) {
					queue.add(temp.right);
				}
			}
			System.out.println("Sum at level: " + sum);
		}
	}

	public static void main(String[] args) {
		SumAtEachLevelInTree tree = new SumAtEachLevelInTree();
		tree.root = new SumAtEachLevelInTree.Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.right = new Node(6);

		System.out.println("Level order traversal of binary tree is - ");
		tree.printBFS();
	}
}
