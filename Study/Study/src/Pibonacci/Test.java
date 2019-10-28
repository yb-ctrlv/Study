package Pibonacci;

class Test {

	public static void main(String[] args) {
		int k = 10;
		for(int i = 0; i< k; i++) {
			System.out.println(Fibonacci(i));
		}
	}

	public static int Fibonacci(int n) {
		// 재귀함수 활용
		if (n <= 1)
			return 1;
		else
			return Fibonacci(n - 1) + Fibonacci(n - 2);
	}
}
