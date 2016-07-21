package datastructures;

public class LinkedListMy {

	private Node first;
	private int size;

	public void addAtLast(String e) {
		if (size == 0) {
			first = new Node(e, null, null);
		} else {
			Node cur = new Node(e, null, first);
			first.next = cur;
		}
	}

	private static class Node {
		String item;
		Node next;
		Node previous;

		public Node(String item, Node next, Node previous) {
			super();
			this.item = item;
			this.next = next;
			this.previous = previous;
		}

	}

}
