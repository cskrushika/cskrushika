package datastructures.trees;

/**
 * This algorithm for Level order traversal or BFS</br>
 * First finds height of the tree</br>
 * Then traverse from root to a particular level to find all nodes at that level. For each node at a level, the
 * traversal starts from root node and hence an inefficient algorithm</br>
 * </br>
 * This algorithm has worst case of O(n2)</br>
 * Refer {@link SumAtEachLevelInTree} for an efficient approach
 * 
 */
public class LevelOrderTraversal {
	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int n) {
			this.data = n;
			this.left = this.right = null;
		}
	}

	static class BinaryTree {
		Node root;

		public BinaryTree() {
			super();
			root = null;
		}

		int height(Node node) {
			if (node == null)
				return 0;
			int lheight = height(node.right);
			int rheight = height(node.left);
			if (lheight > rheight)
				return 1 + lheight;
			else
				return 1 + rheight;
		}

		void printNodesAtGivenLevel(Node root, int level) {
			if (root == null)
				return;
			else if (level == 1) {
				System.out.println(root.data + " ");
			} else {
				printNodesAtGivenLevel(root.left, level - 1);
				printNodesAtGivenLevel(root.right, level - 1);
			}
		}

		int sumAtGivenLevel(Node root, int level) {
			int sum = 0;
			if (root == null)
				return 0;
			else if (level == 1) { // is this the level of interest
				return root.data;
			} else {
				sum = sum + sumAtGivenLevel(root.left, level - 1);
				sum = sum + sumAtGivenLevel(root.right, level - 1);
			}
			return sum;
		}

		void printLevelOrderTraversal() {
			int h = height(root);
			for (int i = 1; i <= h; i++) {
				printNodesAtGivenLevel(root, i);
				int sum = sumAtGivenLevel(root, i);
				System.out.println("Sum at level " + i + " = " + sum);
			}
		}
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.right = new Node(6);

		System.out.println("Level order traversal of binary tree is ");
		tree.printLevelOrderTraversal();
	}
}
