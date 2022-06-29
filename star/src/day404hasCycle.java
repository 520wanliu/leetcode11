import java.util.HashSet;
import java.util.Set;

public class day404hasCycle<head> {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }


    public boolean hasCycle(ListNode head) {
        /*
        //快慢指针判断是否是环形链表
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;*/


        //哈希表：遍历所有节点，每次遍历到一个节点时，判断该节点此前是否被访问过
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
