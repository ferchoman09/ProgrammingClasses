package class2;

class LinkedList {
    Node head;
    Node tail; // Como Optimizar usando un apuntador a la cola

    public LinkedList() {
        this.head = null;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void addUsingTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode; // Inicializar la cola
        } else {
            tail.next = newNode; // Agregar al final usando la cola
            tail = newNode; // Actualizar la cola
        }
    }

    public void addAtTheBeginning(int data) {
       Node newNode = new Node(data);
       newNode.next = this.head;
       this.head = newNode;
    }

    public void addAtIndex(int data, int index) {
        Node newNode = new Node(data);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }
        if (current != null) {
            newNode.next = current.next;
            current.next = newNode;
        } else {
            System.out.println("Index out of bounds");
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListExample {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(99);
        list.addAtTheBeginning(0);
        list.printList();
    }
}
