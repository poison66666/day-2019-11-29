import java.util.PriorityQueue;

public class MyPriorityQueue {
    private int[] array;
    private int size;

    //不做扩容考虑
    MyPriorityQueue() {
        array = new int[16];
        size = 0;
    }

    public void offer(int element) {
      array[size++] = element;
      shiftUpBig(array,size-1);
    }

    public int poll() {
        int element = array[0];
        array[0] = array[--size];
        Heap.shiftDowmBig(array, 0, size);
        return element;
    }

    public int peek() {
        //不做错误处理
        return array[0];
    }

    //小堆
    public static void shiftUpSmall(int[] array, int i) {
        while (i != 0) {
            int p = (i - 1) / 2;
            if (array[p] <= array[i]) {
                break;
            }
            swap(array, i, p);
            i = p;
        }
    }

    //大堆
    public static void shiftUpBig(int[] array,int i){
        while(i != 0){
            int p = (i-1)/2;
            if(array[p] >= array[i]){
                break;
            }
            swap(array,i,p);
            i = p;
        }
    }

    private static void swap(int[] array,int index,int size){
        int t = array[index];
        array[index] = array[size];
        array[size] = t;
    }


    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
       q.offer(7);
       q.offer(9);
       q.offer(5);
        System.out.println(q.poll());
        System.out.println(q.poll());
        /*
        MyPriorityQueue queue = new MyPriorityQueue();

        queue.offer(8);
        queue.offer(5);
        queue.offer(2);
        System.out.println(queue.poll());
        queue.offer(7);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        */
    }
}
