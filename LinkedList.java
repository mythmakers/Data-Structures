
public class LinkedList {

    class Node {

        int data;
        Node add;

        Node(int d) {
            data = d;
        }
    }

    Node start, temp, New, prev, next, last;
    private int count = 0;

    public void add(int data) {
        if (start == null) {
            start = new Node(data);
            last = start;
            return;
        }
        New = new Node(data);
        last.add = New;
        last = last.add;
    }

    public void delete(int pos) {
        if (isEmpty()) {
            System.out.println("Nothing to delete, List is Empty!");
            return;
        }
        if (pos == 1) {
            System.out.println(start.data + " is deleted!");
            start = start.add;
        } else if (pos > 1) {
            temp = start;
            while (temp != null) {
                count++;
                if (count == pos) {
                    System.out.println(temp.data + " is deleted");
                    temp = temp.add;
                    prev.add = temp;
                    count = 0;
                    return;
                }
                prev = temp;
                temp = temp.add;
            }
            System.out.println("Not a valid position, list has only " + count + " elements!");
        } else {
            System.out.println("Enter a valid position!");
        }
        count = 0;
    }

    public void insert(int data, int pos) {
        if (isEmpty()) {
            if (pos != 1) {
                System.out.println("List has no elements, Position is incorrect!");
                return;
            }
            start = new Node(data);
            last = start;
            return;
        }
        New = new Node(data);
        if (pos == 1) {
            New.add = start;
            start = New;
        } else if (pos > 1) {
            temp = start;
            while (temp != null) {
                count++;
                if (pos == count) {
                    prev = temp;
                    New.add = prev.add;
                    prev.add = New;
                    count = 0;
                    return;
                }
                temp = temp.add;
            }
            if (pos == count + 1) {
                last.add = New;
                last = last.add;
            } else {
                System.out.println("Not a valid position, list has only " + count + " elements!");
            }
        } else {
            System.out.println("Enter a valid position");
        }
        count = 0;
    }

    boolean isEmpty() {
        return start == null;
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty");
            return;
        }
        temp = start;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.add;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();

        l1.insert(0, 1);
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.printList();
        l1.insert(4, 4);
        l1.printList();
        l1.delete(5);
        l1.printList();
    }
}
