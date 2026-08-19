class Solution {
    public int longestConsecutive(int[] nums) {
        //Optimal Solution
        if(nums.length==0) return 0; 
        int longest=1;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        for(int num : set){
            if(!set.contains(num-1)){
                int count=1;
                int x=num;
                while(set.contains(x+1)){
                    x=x+1;
                    count++;
                }
                longest=Math.max(longest,count);
            }

        }
        return longest;



        /*
        //Better Solution
        Arrays.sort(nums);
        int longest=1;
        int countCurr=0;
        int lastSmaller=Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            if(nums[i]-1 == lastSmaller){
                countCurr=countCurr+1;
                lastSmaller=nums[i];
            }
            else if(nums[i] != lastSmaller){
                countCurr=1;
                lastSmaller=nums[i];
            }
            longest= Math.max(longest, countCurr);

        }
        return longest;

         */


        /*
        //Brute Force Solution
        int longest=1;
        for(int i=0; i<nums.length; i++){
            int x=nums[i];
            int count=1;
            while(ls(nums,x+1)==true){
                x=x+1;
                count=count+1;
            }
            if(count>longest){
                longest= count;
            }
        }
        return longest;   
    }
    boolean ls(int[] nums, int num){
        for(int i=0; i<nums.length; i++){
            if(nums[i]==num){
                return true;
            }
            
        } 
        return false;
    }
    */
    }   
}