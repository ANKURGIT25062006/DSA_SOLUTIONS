/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> bigList =new ArrayList<>();
        int level=0;
        int hd=0;
        TreeMap<Integer, List<Pair<Integer,Integer>>> map = new TreeMap<>();
        helper(root, level, hd, map);
        for(int key: map.keySet()){
            List<Pair<Integer,Integer>> pairList = map.get(key);
            pairList.sort((a,b)-> a.getKey().compareTo(b.getKey())==0 ? a.getValue() - b.getValue() 
            : a.getKey() - b.getKey());
            List<Integer> smallList = new ArrayList<>();
            for(Pair<Integer, Integer> pair: pairList){
                smallList.add(pair.getValue());
            }
            bigList.add(smallList);
        }
        return bigList;
        
    }
    void helper(TreeNode root, int level, int hd, 
    TreeMap<Integer, List<Pair<Integer,Integer>>> map){
        if(root==null){
            return;
        }
        if(!map.containsKey(hd)){
            map.put(hd, new ArrayList<>());
        }
        map.get(hd).add(new Pair(level, root.val));
        helper(root.left, level+1, hd-1, map);
        helper(root.right, level+1, hd+1, map);
    }
}