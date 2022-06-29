public class day404reverseLinkedList<struct> {
    /*public <ListNode>ListNode reverseList(ListNode head) {
        class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
        *//*
        //头插法反转链表
        ListNode q = null;
        ListNode p = (ListNode) head;
        while (p != null){
            ListNode r = p.next;
            p.next = q;
            q = p;
            p = r;
        }
        return q;*//*

        *//*
        //尾插法反转链表———错误
        ListNode p = (ListNode) head;
        ListNode q = (ListNode) head;
        while (q != null){
            q = q.next;
        }
        while (p != q){
            ListNode r = p.next;
            q.next = p;
            p.next = null;
            p = r;
        }
        return q;*//*
        return null;
    }*/

    public <ListNode>ListNode swapPairs(ListNode head){

        class ListNode{
            int val;
            ListNode next;
            public ListNode() { }
            public ListNode(int val) { this.val = val; }
            public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }

        //迭代交换1
/*
        ListNode h = new ListNode(0);
        h.next = (ListNode)head;
        ListNode p = h;
        while (p.next != null && p.next.next != null){
            ListNode q = p.next;
            ListNode r = q.next;
            q.next = p;
            p.next = r;
            p = r;
        }
        return h.next;*/
/*
        //迭代反转相邻两节点值———运行通过
        ListNode h = new ListNode(0);
        h.next = (ListNode) head;
        ListNode r = h;
        while (r.next != null && r.next.next != null){
            ListNode p = r.next;
            ListNode q = r.next.next;
            r.next = q;
            p.next = q.next;
            q.next = p;
            r = p;
        }
        return h.next;*/

        return null;
    }
}
