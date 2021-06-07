
public class RemoveDuplicateFromList {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(2);
        list.add(1);
        list.printList();
        removeDuplicate(list);
        list.printList();
    }

    static void removeDuplicate(LinkedList list) {
        LinkedList.Node temp1, temp2, start, prev;
        start = list.start;
        temp1 = start;
        while (temp1 != null) {
            prev = temp1;
            temp2 = temp1.add;
            while (temp2 != null) {
                if (temp1.data == temp2.data) {
                    System.out.println(temp2.data + " is deleted!");
                    temp2 = temp2.add;
                    prev.add = temp2;
                } else {
                    prev = temp2;
                    temp2 = temp2.add;
                }
            }
            temp1 = temp1.add;
        }
    }
}
