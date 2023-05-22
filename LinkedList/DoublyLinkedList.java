package LinkedList;

public class DoublyLinkedList {
    public class Node{
        int data;
        Node next, prev;

        Node(int data){
            this.data = data;
            this.next = this.prev = null;
        }
    }

    public Node head, tail;
    public int size;

    DoublyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public void addFirst(int data){
        Node nn = new Node(data);
        if(head == null){
            head = tail = nn; 
            size++; 
            return;
        }

        head.prev = nn;
        nn.next = head;
        head = nn;
        size++;
        return;
    }

    public void print(){
        Node it = head;
        while(it!=null){
            System.out.print(it.data + "->");
            it = it.next;
        }System.out.println("null");
    }

    public void reversePrint(){
        Node it = tail;
        while(it!=null){
            System.out.print(it.data + "->");
            it = it.prev;
        }System.out.println("null");
    }

    public void reverseList(){
        Node it = head;
        Node temp;
        while(it != null){
            temp = it.next;
            it.next = it.prev;
            it.prev = temp;
            it = it.prev;
        }
        temp = head;
        head = tail;
        tail = temp;

    }
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addFirst(5);
        dll.addFirst(4);
        dll.addFirst(0);
        dll.addFirst(9);
        dll.addFirst(7);

        dll.print();
        dll.reverseList();
        dll.print();
        System.out.println(dll.size);
        System.out.println(dll);
    }
}
