package Pibonacci;

class Test {

	public static void main(String[] args) {
		int k = 10;
		for(int i = 0; i< k; i++) {
			System.out.println(Fibonacci(i));
		}
	}

	public static int Fibonacci(int n) {
		// ����Լ� Ȱ��
		if (n <= 1)
			return 1;
		else
			return Fibonacci(n - 1) + Fibonacci(n - 2);
	}
}
