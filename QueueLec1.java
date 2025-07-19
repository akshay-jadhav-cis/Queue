
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class QueueLec1 {
    static class QueueUsingStack{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();   
        public boolean isEmpty(){
            return s1.isEmpty();
        }       
        public void add(int data){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }   
        public int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.pop();
        }   
        public int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.peek();
        }   
    }
    static class ArrayUsingQueue{
        static int rear;
        static int arr[];
        ArrayUsingQueue(int size){
            arr = new int[size];
            rear = -1;
        }
        public boolean isEmpty(){
            return rear==-1;
        }
        public void add(int data){
            if(rear==arr.length-1){
                System.out.println("Queue is full");
            }  
            rear=rear+1;
            arr[rear]=data;
          }
        public int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int data = arr[0];
            for(int i=0;i<rear;i++){
                arr[i] = arr[i+1];
            }
            rear--;
            return data;
        }
        public int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[0];
        }

    }
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static class LinkedListusingQueue{
        Node head=null;
        Node tail=null;
        public boolean isEmpty(){
            return head==null;
        }
        public void add(int data){
            Node newNode =new Node(data);
            if(head==null){
                head=tail=newNode;
            }
            tail.next=newNode;
            tail=newNode;
        }
        public int remove(){
            if(isEmpty()){
                return -1;
            }
            int front=head.data;
            if(head==tail){
                head=tail=null;
            } else {
                head=head.next;
            }
            return front;
        }
        public int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }
    }
    // First Non repaeting character in a string
    // using queue
    public static void firstNonRepeatingCharacter(String str){
        Queue<Character> q = new LinkedList<>();
        int[] freq = new int[26];
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            freq[ch-'a']++;
            q.add(ch);
            while(!q.isEmpty()){
                if(freq[q.peek()-'a']==1){
                    System.out.print(q.peek()+" ");
                    break;
                }
                q.remove();
            }
        }
    }
    public static void main(String args[]){
        System.out.println("Queue Using Array");
        ArrayUsingQueue q = new ArrayUsingQueue(5);
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
       while(!q.isEmpty()){
        System.out.print(q.peek()+" ");
        q.remove();
       }  
       System.out.println("Linked List Using Queue");
       LinkedListusingQueue lq = new LinkedListusingQueue();
       lq.add(10);
       lq.add(20);
       lq.add(30);
       lq.add(40);
       lq.add(50);
       while(!lq.isEmpty()){
           System.out.print(lq.peek()+" ");
           lq.remove();
       }
       System.out.println("Stack Using Queue");
         QueueUsingStack qs = new QueueUsingStack();    
         qs.add(10);
            qs.add(20);

            qs.add(30);


            qs.add(40);
            qs.add(50);
            while(!qs.isEmpty()){
                System.out.print(qs.peek()+" ");
                qs.remove();
            }
    }
}
