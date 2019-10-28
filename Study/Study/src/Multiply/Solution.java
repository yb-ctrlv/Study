package Multiply;

public class Solution {


	public static void main(String[] args) {
//		Multiply(9);//for문을 이용한 방법
//		MultiplyR(9);//재귀를 이용한 방법
	}
	public static void Multiply(int k) {
		for(int i = 1; i<=k; i++) {
			for(int j=1; j<=9; j++) {
				System.out.println(i + " X " + j + " = " + (i*j));
			}
		}
	}
	public static void MultiplyR(int k) {
		if(k>0) {
			MultiplyR(--k);
			MultiplyR2(k+1,9);
		}
	}
	private static void MultiplyR2(int k,int nine) {
		if(nine>0) {
			System.out.println(k + " X " + nine + " = " + (k*nine));
			MultiplyR2(k, --nine);
		}
	}
}
