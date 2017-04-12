package datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;


class Node {
	int data;
	Node left;
	Node right;

	public Node(int n) {
		this.data = n;
		this.left = this.right = null;
	}
}

class BreadthFirstTraversal {
	Node root = null;

	void printBFS() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {	// each iteration of the while completes a level
			int sum = 0;
			Node temp = queue.poll();
			sum = sum + temp.data;
			System.out.println(temp.data + "");
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
			System.out.println("Sum at level: "+sum);
		}
	}

	public static void main(String[] args) {
		BreadthFirstTraversal tree = new BreadthFirstTraversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.right = new Node(6);

		System.out.println("Level order traversal of binary tree is - ");
		tree.printBFS();
	}
}
