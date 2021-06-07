
public class CircularLinkedList {

    Node start, New, temp, prev, last;
    int count = 0;

    class Node {

        int data;
        Node add;

        Node(int d) {
            data = d;
        }
    }

    void add(int data) {
        if (isEmpty()) {
            start = new Node(data);
            start.add = start;
            last = start;
            return;
        }
        New = new Node(data);
        last.add = New;
        New.add = start;
        last = New;
    }

    void insert(int data, int pos) {
        if (isEmpty()) {
            if (pos != 1) {
                System.out.println("List has no elements, Position is incorrect!");
                return;
            }
            start = new Node(data);
            start.add = start;
            last = start;
            return;
        }
        New = new Node(data);
        if (pos == 1) {
            New.add = start;
            start = New;
            last.add = start;
        } else if (pos > 1) {
            temp = start;
            do {
                count++;
                if (pos == count) {
                    prev.add = New;
                    New.add = temp;
                    count = 0;
                    return;
                }
                prev = temp;
                temp = temp.add;
            } while (temp != start);
            if (pos == count + 1) {
                last.add = New;
                New.add = start;
                last = New;
            } else {
                System.out.println("List has no such index.");
            }
        } else {
            System.out.println("List is Empty!");
        }
        count=0;
    }

    void delete(int pos) {
        if (isEmpty()) {
            System.out.println("List is empty, nothing to delete!");
            return;
        }
        if (pos == 1) {
            System.out.println(start.data + " is deleted!");
            start = start.add;
            last.add = start;
        } else if (pos > 1) {
            temp = start;
            do {
                count++;
                if (pos == count) {
                    System.out.println(temp.data + " is deleted!");
                    temp = temp.add;
                    prev.add = temp;
                    count=0;
                    return;
                }
                prev = temp;
                temp = temp.add;
            } while (temp != start);
            System.out.println("Invalid index to delete!");
        } else {
            System.out.println("Enter valid position!");
        }
    }

    boolean isEmpty() {
        return start == null;
    }

    void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }
        temp = start;
        do {
            System.out.print(temp.data + " ");
            temp = temp.add;
        } while (temp != start);
        System.out.println("");
    }

    public static void main(String[] args) {
        CircularLinkedList cl = new CircularLinkedList();

        cl.add(1);
        cl.add(2);
        cl.add(3);
        cl.printList();
        cl.insert(4, 4);
        cl.printList();
        cl.delete(4);
        cl.printList();
    }

}
