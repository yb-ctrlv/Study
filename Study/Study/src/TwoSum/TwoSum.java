package TwoSum;

import java.util.HashMap;

class Solution{
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i< nums.length; i++) {
			if(map.containsKey(target - nums[i])) return new int[] {
					map.get(target - nums[i]),i	};
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}


public class TwoSum {
	
	public static void main(String[] args) {
		//더해서 5가되는 인덱스2개를 반환하시오.
		int[] nums = {6,4,3,8,7,5,2};
		Solution sol = new Solution();
		int[] result = sol.twoSum(nums, 5);
		System.out.println(result[0] + ","+ result[1]);
	}

}
