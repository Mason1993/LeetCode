// Given an array of integers, return the top k largest elements
// Min Heap is used with time complexity O(nlogk)

import java.util.*;
public class FindLargestKElements {

	private static class Comp implements Comparator<Integer> {
		@Override
		public int compare (Integer a, Integer b) {
			return a - b;  // min heap
		}
	}
	
	public static int[] getLargestKElements (int[] nums, int k) {
		if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
			return null;
		}
		
		int[] res = new int[k];
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, new Comp());
		for (int i : nums) {
			pq.offer(i);
			if (pq.size() > k) {
				pq.poll();
			}
		}
		
		for (int i = k - 1; i >= 0; i--) {
			res[i] = pq.poll();
		}
		
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {3, 4, 7, 7, 2, 1, 8};
		//int[] res = getLargestKElements(nums, 3);
		System.out.println(Arrays.toString(getLargestKElements(nums, 3)));
	}
}
