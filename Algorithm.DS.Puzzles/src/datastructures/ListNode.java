package datastructures;

class ListNode<E> {
	E data;
	ListNode<E> next;
	ListNode<E> prev;

	public ListNode(ListNode<E> prev, E n, ListNode<E> next) {
		this.data = n;
		this.next = next;
		this.prev = prev;
	}

	public ListNode(E n) {
		this.data = n;
		this.next = this.prev = null;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public ListNode<E> getNext() {
		return next;
	}

	public void setNext(ListNode<E> next) {
		this.next = next;
	}

	public ListNode<E> getPrev() {
		return prev;
	}

	public void setPrev(ListNode<E> prev) {
		this.prev = prev;
	}
}