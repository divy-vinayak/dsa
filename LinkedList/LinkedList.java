package LinkedList;
public class LinkedList{
    public class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public Node head;
    public Node tail;
    public int size;
    
    // Default constructor
    // LinkedList(){
    //     head = null;
    //     tail = null;
    // }

    // Methods
    public void addFirst(int n){
        Node newNode = new Node(n);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int n){
        Node newNode = new Node(n);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;

    }

    public void addAt(int i, int n){
        if(i == 0 || head == null){
            addFirst(n);
            return;
        }
        // if n points to the end then use addLast
        if(i == size){
            addLast(n);
            return;
        }
        // if n is out of bounds then don't add
        if(i > size){
            System.out.println("Index i out of bounds for the LinkedList");
            return;
        }

        Node it = head;
        for(int count = 0; count < i-1; count++){
            it = it.next;
        }
        Node temp = it.next;
        it.next = new Node(n);
        it.next.next = temp;
        size++;
    }

    public int removeFirst(){
        if(head == null){
            System.out.println("List is empty.");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }
    
    public int removeLast(){
        if(head == null){
            System.out.println("List is empty.");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        Node it = head;
        while(it.next != tail){
            it = it.next;
        }
        int val = tail.data;
        tail = it;
        tail.next = null;
        size--;
        return val;
    }

    public void print(){
        if(head == null){
            System.out.println("This list is empty.");
            return;
        }
        Node it = head;
        while(it != null){
            System.out.print(it.data + "->");
            it = it.next;
        }System.out.println("null");
    }

    public int findKey(int key){
        Node it = head;
        int count = 0;
        while(it != null){
            if(it.data == key){
                return count;
            }
            count++;
            it = it.next;
        }
        return -1;
    }

    public int findKeyRecursivelyHelper(Node node, int key){
        {
            if(node == null){
                return -1;
            }
            if(node.data == key){
                return 0;
            }
            int foundAt = findKeyRecursivelyHelper(node.next, key);
            return foundAt == -1? foundAt: foundAt + 1;
        }
    }
    public int findKeyRecursively(int key){
        return findKeyRecursivelyHelper(head, key);
    }

    public void reverseList(){
        if(head == null || size == 1){
            return;
        }
        Node prev, curr, nextNode;
        prev = null;
        curr = tail = head;
        nextNode = head.next;
        while(nextNode != null){
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            nextNode = nextNode.next;
        }
        curr.next = prev;
        head = curr;

    }
    
    public void deleteNthFromLast(int n){
        if(size == n){
            head = head.next;
            size--;
            return;
        }
        Node prev = null;
        for(int i = 0; i < size - n; i++){
            if(i==0) prev = head;
            else prev = prev.next;
        }
        prev.next = prev.next.next;
        if(n==1){
            tail = prev;
        }
        size--;
    }
    public void attachTailto(int idx){
        if(head == null) return;
        int i = 0;
        Node it = head;
        while(i!=idx){
            it = it.next;
            i++;
        }
        tail.next = it;
    }
    public boolean hasCycle(){
        if(head == null) return false;
        Node slow, fast;
        slow = fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public void removeCycle(){
        if(hasCycle()){
            Node slow, fast;
            slow = fast = head;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast) break;
            }
            slow = head;
            while(slow.next != fast.next){
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = null;
        }
        else{
            System.out.println("No cycle found.");
        }
    }
    public Node getMid(){
        Node slow, fast;
        slow = head;
        fast = head.next;
        while(fast != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(9);
        ll.addFirst(8);
        ll.addFirst(3);
        ll.addLast(54);
        ll.addFirst(2);
        ll.addLast(23);
        ll.addAt(4,99);
        
        ll.print();

        LinkedList ll2 = new LinkedList();
        ll2.addFirst(5);
        ll2.addFirst(0);
        ll2.addFirst(5);
        ll2.addFirst(4);
        ll2.addFirst(4);
        
        ll2.print();
        
    }
}