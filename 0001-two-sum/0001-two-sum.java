class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
        //Brute Force Solution
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
        */
        
        //Better Solution (HashMap)
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int a=nums[i];
            int more= target-a;
            if(map.containsKey(more)){
                return new int[] {map.get(more),i};

            }
            map.put(a,i);
        }
        return new int[]{};
        

        /*
        //Optimal Solution but it does not correctly work beacuse we lost index after sorting
        int left=0, right=nums.length-1;
        Arrays.sort(nums);
        while(left<right){
            int sum=nums[left]+nums[right];
            if(sum==target){
                return new int[]{left,right};
            }
            else if(sum<target) left++;
            else right--;
        }
        return new int[]{};
        */
        
    }
}