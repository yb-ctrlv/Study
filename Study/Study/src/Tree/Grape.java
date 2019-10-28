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
		LinkedList<Node> adjacent;//인접 노드를 정보
		boolean marked; //꺼내봤는지 안봤는지 확인
		Node (int data){
			this.data = data;
			this.marked = false;
			adjacent = new LinkedList<Node>(); 
		}
	}
	
	Node[] nodes; // 그래프의 총 노드
	public Graph(int size) { //size만큼의 노드를 생성
		nodes = new Node[size];
		for(int i = 0; i< size; i++) {
			nodes[i] = new Node(i);
		}
	}
	
	void addEdge(int i1, int i2) { //node1과 node2 LinkedList에 담아 인접을 설정해준다.
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
	void dfs(int index) { //재귀없이 Stack을 이용한 dfs(깊이 탐색 우선)
		Node root = nodes[index]; // 시작 노드를 가져온다.
		Stack<Node> stack = new Stack<Node>(); // 담을 스택 생성
		stack.push(root); // 스택에 노드를 삽입
		root.marked = true; // 삽입한 노드는 marked true로 바꿔준다
		while(!stack.isEmpty()) { // 스택이 비어있지않다면
			Node r = stack.pop();	//stack에서  노드 가져오기
			for(Node n : r.adjacent) { //가져온 노드의 인접list에 노드들을 꺼내며 반복한다
				if(n.marked == false) { //가져온적없는 것들만
					n.marked = true;  //가져왔다 흔적을 남긴다.
					stack.push(n); //stack에 넣는다
				}
			}
			visit(r); // 처음 꺼냈던 node를 출력
		}
	}
	void bfs() {
		bfs(0);
	}
	void bfs(int index) { //Queue를 이용한 넓이탐색 우선
		Node root = nodes[index];//시작 노드를 가져온다
		Queue<Node> queue = new Queue<Node>(); // Queue생성
		queue.add(root); // Queue에 노드를 넣고
		root.marked = true; // marked true!
		while (!queue.isEmpty()) { // queue가 비어있지않다면
			Node r = queue.remove(); // queue에서 Node를 꺼내와서
			for(Node n : r.adjacent) { // 해당노드의 인접 List를 꺼내와서
				if(n.marked == false) { //꺼내온적없는 노드들만
					n.marked = true; //marked true!
					queue.add(n); // queue에 넣어준다
				}
			}
			visit(r); // 처음 꺼내왔던 node를 출력
		}
	}
	
	void dfsR(Node r) {// 재귀함수를 이용한 dfs
		if (r == null) return; //r이 널이될때까지
		r.marked = true; //마커를 남긴다
		visit(r); // 출력
		for(Node n : r.adjacent) { // 해당 노드의 인접노드들을
			if(n.marked == false) { // 마커가없는것들만
				dfsR(n); // 다시 호출.
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
 * 1ㅡㅡ 3     7
 * |  /| \  /
 * | / |  5
 * 2ㅡㅡ 4   \
 *          6 - 8
 * DFS(0)
 * 0 1 3 5 7 6 8 4 2
 * BFS(0)
 * 0 1 2 3 4 5 6 7 8
 * DFS(0) - Recursive 재귀형식
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
