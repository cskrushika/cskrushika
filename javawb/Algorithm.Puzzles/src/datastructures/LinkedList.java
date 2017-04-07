package datastructures;

public class LinkedList<E> {
	private static class Node<E> {
		E data;
		Node<E> next;
		Node<E> prev;

		public Node(Node<E> prev, E n, Node<E> next) {
			this.data = n;
			this.next = next;
			this.prev = prev;
		}
	}

	private Node<E> first;
	private Node<E> last;

	public Node<E> getFirst() {
		return first;
	}

	public void setFirst(Node<E> first) {
		this.first = first;
	}

	public Node<E> getLast() {
		return last;
	}

	public void setLast(Node<E> last) {
		this.last = last;
	}

	private int size = 0;

	public void insertAtBeginning(E e) {
		Node<E> f = first;
		Node<E> newnode = new Node<E>(null, e, f);
		first = newnode;
		if (f == null) {
			last = newnode;
		} else {
			f.prev = newnode;
		}
		size++;
	}

	public void insertAtEnd(E e) {
		Node<E> l = last;
		Node<E> newnode = new Node<E>(l, e, null);
		last = newnode;
		if (l == null) {
			first = newnode;
		} else {
			l.next = newnode;
		}
		size++;
	}

	/**
	 * Returns the index of the first occurrence of the specified element in
	 * this list, or -1 if this list does not contain the element.
	 */
	public int indexOf(Object o) {
		int index = 0;
		if (o == null) {
			for (Node<E> n = first; n != null; n = n.next) {
				if (n.data == null)
					return index;
				index++;
			}
		} else {
			for (Node<E> n = first; n != null; n = n.next) {
				if (n.equals(o))
					return index;
				index++;
			}
		}
		return -1;
	}

	public E unlinkFirst(Node<E> f) {
		Node<E> next = first.next;
		E data = first.data;
		f.data = null;
		f.next = null;
		first = next;
		if (next == null)
			last = null;
		else
			next.prev = null;
		size--;
		return data;
	}

	public void insert(E data, int position) {
		// set the position to a valid number as either 0 or size
		if (position < 0)
			position = 0;
		if (position > size)
			position = size;

		if (first == null) {
			first = new Node<E>(null, data, null);
			last = first;
		} else if (position == 0) {
			Node<E> temp = new Node<E>(null, data, first);
			first = temp;
		} else {
			Node<E> temp = first;
			for (int i = 1; i < position; i++) {
				temp = temp.next;
			}
			Node<E> newnode = new Node<E>(temp, data, temp.next);
			newnode.next.prev = newnode;
			temp.next = newnode;
		}
		size++;
	}
}
