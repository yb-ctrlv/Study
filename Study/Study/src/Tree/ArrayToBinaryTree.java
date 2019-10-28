package Tree;

class Tree3{
	class Node{
		int data;
		Node left;
		Node right;
		public Node(int data) {
			this.data = data;
		}
	}
	Node root;
	public void makeTree(int[] a) {
		root = makeTreeR(a, 0, a.length -1);
	}
	private Node makeTreeR(int[] a, int start, int end) {
		if(start > end) return null;
		int mid = (start + end) /2;
		Node node = new Node(a[mid]);
		node.left = makeTreeR(a, start, mid -1);
		node.right = makeTreeR(a, mid+1, end);
		return node;
	}
	public void searchBTree(Node n, int find) {
		if(find < n.data) {
			System.out.println("Data is smaller than "+ n.data);
			searchBTree(n.left, find);
		}else if(find > n.data) {
			System.out.println("Data is bigger than " + n.data);
			searchBTree(n.right, find);
		}else {
			System.out.println("Data found!");
		}
	}
}

//배열을 이진검색트리로 만들기
public class ArrayToBinaryTree {

	public static void main(String[] args) {
		int [] a= new int[10];
		for(int i = 0; i< a.length; i++) {
			a[i] = i;
		}
		Tree3 t= new Tree3();
		t.makeTree(a);
		t.searchBTree(t.root, 2);
	}
}
