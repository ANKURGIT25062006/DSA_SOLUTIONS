class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String s_rev = new StringBuilder(s).reverse().toString();
        int i=0;
        while(i<s.length()){
            if(s.charAt(i) != s_rev.charAt(i)) return false;
            i=i+1;
        }
        return true;   
    }
}