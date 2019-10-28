package Queue;

public class QueueTest {

	public static void main(String[] args) {
//		Queue<Integer> q = new Queue<Integer>();
//		q.add(1);
//		q.add(2);
//		q.add(3);
//		q.add(4);
//		System.out.println(q.remove());
//		System.out.println(q.remove());
//		System.out.println(q.peek());
//		System.out.println(q.remove());
//		System.out.println(q.isEmpty());
//		System.out.println(q.remove());
//		System.out.println(q.isEmpty());
		
		MyQueue<Integer> q1 = new MyQueue<Integer>();
		q1.add(1);
		q1.add(2);
		q1.add(3);
		System.out.println(q1.remove());
		System.out.println(q1.remove());
		System.out.println(q1.remove());
	}

}
