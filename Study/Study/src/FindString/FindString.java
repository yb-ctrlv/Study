package FindString;

public class FindString {

	public static void main(String[] args) {

		String a = "aababb";
		solution(a, "ab", 0);

	}

	public static void solution(String str,String target, int k) {
		int result = str.indexOf(target, k);
		if(result==-1) {
			return;
		}else {
			k = result+1;
			solution(str,target,k);
			System.out.println("target�� ��ġ : "+result);
		}
	}

}