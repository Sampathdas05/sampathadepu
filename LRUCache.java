package Design;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/last-stone-weight/discuss/360024/O(nlogn)-and-O(n)-algo
public class LRUCache {
    Map<Integer, ListNode> map;
    int capacity;
    ListNode head;
    ListNode tail;
    public LRUCache(int capacity) {
        map = new HashMap<Integer, ListNode>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        ListNode node = map.get(key);
        remove(node);
        setHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            ListNode node = map.get(key);
            node.val = value;
            remove(node);
            setHead(node);
        }else{
            if(capacity <= map.size()){
                map.remove(tail.key);
                remove(tail);
            }
            ListNode node = new ListNode(key, value);
            setHead(node);
            map.put(key, node);
        }
    }
    
    public void setHead(ListNode node){
        if(head != null){
            head.prev = node;
        }
        node.next = head;
        node.prev = null;
        head = node;
        
        if(tail == null){
            tail = head;
        }
    }
    
    public void remove(ListNode node){
        if(node.next == null){
            tail = node.prev;
        }
        else{
            node.next.prev = node.prev;
        }
        if(node.prev == null){
            head = node.next;
        }
        else{
            node.prev.next = node.next;
        }
    }
    class ListNode{
        ListNode prev; ListNode next;
        int key; int val;
        
        ListNode(int key1, int val1){
            this.key = key1;
            this.val = val1;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
