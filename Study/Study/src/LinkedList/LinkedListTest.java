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
//		ll.append(4);//마지막 next에 추가
//		ll.retrieve(); // 모든 정보 syso
//		ll.removeDups(); //중복제거
//		ll.retrieve();

//		LinkedList ll = new LinkedList();
//		ll.append(1);
//		ll.append(2);
//		ll.append(3);
//		ll.append(4);
//		ll.retrieve();
//		//뒤에서 부터 k인덱스의 값 확인하기
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
//		Node found = KthToLast2(ll.getFirst(), k, r); count 를 저장해서 이용.
//		
//		
//		//포인트를 이용한 Node 찾기
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

		//첫번째 인덱스가 1의자리인 list 서로더하기
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

		//마지막 인덱스가 1의자리인 list를 더하기
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

		//교차점찾기
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
		
		//무한루프 찾기
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

	// 재귀함수를 이용한 끝에서 인덱스 찾기
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

	// 중간에있는 노드만 삭제가능 첫번쨰와 마지막 안됨.
	private static boolean deleteNode(Node n) {
		if (n == null || n.next == null) {
			return false;
		}
		Node next = n.next;
		n.data = next.data;
		n.next = next.next;
		return true;
	}

	// 거꾸로 된 각 인덱스의 숫자(마지막숫자가 1의자리) 숫자를 더해서 새로운 LinkedList로 리턴하기.
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

	// 마지막 인덱스가 1의자리인 list의 더하기
	private static Node sumLists1(Node l1, Node l2) {
		int len1 = getListLength(l1); // list 의 길이를 구해온다
		int len2 = getListLength(l2);

		if (len1 < len2) {
			l1 = LPadList(l1, len2 - len1); // list의 길이를 동일하게 맞춰준다
		} else {
			l2 = LPadList(l2, len1 - len2);
		}
		Storage storage = addLists(l1, l2);// 실제로 node를 생성하고 덧셈이 이뤄지고 새로 생성된 node의 header를 리턴받는다

		if (storage.carry != 0) { // 캐리가 1일 경우에 맨앞에 1 노드를 추가해서 return
			storage.result = insertBefore(storage.result, storage.carry);
		}

		return storage.result; // 아니라면 그냥 리턴

	}

	// 맨뒤의 숫자부터
	private static Storage addLists(Node l1, Node l2) {
		if (l1 == null && l2 == null) {
			Storage storage = new Storage();
			return storage; // 마지막 지점 도착
		}
		Storage storage = addLists(l1.next, l2.next);// 마지막 지점 도착시 반복되는 명령
		int value = storage.carry + l1.data + l2.data; // data를 더해서
		int data = value % 10; // 나머지를통해 data를 구하고
		storage.result = insertBefore(storage.result, data);// storage.result의 앞에 data를 통한 node를 생성해 리턴
		storage.carry = value / 10;
		return storage; // 반복
	}

	// l을 시작점으로 list의 길이를 구해 반환한다.
	private static int getListLength(Node l) {
		int total = 0;
		while (l != null) {
			total++;
			l = l.next;
		}
		return total;
	}

	// 파라미터의 node 앞에 주어진 data를 통해 node를 생성하고 next에 node를 넣는데
	private static Node insertBefore(Node node, int data) {
		Node before = new Node();
		before.data = data;
		if (node != null) {
			before.next = node;
		}
		return before;
	}

	// 주어진 node 앞에 length만큼 0을 가진 node를 추가한다.
	private static Node LPadList(Node l, int length) {
		Node head = l;
		for (int i = 0; i < length; i++) {
			head = insertBefore(head, 0);
		}
		return head;
	}

	//교차점을 찾아서 리턴하는 메소드
	private static Node getIntersection(Node l1, Node l2) {
		int len1 = getListLength(l1); //길이를 구해서
		int len2 = getListLength(l2);
		//list 길이가 다르다면 시작지점을 같도록해준다.
		if (len1 > len2) {
			l1 = l1.get(len1 - len2); 
		} else if (len1 < len2) {
			l2 = l2.get(len2 - len1);
		}
		
		//l1과 l2값을 비교하여 같은 값이 나오면 그곳이 교차점이기 떄문에 둘중하나를 리턴
		while (l1 != null && l2 != null) {
			if (l1 == l2) {
				return l1;
			}
			l1 = l1.next;
			l2 = l2.next;
		}
		return null; //없다면 null 리턴
	}
	
	//무한루프 시작점 찾는 메소드
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
