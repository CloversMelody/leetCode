/*
 * @lc app=leetcode.cn id=557 lang=java
 *
 * [557] 反转字符串中的单词 III
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        if(s.length()==0) return s;
        StringBuilder sb = new StringBuilder();
        String[] strs = s.split(" ");
        for(String str:strs){
            appendStr(sb,str);
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    private void appendStr(StringBuilder sb, String s){
        for(int i=s.length()-1;i>=0;i--){
            sb.append(s.charAt(i));
        }
        sb.append(' ');
    }
}
// @lc code=end

