public class QueueLec1 {
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
    public static void main(String args[]){
        ArrayUsingQueue q = new ArrayUsingQueue(5);
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
       while(!q.isEmpty()){
        System.out.print(q.peek()+"");
        q.remove();
       }  
    }
}
