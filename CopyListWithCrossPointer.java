// Similar to Problem CopyListWithRandomPointer, but here .random is replaced by .cross which points to the nodes on other list ONLY. Given two lists, return the two heads of new copied lists. Use one hashmap only and one pass.

public class Solution {
    public List<RandomListNode> copyRandomList(RandomListNode head1, RandomListNode head2) {
        if (head1 == null && head2 == null) {
            return getList(null, null);
        } else if (head1 == null) {
            return getList(null, copyList(head2));
        } else if (head2 == null) {
            return getList(copyList(head1), null);
        }
        
        RandomListNode dummy1 = new RandomListNode(0);
        RandomListNode dummy2 = new RandomListNode(0);
        dummy1.next = head1;
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();  // a hashmap is used to store the mapping between original nodes and copied node
        
        while (head1 != null) { // head is the node in list 1
            if (!map.containsKey(head1)) {
                RandomListNode node1 = new RandomListNode(head1.label);
                map.put(head1, node1);
            }
            if (head1.next != null) {
                RandomListNode node1Next = new RandomListNode(head1.next.label);
                map.get(head1).next = node1Next;
                map.put(head1.next, node1Next);
            }
            if (head1.cross != null) {
                RandomListNode node1Cross = new RandomListNode(head1.cross.label); //node1Cross is the copy node in list 2
                node1Next.cross = node1Cross;
                map.put(head1.cross, node1Cross);
            }           
            head1 = head1.next;
        }

        head1 = dummy1.next;

        RandomListNode node2 = dummy2;
        while (head2 != null) {
            if (map.containsKey(head2)) {
                RandomListNode node2Next = map.get(head2);
            } else {
                RandomListNode node2Next = new RandomListNode(head2.label);
            }
            node2.next = node2Next;
            node2 = node2.next;
            head2 = head2.next;
        }        
        return copyList(map.get(head1), dummy2.next);
    }

    public List<RandomListNode> getList (RandomListNode head1, RandomListNode head2) {
        List<RandomListNode> list = new ArrayList<RandomListNode>();
        list.add(head1);
        list.add(head2);
        return list;
    }
    public RandomListNode copyList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode newHead = dummy;
        while (head != null) {
            newHead.next = new RandomListNode(head.label);
            newHead = newHead.next;
            head = head.next;
        }
        return dummy.next;
    }
}