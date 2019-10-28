package Stack;
import java.util.Stack;

public class StackSort {
//Stack�� �����ϴ� �Լ��� ����ÿ�. ��, �ϳ��� stack�� �߰��� ����Ҽ��ְ� �ٸ�����Ÿ ������ ������� ���Ѵ�.
	
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
	
	//�������� �Ʒ��ΰ���.
	private static void sort(Stack<Integer> s1) {
		Stack<Integer> s2 = new Stack<Integer>();
		while(!s1.isEmpty()) {//s1��  ������������
			int tmp = s1.pop(); // ������ ���� �ӽ÷� ����
			while(!s2.isEmpty() && s2.peek() > tmp) { //s2�� ���� �ְ� �������� tmp���� ũ�ٸ�
				s1.push(s2.pop());//s1�� s2�� �������� �ִ´�
			}
			s2.push(tmp);//s2�� ������ �ӽø� �ִ´�.
		}
		
		while (!s2.isEmpty()) {//s2�� �����������
			s1.push(s2.pop());//s2�� ���� s1�� �ִ´�.
		}
	}
}
