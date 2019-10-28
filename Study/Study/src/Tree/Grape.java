package Tree;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Stack;


class Queue<T>{
	class Node<T>{
		private T data;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
	}
	
	private Node<T> first;
	private Node<T> last;
	
	public void add(T item) {
		Node<T> t = new Node<T>(item);
		
		if(last != null) {
			last.next = t;
		}
		last = t;
		if(first == null) {
			first = last;
		}
	}
	
	public T remove() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		T data = first.data;
		first = first.next;
		
		if(first == null) {
			last = null;
		}
		return data;
	}
	
	public T peek() {
		if(first == null) {
			throw new NoSuchElementException();
		}
		return first.data;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
}
class Graph{
	class Node{
		int data;
		LinkedList<Node> adjacent;//���� ��带 ����
		boolean marked; //�����ô��� �Ⱥô��� Ȯ��
		Node (int data){
			this.data = data;
			this.marked = false;
			adjacent = new LinkedList<Node>(); 
		}
	}
	
	Node[] nodes; // �׷����� �� ���
	public Graph(int size) { //size��ŭ�� ��带 ����
		nodes = new Node[size];
		for(int i = 0; i< size; i++) {
			nodes[i] = new Node(i);
		}
	}
	
	void addEdge(int i1, int i2) { //node1�� node2 LinkedList�� ��� ������ �������ش�.
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		if(!n1.adjacent.contains(n2)) {
			n1.adjacent.add(n2);
		}
		if(!n2.adjacent.contains(n1)) {
			n2.adjacent.add(n1);
		}
	}
	
	void dfs() {
		dfs(0);
	}
	void dfs(int index) { //��;��� Stack�� �̿��� dfs(���� Ž�� �켱)
		Node root = nodes[index]; // ���� ��带 �����´�.
		Stack<Node> stack = new Stack<Node>(); // ���� ���� ����
		stack.push(root); // ���ÿ� ��带 ����
		root.marked = true; // ������ ���� marked true�� �ٲ��ش�
		while(!stack.isEmpty()) { // ������ ��������ʴٸ�
			Node r = stack.pop();	//stack����  ��� ��������
			for(Node n : r.adjacent) { //������ ����� ����list�� ������ ������ �ݺ��Ѵ�
				if(n.marked == false) { //������������ �͵鸸
					n.marked = true;  //�����Դ� ������ �����.
					stack.push(n); //stack�� �ִ´�
				}
			}
			visit(r); // ó�� ���´� node�� ���
		}
	}
	void bfs() {
		bfs(0);
	}
	void bfs(int index) { //Queue�� �̿��� ����Ž�� �켱
		Node root = nodes[index];//���� ��带 �����´�
		Queue<Node> queue = new Queue<Node>(); // Queue����
		queue.add(root); // Queue�� ��带 �ְ�
		root.marked = true; // marked true!
		while (!queue.isEmpty()) { // queue�� ��������ʴٸ�
			Node r = queue.remove(); // queue���� Node�� �����ͼ�
			for(Node n : r.adjacent) { // �ش����� ���� List�� �����ͼ�
				if(n.marked == false) { //������������ ���鸸
					n.marked = true; //marked true!
					queue.add(n); // queue�� �־��ش�
				}
			}
			visit(r); // ó�� �����Դ� node�� ���
		}
	}
	
	void dfsR(Node r) {// ����Լ��� �̿��� dfs
		if (r == null) return; //r�� ���̵ɶ�����
		r.marked = true; //��Ŀ�� �����
		visit(r); // ���
		for(Node n : r.adjacent) { // �ش� ����� ����������
			if(n.marked == false) { // ��Ŀ�����°͵鸸
				dfsR(n); // �ٽ� ȣ��.
			}
		}
	}
	
	void dfsR(int index) {
		Node r = nodes[index];
		dfsR(r);
	}
	void dfsR() {
		dfsR(0);
	}
	void visit(Node n) {
		System.out.print(n.data + " ");
	}
}
/*
 *  0
 * /
 * 1�Ѥ� 3     7
 * |  /| \  /
 * | / |  5
 * 2�Ѥ� 4   \
 *          6 - 8
 * DFS(0)
 * 0 1 3 5 7 6 8 4 2
 * BFS(0)
 * 0 1 2 3 4 5 6 7 8
 * DFS(0) - Recursive �������
 * 0 1 2 3 4 5 6 8 7
 */           
public class Grape {

	public static void main(String[] args) {
		Graph g = new Graph(9);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(5, 6);
		g.addEdge(5, 7);
		g.addEdge(6, 8);
		g.dfsR();
	}
}