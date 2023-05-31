package Hashing;
import java.util.*;

public class ImplementingHashMap {
    static class HashMap<K,V> { // <K,V> these are called generics
        private class Node{
            K key;
            V value;

            Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n, N; // n
        private LinkedList<Node> bucket[]; // N

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.n = 0;
            this.N = 4;
            this.bucket = new LinkedList[4];
            for(int i = 0; i < 4; i++){
                this.bucket[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key){
            int hc = key.hashCode();
            return Math.abs(hc)%N;
        }

        private int serachInLinkedList(K key, int bi){
            LinkedList<Node> ll = bucket[bi];
            int di = 0;
            for(int i = 0; i < ll.size(); i++){
                Node node = ll.get(i);
                if(node.key == key){
                    return di;
                }
                di++;
            }
            return -1;
        }
        
        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node> oldBucket[] = bucket;
            N = 2*N;
            bucket = new LinkedList[N];
            for(int i = 0; i < bucket.length; i++){
                bucket[i] = new LinkedList<>();
            }
            for(int i = 0; i < oldBucket.length; i++){
                for(int j = 0; j < oldBucket[i].size(); j++){
                    this.put(oldBucket[i].get(j).key, oldBucket[i].get(j).value);
                    oldBucket[i].remove(j);
                }
            }

        }

        public void put(K key, V value){
            int bi = hashFunction(key);
            int di = serachInLinkedList(key, bi);
            if(di == -1){
                bucket[bi].add(new Node(key, value));
                n++;
            }else{
                bucket[bi].get(di).value = value;
            }

            double lambda = (double)n/N;
            if(lambda > 2.0){
                rehash();
            }
        }

        public boolean containsKey(K key){
            int bi = hashFunction(key);
            int di = serachInLinkedList(key, bi);
            if(di != -1){
                return true;
            }else{
                return false;
            }
            // int bi = hashFunction(key);
            // LinkedList<Node> ll = bucket[bi];
            // if(ll.isEmpty()) return false;
            // else{
            //     for(Node n : ll){
            //         if(n.key == key){
            //             return true;
            //         }
            //     }
            // }
            // return false;
        }

        public V get(K key){
            int bi = hashFunction(key);
            int di = serachInLinkedList(key, bi);
            if(di != -1){
                return bucket[bi].get(di).value;
                
            }else{
                return null;
            }
        }

        public V remove(K key){
            int bi = hashFunction(key);
            int di = serachInLinkedList(key, bi);
            if(di != -1){
                V value = bucket[bi].get(di).value;
                bucket[bi].remove(di);
                n--;
                return value;
            }else{
                return null;
            }
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for(int i = 0; i < N; i++){
                if(bucket[i].isEmpty()){
                    continue;
                }
                for(int j = 0; j < bucket[i].size(); j++){
                    keys.add(bucket[i].get(j).key);
                }
            }
            return keys;
        }

        public boolean isEmpty(){
            if(n == 0) return true;
            return false;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("india", 5);
        hm.put("indonesia", 2);
        hm.put("America", 3);
        hm.put("china", 0);
        hm.put("india", 3);
        hm.put("japan", 3);

        ArrayList<String> keys = hm.keySet();
        for(String key : keys){
            System.out.println("Key: " + key + "\t\tValue: "+ hm.get(key));
            hm.remove(key);
        }
        System.out.println(hm.isEmpty());
    }
}
