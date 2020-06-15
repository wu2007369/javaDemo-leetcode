package leetcode;

public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

      @Override
      public String toString() {
            String s=" "+val;
            ListNode cur=next;
            while (cur!=null){
                  s+=" "+cur.val;
                  cur=cur.next;
            }
            return s;
      }
}
