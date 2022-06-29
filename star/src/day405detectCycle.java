import java.util.HashSet;
import java.util.Set;

public class day405detectCycle {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head){
/*
        //哈希表：遍历链表中的每个节点，并将它记录下来；一旦遇到了此前遍历过的节点，就可以判定链表中存在环
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode index = head;
        while (index != null){
            if (visited.contains(index)){
                return index;
            }else {
                visited.add(index);
            }
            index = index.next;
        }
        return index;*/

/*
        //快慢指针
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;*/

        return null;
    }
}
