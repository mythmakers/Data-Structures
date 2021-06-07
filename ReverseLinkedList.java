
//reverse and loop detection

public class ReverseLinkedList {
    
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.printList();
        reverse(list);
        list.printList();
        System.out.println(detectLoop(list.start));
    }
    static void reverse(LinkedList list){
        LinkedList.Node temp, next, prev;
        temp = list.start;
        prev = null;
        while(temp!=null){
            next = temp.add;
            temp.add = prev;
            prev= temp;
            temp=next;
        }
        list.start = prev;
    }
    
    public static boolean detectLoop(LinkedList.Node start){
        LinkedList.Node slow, fast;
        slow=fast=start;
        
        while(slow!=null && fast.add!=null){
            slow=slow.add;
            if(fast.add != null)
                fast = fast.add.add; // 2 hops
            else
                return false;          // next node null => no loop
    
            if(slow == null || fast == null) // if either hits null..no loop
                return false;
    
            if(slow == fast) // if the two ever meet...we must have a loop
                return true;
        }
        return false;
    }
}
