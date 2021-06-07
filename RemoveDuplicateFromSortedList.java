
public class RemoveDuplicateFromSortedList {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(4);
        list.printList();
        removeDuplicate(list);
        list.printList();
    }

    static void removeDuplicate(LinkedList list) {
        LinkedList.Node temp, start, next;
        start = list.start;
        temp = start;
        while (temp.add != null) {
            next = temp.add;
            while(temp.data == next.data){
                next = next.add;
                temp.add = next;
                if(next==null)
                    return;
            }
            temp = temp.add;
        }
    }
}
