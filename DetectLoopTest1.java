

//try it again!!!



public class DetectLoopTest1 {

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        LinkedList.Node loop = l1.last;
        l1.add(5);
        l1.add(6);
        l1.last.add = loop;
        //l1.printList();

        LinkedList.Node start = l1.start;

        System.out.println(detectLoop(start));
        l1.printList();
    }

    public static int detectLoop(LinkedList.Node start) {
        LinkedList.Node slow, fast;
        slow = fast = start;
        while (slow != null && fast.add != null) {
            slow = slow.add;
            if (fast.add != null) {
                fast = fast.add.add; // 2 hops
            } else {
                return -1;          // next node null => no loop
            }
            if (slow == null || fast == null) // if either hits null..no loop
            {
                return -1;
            }

            if (slow == fast) { // if the two ever meet...we must have a loop
                slow.add = null;
                return 1;
            }
        }
        return -1;
    }
}
