/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        while(head!=null){
            ListNode tail = pre;
            //查看剩余部分长度是否大于等于k
            for(int i=0;i<k;i++){
                tail = tail.next;
                if(tail==null){
                    return hair.next;
                }
            }
            ListNode next = tail.next;
            //翻转子链表
            LinkedList<ListNode> res = myReverse(head,tail);
            head = res.getFirst();
            tail = res.getLast();
            pre.next = head;
            tail.next = next;
            pre = tail;
            head = tail.next;
        }

        return hair.next;
    }

    private LinkedList<ListNode> myReverse(ListNode head, ListNode tail){
        ListNode prev = tail.next;
        ListNode curr = head;
        while(prev!=tail){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        LinkedList<ListNode> res = new LinkedList<>();
        res.add(tail);
        res.add(head);
        return res;
    }
}
// @lc code=end

