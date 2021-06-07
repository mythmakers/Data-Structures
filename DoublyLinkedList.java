
public class DoublyLinkedList {

    Node start, temp, New, prev, next, last;
    int count = 0;

    class Node {

        int data;
        Node ladd;
        Node radd;

        Node(int data) {
            this.data = data;
        }
    }

    public void add(int data) {
        if (start == null) {
            start = new Node(data);
            last = start;
            return;
        }
        New = new Node(data);
        last.radd = New;
        New.ladd = last;
        last = last.radd;
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
            New.radd = start;
            start.ladd = New;
            start = New;
        } else if (pos > 1) {
            temp = start;
            while (temp != null) {
                count++;
                if (pos == count) {
                    New.ladd = temp.ladd;
                    temp.ladd.radd = New;
                    temp.ladd = New;
                    New.radd = temp;
                    count = 0;
                    return;
                }
                temp = temp.radd;
            }
            if (pos == count + 1) {
                last.radd = New;
                New.ladd = last;
                last = New;
            } else {
                System.out.println("Not a valid position, list has only " + count + " elements!");
            }
        } else {
            System.out.println("Enter a valid position!");
        }
        count = 0;
    }

    public void delete(int pos) {
        if (isEmpty()) {
            System.out.println("List is empty. Nothing to delete!");
            return;
        }
        if (pos == 1) {
            System.out.println(start.data + " is deleted!");
            start = start.radd;
            start.ladd = null;
        } else if (pos > 1) {
            next = start;
            while (next != null) {
                count++;
                if (pos == count) {
                    System.out.println(next.data + " is deleted!");
                    next = next.radd;
                    if (next != null) {
                        next.ladd = prev;
                    }
                    prev.radd = next;
                    count = 0;
                    return;
                }
                prev = next;
                next = next.radd;
            }
            System.out.println("Invalid postion List has no such index!");
        } else {
            System.out.println("Enter a valid position!");
        }
        count = 0;
    }

    public boolean isEmpty() {
        return start == null;
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        temp = start;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.radd;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        DoublyLinkedList dl = new DoublyLinkedList();

        dl.add(0);
        dl.add(1);
        dl.add(3);
        dl.insert(2, 3);
        dl.printList();
        dl.delete(1);
        dl.printList();
    }

}
