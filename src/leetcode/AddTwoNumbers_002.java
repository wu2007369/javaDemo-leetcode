package leetcode;

/*
＊关于java链表，有个！超级重要！的注意点，语法特性
＊如果next指向的内存为空，那就是无引用。
＊所以你跳过去，那就与前一个节点的联系，彻底断绝了
*/
public class AddTwoNumbers_002 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=l1;
        while (l1.next!=null&&l2.next!=null){
            l1.val+=l2.val;

            if (l1.val>=10){
                l1.val%=10;
                l1.next.val+=1;
            }
            l1=l1.next;
            l2=l2.next;
        }

        l1.val+=l2.val;

        if (l1.next==null&&l2.next==null){
            if (l1.val>=10){
                l1.val%=10;
                l1.next=new ListNode(1);
            }
        }
        if (l2.next!=null){
            l1.next=l2.next;
            l2.next=null;
        }
        while (l1!=null){
            if (l1.val>=10) {
                l1.val%=10;
                if (l1.next!=null)
                l1.next.val+=1;
                else
                    l1.next=new ListNode(1);
            }
            l1=l1.next;
        }

        return result;
    }

    public static void main(String []args){
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(3);

        ListNode l2=new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);
//        ListNode l1=new ListNode(0);
//
//        ListNode l2=new ListNode(7);
//        l2.next=new ListNode(3);

        System.out.println(l1);
        System.out.println(l2);

        System.out.println(addTwoNumbers2(l1,l2));
    }

//合成到一条新的链表吧
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(0);
        ListNode headFirst=result;
        while (l1.next!=null&&l2.next!=null){
            result.val=result.val+l1.val+l2.val;
            result.next=new ListNode(0);
            if (result.val>=10){
                result.val%=10;
                result.next.val+=1;
            }
            l1=l1.next;
            l2=l2.next;
            result=result.next;
        }
        result.val=result.val+l1.val+l2.val;
        if (l1.next!=null)
            result.next=l1.next;
        else
            result.next=l2.next;
//        收尾工作
        while (result!=null){
            if (result.val>=10){
                result.val%=10;
                if (result.next!=null){
                    result.next.val+=1;
                }else{
                    result.next=new ListNode(1);
                }
            }
            result=result.next;
        }
        return headFirst;
    }
}
