/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start
class Solution {
    private int len;
    private String s;

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        this.s = s;
        len = s.length();
        if(len==0) return ans;
        List<String> tmp = new ArrayList<>();
        backtrace(0,ans,tmp);
        return ans;
    }

    private void backtrace(int start,List<List<String>> ans,List<String> tmp){
        if(start==s.length()){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=start;i<s.length();i++){
            if(isPalindrome(start,i)){
                tmp.add(s.substring(start,i+1));
                backtrace(i+1,ans,tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }

    private boolean isPalindrome(int left,int right){
        for(int i=left,j=right;i<=j;i++,j--){
            if(s.charAt(i)!=s.charAt(j))
                return false;
        }
        return true;
    }
}
// @lc code=end

