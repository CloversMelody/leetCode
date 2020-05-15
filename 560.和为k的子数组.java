/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] 和为K的子数组
 */

// @lc code=start
class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i] = dp[i-1]+nums[i];
        }
        int cnt = 0;
        for(int i=0;i<nums.length;i++){
            if(dp[i]==k) cnt++;
            for(int j=i+1;j<nums.length;j++){
                if(dp[j]-dp[i]==k)
                    cnt++;
            }
        }
        return cnt;
    }
}
// @lc code=end

