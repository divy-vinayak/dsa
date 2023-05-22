package LinkedList;
import java.util.LinkedList;
public class JCFLinkedList {
    public static void merge(LinkedList<Integer> ll, int si, int midIdx, int ei){
        LinkedList<Integer> temp = new LinkedList<>();
        int i = si;
        int j = midIdx+1;
        while(i <= midIdx && j <= ei){
            temp.addLast(ll.get(i) < ll.get(j)? ll.get(i++): ll.get(j++));
        }
        while(i <= midIdx) temp.addLast(ll.get(i++));
        while(j <= ei) temp.addLast(ll.get(j++));

        for(int idx = si; idx <= ei; idx++){
            ll.set(idx, temp.removeFirst());
        }
    }
    public static void mergeSort(LinkedList<Integer> ll, int si, int ei){
        if(si >= ei) return;
        
        int midIdx = (si + ei)/2;
        mergeSort(ll, si, midIdx);
        mergeSort(ll, midIdx+1, ei);
        merge(ll, si, midIdx, ei);
    }
    public static void main(String[] args) {
        // create
        LinkedList<Integer> ll = new LinkedList<>();

        // add
        ll.addLast(8);
        ll.addLast(4);
        ll.addLast(2);
        ll.addFirst(9);
        ll.addFirst(6);
        ll.addLast(1);

        System.out.println(ll);
        mergeSort(ll, 0, ll.size()-1);
        System.out.println(ll);
    }
}
