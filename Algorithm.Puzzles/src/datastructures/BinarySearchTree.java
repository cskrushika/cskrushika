package datastructures;

class BinarySearchTree {
	static ListNode root;

	ListNode insert(ListNode node, int data) {
		if (node == null)
			return new ListNode(data);
		if (data <= node.data) {
			node.left = insert(node.left, data);
		} else {
			node.right = insert(node.right, data);
		}
		return node;
	}

	int minValue(ListNode node) {
		ListNode current = node;
		while (current.left != null) {
			current = current.left;
		}
		return current.data;
	}

	public static void main(String args[]) {
		BinarySearchTree bst = new BinarySearchTree();
		ListNode tree = null;
		tree = bst.insert(null, 5);
		bst.insert(tree, 20);
		bst.insert(tree, 22);
		bst.insert(tree, 8);
		bst.insert(tree, 12);
		bst.insert(tree, 12);
		bst.insert(tree, 13);
		bst.insert(tree, 14);
		bst.insert(tree, 10);
		bst.insert(tree, 19);
		System.out.println("Leftmost node: " + bst.minValue(tree));
	}
}
