package LinkedList;

import LinkedList.LinkedList.Node;

class Reference {
	public int count = 0;
}

class Storage {
	int carry = 0;
	Node result = null;
}

public class LinkedListTest {

	public static void main(String[] args) {
//		LinkedList ll = new LinkedList();
//		ll.append(1);
//		ll.append(2);
//		ll.append(3);
//		ll.append(4);//������ next�� �߰�
//		ll.retrieve(); // ��� ���� syso
//		ll.removeDups(); //�ߺ�����
//		ll.retrieve();

//		LinkedList ll = new LinkedList();
//		ll.append(1);
//		ll.append(2);
//		ll.append(3);
//		ll.append(4);
//		ll.retrieve();
//		//�ڿ��� ���� k�ε����� �� Ȯ���ϱ�
//		int k = 3;
//		KthToLast(ll.getFirst(), k);

//		LinkedList ll = new LinkedList();
//		ll.append(1);
//		ll.append(2);
//		ll.append(3);
//		ll.append(4);
//		ll.retrieve();
//		int k = 2;
//		Reference r = new Reference();
//		Node found = KthToLast2(ll.getFirst(), k, r); count �� �����ؼ� �̿�.
//		
//		
//		//����Ʈ�� �̿��� Node ã��
//		Node found = KthToLast3(ll.getFirst(), k);
//		System.out.println(found.data);

//		LinkedList l5 = new LinkedList();
//		
//		l5.append(1);
//		l5.append(2);
//		l5.append(3);
//		l5.append(4);
//		l5.append(5);
//		l5.retrieve();
//		deleteNode(l5.get(3));
//		l5.retrieve();

		//ù��° �ε����� 1���ڸ��� list ���δ��ϱ�
//		LinkedList l6 = new LinkedList();
//		l6.append(9);
//		l6.append(1);
//		l6.append(4);
//		l6.retrieve();
//		
//		LinkedList l7 = new LinkedList();
//		l7.append(6);
//		l7.append(4);
//		l7.append(3);
//		l7.retrieve();
//		
//		Node n = sumLists(l6.get(1), l7.getFirst(), 0);
//		while(n.next != null) {
//			System.out.print(n.data + " -> ");
//			n = n.next;
//		}
//		System.out.println(n.data);

		//������ �ε����� 1���ڸ��� list�� ���ϱ�
//		LinkedList l1 = new LinkedList();
//		l1.append(9);
//		l1.append(1);
//		l1.retrieve();
//		
//		LinkedList l2 = new LinkedList();
//		l2.append(1);
//		l2.append(1);
//		l2.retrieve();
//		
//		Node n = sumLists1(l1.getFirst(), l2.getFirst());
//		while(n.next != null) {
//			System.out.print(n.data + " -> ");
//			n = n.next;
//		}
//		System.out.println(n.data);

		//������ã��
//		Node n1 = new Node(5);
//		Node n2 = n1.addNext(7);
//		Node n3 = n2.addNext(9);
//		Node n4 = n3.addNext(10);
//		Node n5 = n4.addNext(7);
//		Node n6 = n5.addNext(6);
//
//		Node m1 = new Node(6);
//		Node m2 = m1.addNext(8);
//
//		n1.print();
//		m1.print();
//
//		Node n = getIntersection(n1, m1);
//
//		if (n != null) {
//			System.out.println("Intersection : " + n.data);
//		} else {
//			System.out.println("Not Found");
//		}
		
		//���ѷ��� ã��
		Node n1 = new Node(1);
		Node n2 = n1.addNext(2);
		Node n3 = n2.addNext(3);
		Node n4 = n3.addNext(4);
		Node n5 = n4.addNext(5);
		Node n6 = n5.addNext(6);
		Node n7 = n6.addNext(7);
		Node n8 = n7.addNext(8);
		
		Node n = findLoop(n1);
		
		if(n != null) {
			System.out.println("Start of Loop :" + n.data);
		}else {
			System.out.println("Loop not found");
		}
	}

	// ����Լ��� �̿��� ������ �ε��� ã��
	private static int KthToLast(Node n, int k) {
		if (n == null) {
			return 0;
		}

		int count = KthToLast(n.next, k) + 1;
		if (count == k) {
			System.out.println(k + " th to last node is " + n.data);
		}
		return count;
	}

	private static Node KthToLast2(Node n, int k, Reference r) {
		if (n == null) {
			return null;
		}

		Node found = KthToLast2(n.next, k, r);
		r.count++;

		if (r.count == k) {
			return n;
		}
		return found;
	}

	private static Node KthToLast3(Node first, int k) {
		Node p1 = first;
		Node p2 = first;

		for (int i = 0; i < k; i++) {
			if (p1 == null)
				return null;
			p1 = p1.next;
		}

		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}

		return p2;
	}

	// �߰����ִ� ��常 �������� ù������ ������ �ȵ�.
	private static boolean deleteNode(Node n) {
		if (n == null || n.next == null) {
			return false;
		}
		Node next = n.next;
		n.data = next.data;
		n.next = next.next;
		return true;
	}

	// �Ųٷ� �� �� �ε����� ����(���������ڰ� 1���ڸ�) ���ڸ� ���ؼ� ���ο� LinkedList�� �����ϱ�.
	private static Node sumLists(Node l1, Node l2, int carry) {
		if (l1 == null && l2 == null && carry == 0)
			return null;

		Node result = new Node();
		int value = carry;
		if (l1 != null) {
			value += l1.data;
		}
		if (l2 != null) {
			value += l2.data;
		}

		result.data = value % 10;

		if (l1 != null || l2 != null) {
			Node next = sumLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next, value >= 10 ? 1 : 0);
			result.next = next;
		}

		return result;
	}

	// ������ �ε����� 1���ڸ��� list�� ���ϱ�
	private static Node sumLists1(Node l1, Node l2) {
		int len1 = getListLength(l1); // list �� ���̸� ���ؿ´�
		int len2 = getListLength(l2);

		if (len1 < len2) {
			l1 = LPadList(l1, len2 - len1); // list�� ���̸� �����ϰ� �����ش�
		} else {
			l2 = LPadList(l2, len1 - len2);
		}
		Storage storage = addLists(l1, l2);// ������ node�� �����ϰ� ������ �̷����� ���� ������ node�� header�� ���Ϲ޴´�

		if (storage.carry != 0) { // ĳ���� 1�� ��쿡 �Ǿտ� 1 ��带 �߰��ؼ� return
			storage.result = insertBefore(storage.result, storage.carry);
		}

		return storage.result; // �ƴ϶�� �׳� ����

	}

	// �ǵ��� ���ں���
	private static Storage addLists(Node l1, Node l2) {
		if (l1 == null && l2 == null) {
			Storage storage = new Storage();
			return storage; // ������ ���� ����
		}
		Storage storage = addLists(l1.next, l2.next);// ������ ���� ������ �ݺ��Ǵ� ���
		int value = storage.carry + l1.data + l2.data; // data�� ���ؼ�
		int data = value % 10; // ������������ data�� ���ϰ�
		storage.result = insertBefore(storage.result, data);// storage.result�� �տ� data�� ���� node�� ������ ����
		storage.carry = value / 10;
		return storage; // �ݺ�
	}

	// l�� ���������� list�� ���̸� ���� ��ȯ�Ѵ�.
	private static int getListLength(Node l) {
		int total = 0;
		while (l != null) {
			total++;
			l = l.next;
		}
		return total;
	}

	// �Ķ������ node �տ� �־��� data�� ���� node�� �����ϰ� next�� node�� �ִµ�
	private static Node insertBefore(Node node, int data) {
		Node before = new Node();
		before.data = data;
		if (node != null) {
			before.next = node;
		}
		return before;
	}

	// �־��� node �տ� length��ŭ 0�� ���� node�� �߰��Ѵ�.
	private static Node LPadList(Node l, int length) {
		Node head = l;
		for (int i = 0; i < length; i++) {
			head = insertBefore(head, 0);
		}
		return head;
	}

	//�������� ã�Ƽ� �����ϴ� �޼ҵ�
	private static Node getIntersection(Node l1, Node l2) {
		int len1 = getListLength(l1); //���̸� ���ؼ�
		int len2 = getListLength(l2);
		//list ���̰� �ٸ��ٸ� ���������� ���������ش�.
		if (len1 > len2) {
			l1 = l1.get(len1 - len2); 
		} else if (len1 < len2) {
			l2 = l2.get(len2 - len1);
		}
		
		//l1�� l2���� ���Ͽ� ���� ���� ������ �װ��� �������̱� ������ �����ϳ��� ����
		while (l1 != null && l2 != null) {
			if (l1 == l2) {
				return l1;
			}
			l1 = l1.next;
			l2 = l2.next;
		}
		return null; //���ٸ� null ����
	}
	
	//���ѷ��� ������ ã�� �޼ҵ�
	private static Node findLoop(Node head) {
		Node fast = head;
		Node slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(fast == slow) {
				break;
			}
		}
		if(fast == null || fast.next == null) {
			return null;
		}
		
		slow = head;
		
		while (fast != slow) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return fast;
	}

}
