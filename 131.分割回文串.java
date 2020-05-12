/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        if(s.length()==0) return ans;
        List<String> tmp = new ArrayList<>();
        backtrace(s,0,0,ans,tmp);
        return ans;
    }

    private void backtrace(String s,int start,int end,List<List<String>> ans,List<String> tmp){
        if(end==s.length()){
            ans.add(tmp);
            return;
        }
        for(int i=start;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String sub = s.substring(i,j);
                if(isPalindrome(sub)){
                    tmp.add(sub);
                    backtrace(s,j,j,ans,tmp);
                    tmp.remove(tmp.size()-1);
                }
            }
        }
    }

    private boolean isPalindrome(String s){
        for(int i=0,j=s.length()-1;i<j;i++,j--){
            if(s.charAt(i)!=s.charAt(j))
                return false;
        }
        return true;
    }
}
// @lc code=end

