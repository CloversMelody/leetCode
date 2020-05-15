/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> combine = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        combine.add(new ArrayList<>(tmp));
        Arrays.sort(nums);
        boolean[] visit = new boolean[nums.length];
        backtrace(nums,combine,tmp,visit,0);
        return combine;                                                                
    }

    private void backtrace(int[] nums, List<List<Integer>> combine, List<Integer> tmp, boolean[] visit, int start){
        for(int i=start;i<nums.length;i++){
            if(i!=0 && nums[i]==nums[i-1] && !visit[i-1]) continue;
            visit[i] = true;
            tmp.add(nums[i]);
            combine.add(new ArrayList<>(tmp));
            backtrace(nums,combine,tmp,visit,i+1);
            visit[i] = false;
            tmp.remove(tmp.size()-1);
        }
    }
}
// @lc code=end

