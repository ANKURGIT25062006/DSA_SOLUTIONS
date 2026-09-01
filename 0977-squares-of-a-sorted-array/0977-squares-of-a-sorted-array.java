import java.util.*;
class Solution {
    public int[] sortedSquares(int[] nums) {
        int arr[] = new int[nums.length];
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            arr[left]=nums[left]*nums[left];
            arr[right]=nums[right]*nums[right];
            left++;
            right--;
        }
        Arrays.sort(arr);
        return arr;
        
    }
}