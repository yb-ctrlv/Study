package Stack;
import java.util.Stack;

public class StackSort {
//Stack을 정렬하는 함수를 만드시오. 단, 하나의 stack을 추가로 사용할수있고 다른데이타 구조는 사용하지 못한다.
	
	public static void main(String[] args) {
		Stack<Integer> s1 = new Stack<Integer>();
		s1.push(3);
		s1.push(5);
		s1.push(1);
		s1.push(6);
		sort(s1);
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println(s1.pop());
	}
	
	//높은수가 아래로간다.
	private static void sort(Stack<Integer> s1) {
		Stack<Integer> s2 = new Stack<Integer>();
		while(!s1.isEmpty()) {//s1이  없어질떄까지
			int tmp = s1.pop(); // 맨위에 값을 임시로 보관
			while(!s2.isEmpty() && s2.peek() > tmp) { //s2에 값이 있고 맨위값이 tmp보다 크다면
				s1.push(s2.pop());//s1에 s2의 맨위값을 넣는다
			}
			s2.push(tmp);//s2의 맨위를 임시를 넣는다.
		}
		
		while (!s2.isEmpty()) {//s2가 비어질떄까지
			s1.push(s2.pop());//s2에 값을 s1에 넣는다.
		}
	}
}
