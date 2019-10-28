package LinkedList;

import java.util.NoSuchElementException;

public class LinkedList {

	Node header;

	public LinkedList() {
		header = new Node();
	}

	static class Node {
		int data;
		Node next = null;

		public Node(int i) {
			data = i;
		}

		public Node() {
			// TODO Auto-generated constructor stub
		}

		public Node get(int k) {
			Node n = this;
			for (int i = 0; i < k; i++) {
				n = n.next;
				if (n == null)
					throw new NoSuchElementException("찾는 인덱스가 없습니다.");
			}
			return n;
		}

		public Node addNext(int i) {
			Node prev = this;
			Node n = new Node(i);
			prev.next = n;
			return n;
		}

		public Node addNext(Node n) {
			Node prev = this;
			prev.next = n;
			return n;
		}

		public void print() {
			Node n = this;
			while(n.next != null) {
				System.out.print(n.data + " -> ");
				n = n.next;
			}
			System.out.println(n.data);
		}
	}

	public void append(int k) {
		Node n = header;
		Node end = new Node();
		end.data = k;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	public void delete(int d) {
		Node n = header;
		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
			} else {
				n = n.next;
			}

		}
	}

	public void retrieve() {
		Node n = header.next;
		while (n.next != null) {
			System.out.print(n.data + "->");
			n = n.next;
		}
		System.out.println(n.data);
	}

	public void removeDups() {
		Node n = header;
		while (n != null && n.next != null) {
			Node r = n;
			while (r.next != null) {
				if (n.data == r.next.data) {
					r.next = r.next.next;
				} else {
					r = r.next;
				}
			}
			n = n.next;
		}
	}

	public Node getFirst() {

		return header.next;
	}

	public Node get(int k) {
		Node n = header;
		for (int i = 0; i < k; i++) {
			n = n.next;
			if (n == null)
				throw new NoSuchElementException("찾는 인덱스가 없습니다.");
		}
		return n;
	}

}
